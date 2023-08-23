package co.com.umano.model.umanoproduct.gateways;

import co.com.umano.model.umanoproduct.UmanoProduct;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UmanoProductRepository {
    Mono<List<UmanoProduct>> getAllProducts(String StoreId);
    Mono<UmanoProduct> getProductById(String id);
    Mono<Boolean> createProducts(List<UmanoProduct> products);
    Mono<Boolean> updateProduct(UmanoProduct product, String id);
    Mono<Boolean> deleteProduct(String id);
}
