package co.com.umano.usecase.listar;

import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.UmanoRequest;
import co.com.umano.model.umanoproduct.gateways.UmanoProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ListerUseCase {
    private final UmanoProductRepository umanoProductRepository;

    public Mono<List<UmanoProduct>> getAllProducts(String storeId){
        return umanoProductRepository.getAllProducts(storeId)
                .switchIfEmpty(Mono.just(List.of(UmanoProduct.builder().productId("000").build())));
    }
    public Mono<UmanoProduct> getProductById(UmanoRequest umanoRequest){
        return umanoProductRepository.getProductById(umanoRequest)
                .switchIfEmpty(Mono.just(UmanoProduct.builder().productId("000").build()));
    }
}
