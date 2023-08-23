package co.com.umano.api;

import co.com.umano.api.util.RequestUtil;
import co.com.umano.api.util.ResponseUtil;
import co.com.umano.usecase.creatorumanoproduct.CreatorUmanoProductUseCase;
import co.com.umano.usecase.listar.ListerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final ListerUseCase listerUseCase;
    private final CreatorUmanoProductUseCase creatorUmanoProductUseCase;
    public Mono<ServerResponse> getAllProductsWithFilters(ServerRequest serverRequest) {
        return RequestUtil.buildRequestUmanoProductList(serverRequest)
                .flatMap(listerUseCase::getAllProducts)
                .flatMap(ResponseUtil::buildResponseGetAllProducts);
    }

    public Mono<ServerResponse> getProductById(ServerRequest serverRequest) {
        return RequestUtil.buildRequestUmanoProductById(serverRequest)
                .flatMap(listerUseCase::getProductById)
                .flatMap(ResponseUtil::buildResponseGetProductById);
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        return RequestUtil.buildRequestUmanoProduct(serverRequest)
                .flatMap(creatorUmanoProductUseCase::createUmanoProduct)
                .flatMap(ResponseUtil::buildResponseCreateProduct);
    }

    public Mono<ServerResponse> deleteProduct(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
