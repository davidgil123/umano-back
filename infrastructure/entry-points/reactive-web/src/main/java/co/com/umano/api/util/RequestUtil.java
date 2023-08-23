package co.com.umano.api.util;

import co.com.umano.model.umanoproduct.UmanoProduct;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.List;

@UtilityClass
public class RequestUtil {
    public Mono<String> buildRequestUmanoProductList(ServerRequest serverRequest){
        return Mono.just(serverRequest.headers().firstHeader("store-id"));
    }
}
