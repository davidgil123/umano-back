package co.com.umano.dynamodb;

import co.com.umano.dynamodb.helper.TemplateAdapterOperations;
import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.UmanoRequest;
import co.com.umano.model.umanoproduct.gateways.UmanoProductRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.UUID;


@Repository
public class DynamoDBTemplateAdapter extends TemplateAdapterOperations<UmanoProduct, String, UmanoProductEntity> implements UmanoProductRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.table-name}") final String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d, UmanoProduct.class), tableName);
    }

    @Override
    public Mono<List<UmanoProduct>> getAllProducts(String storeId) {
        var queryConditional = QueryConditional
                .sortGreaterThanOrEqualTo(Key.builder()
                        .partitionValue(AttributeValue
                                .builder().s(storeId)
                                .build())
                        .sortValue(AttributeValue
                                .builder().s(SORT_KEY)
                                .build())
                        .build());

        var queryEnhancedRequest = QueryEnhancedRequest
                .builder()
                .queryConditional(queryConditional)
                .build();

        return super.query(queryEnhancedRequest).map(page ->
                page.stream().toList());
    }

    @Override
    public Mono<UmanoProduct> getProductById(UmanoRequest umanoRequest) {
        return super.getById(umanoRequest.getStoreId(), umanoRequest.getId());
    }

    @Override
    public Mono<List<UmanoProduct>> createProducts(List<UmanoProduct> products) {

        return Flux.fromIterable(products)
                .map(product->{
                    super.save(product).subscribe();
                    return product;
                })
                .collectList();
    }

    @Override
    public Mono<Void> updateProduct(UmanoProduct product) {

        return super.save(product);
    }

    @Override
    public Mono<Boolean> deleteProduct(UmanoRequest umanoRequest) {

        return super.getById(umanoRequest.getStoreId(), umanoRequest.getId())
                .flatMap(umanoProduct-> super.delete(umanoProduct)).thenReturn(true);
    }
    @Override
    public Mono<Boolean> deleteAllProduct(String storeId){
        return this.getAllProducts(storeId)
                .flatMap(umanoProductList -> Flux.fromIterable(umanoProductList).map(umanoProduct -> {
                    super.delete(umanoProduct).subscribe();
                    return umanoProduct;
                }).collectList()).thenReturn(Boolean.TRUE);
    }
}
