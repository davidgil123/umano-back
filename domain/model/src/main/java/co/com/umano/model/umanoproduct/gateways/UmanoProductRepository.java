package co.com.umano.model.umanoproduct.gateways;

import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.UmanoRequest;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UmanoProductRepository {
    Mono<List<UmanoProduct>> getAllProducts(String StoreId);
    Mono<UmanoProduct> getProductById(UmanoRequest umanoRequest);
    Mono<List<UmanoProduct>> createProducts(List<UmanoProduct> products);
    Mono<Void> updateProduct(UmanoProduct product);
    Mono<Boolean> deleteProduct(UmanoRequest umanoRequest);
    Mono<Boolean> deleteAllProduct(String storeId);
}
