package co.com.umano.usecase.deleter;

import co.com.umano.model.umanoproduct.UmanoRequest;
import co.com.umano.model.umanoproduct.gateways.UmanoProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleterUseCase {
    private final UmanoProductRepository umanoProductRepository;
    public Mono<Boolean> deleteProduct(UmanoRequest umanoRequest){
        return umanoProductRepository.deleteProduct(umanoRequest);
    }
    public Mono<Boolean> deleteAllProduct(String storeId){
        return umanoProductRepository.deleteAllProduct(storeId);
    }
}
