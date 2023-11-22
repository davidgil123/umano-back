package co.com.umano.usecase.updaterumanoproduct;

import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.gateways.UmanoProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdaterUmanoProductUseCase {
    private final UmanoProductRepository umanoProductRepository;
    public Mono<UmanoProduct> updateUmanoProduct(UmanoProduct umanoProduct){
        return umanoProductRepository.updateProduct(umanoProduct)
                .thenReturn(umanoProduct);
    }
}
