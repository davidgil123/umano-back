package co.com.umano.usecase.creatorumanoproduct;

import co.com.umano.model.umanoproduct.UmanoProduct;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatorUmanoProductUseCase {
    public Mono<UmanoProduct> createUmanoProduct(UmanoProduct umanoProduct){
        return Mono.just(umanoProduct);
    }
}
