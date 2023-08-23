package co.com.umano.usecase.listar;

import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.UmanoRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ListerUseCase {

    public Mono<List<UmanoProduct>> getAllProducts(String storeId){
        return null;
    }
    public Mono<UmanoProduct> getProductById(UmanoRequest umanoRequest){
        return null;
    }
}
