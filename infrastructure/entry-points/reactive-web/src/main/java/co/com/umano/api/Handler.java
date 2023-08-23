package co.com.umano.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    public Mono<ServerResponse> getAllProductsWithFilters(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getProductById(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> deleteProduct(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
