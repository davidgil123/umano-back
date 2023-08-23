package co.com.umano.api.util;

import co.com.umano.model.umanoproduct.UmanoProduct;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
@UtilityClass
public class ResponseUtil {
    public Mono<ServerResponse> buildResponseGetAllProducts(List<UmanoProduct> umanoProductList){
        return ServerResponse.ok().bodyValue(umanoProductList);
    }
    public Mono<ServerResponse> buildResponseGetProductById(UmanoProduct umanoProduct){
        return ServerResponse.ok().bodyValue(umanoProduct);
    }
    public Mono<ServerResponse> buildResponseCreateProduct(UmanoProduct umanoProduct){
        return ServerResponse.ok().bodyValue(umanoProduct);
    }
}
