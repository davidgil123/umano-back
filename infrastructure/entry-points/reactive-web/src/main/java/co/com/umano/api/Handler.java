package co.com.umano.api;

import co.com.umano.api.util.RequestUtil;
import co.com.umano.api.util.ResponseUtil;
import co.com.umano.usecase.creatorumanoproduct.CreatorUmanoProductUseCase;
import co.com.umano.usecase.deleter.DeleterUseCase;
import co.com.umano.usecase.listar.ListerUseCase;
import co.com.umano.usecase.updaterumanoproduct.UpdaterUmanoProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class Handler {
    private final ListerUseCase listerUseCase;
    private final CreatorUmanoProductUseCase creatorUmanoProductUseCase;
    private final UpdaterUmanoProductUseCase updaterUmanoProductUseCase;
    private final DeleterUseCase deleterUseCase;

    public Mono<ServerResponse> getAllProductsWithFilters(ServerRequest serverRequest) {
        return RequestUtil.buildRequestUmanoProductList(serverRequest)
                .flatMap(listerUseCase::getAllProducts)
                .flatMap(ResponseUtil::buildResponseGetAllProducts);
    }

    public Mono<ServerResponse> getProductById(ServerRequest serverRequest) {
        AtomicReference<String> mensaje= new AtomicReference<>("");
        return RequestUtil.buildRequestUmanoProductById(serverRequest)
                .flatMap(listerUseCase::getProductById)
                .flatMap(ResponseUtil::buildResponseGetProductById);
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        return RequestUtil.buildRequestUpdateUmanoProduct(serverRequest)
                .flatMap(updaterUmanoProductUseCase::updateUmanoProduct)
                .flatMap(ResponseUtil::buildResponseUpdateProduct);
    }
    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        return RequestUtil.buildRequestUmanoProduct(serverRequest)
                .flatMap(creatorUmanoProductUseCase::createUmanoProduct)
                .flatMap(ResponseUtil::buildResponseCreateProduct);
    }

    public Mono<ServerResponse> deleteProduct(ServerRequest serverRequest) {

        return RequestUtil.buildRequestDeleteUmanoProduct(serverRequest)
                .flatMap(deleterUseCase::deleteProduct)
                .flatMap(ResponseUtil::buildResponseDeleteProduct);
    }
    public Mono<ServerResponse> deleteAllProduct(ServerRequest serverRequest) {

        return RequestUtil.buildRequestDeleteAllUmanoProduct(serverRequest)
                .flatMap(deleterUseCase::deleteAllProduct)
                .flatMap(ResponseUtil::buildResponseDeleteAllProduct);
    }
}
