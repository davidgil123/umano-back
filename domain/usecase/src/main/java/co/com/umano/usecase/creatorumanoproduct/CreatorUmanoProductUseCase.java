package co.com.umano.usecase.creatorumanoproduct;

import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.gateways.UmanoProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class CreatorUmanoProductUseCase {
    private final UmanoProductRepository umanoProductRepository;
    public Mono<List<UmanoProduct>> createUmanoProduct(List<UmanoProduct> umanoProductList){
        return umanoProductRepository.createProducts(umanoProductList);
    }
}
