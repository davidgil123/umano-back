package co.com.umano.api.util;

import co.com.umano.model.umanoproduct.UmanoProduct;
import co.com.umano.model.umanoproduct.UmanoRequest;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class RequestUtil {
    public Mono<String> buildRequestUmanoProductList(ServerRequest serverRequest){
        return Mono.just(serverRequest.headers().firstHeader("store-id"));
    }
    public Mono<UmanoRequest> buildRequestUmanoProductById(ServerRequest serverRequest){
        return Mono.just(serverRequest.pathVariables()).map(variables-> variables.get("id")).map(id->
            UmanoRequest.builder().id(id).storeId(serverRequest.headers().firstHeader("store-id")).build()
        );
    }
    public Mono<List<UmanoProduct>> buildRequestUmanoProduct(ServerRequest serverRequest){
        return serverRequest.bodyToFlux(UmanoProduct.class)
                .map(umanoProduct -> UmanoProduct.builder()
                        .productId(umanoProduct.getProductId())
                        .price(umanoProduct.getPrice())
                        .name(umanoProduct.getName())
                        .category(umanoProduct.getCategory())
                        .description(umanoProduct.getDescription())
                        .quantity(umanoProduct.getQuantity())
                        .size(umanoProduct.getSize())
                        .subCategory(umanoProduct.getSubCategory())
                        .storeId(umanoProduct.getStoreId())
                        .build()).collectList();
    }
    public Mono<UmanoProduct> buildRequestUpdateUmanoProduct(ServerRequest serverRequest){
        return serverRequest.bodyToMono(UmanoProduct.class)
                .map(umanoProduct -> UmanoProduct.builder()
                        .productId(umanoProduct.getProductId())
                        .price(umanoProduct.getPrice())
                        .name(umanoProduct.getName())
                        .category(umanoProduct.getCategory())
                        .description(umanoProduct.getDescription())
                        .quantity(umanoProduct.getQuantity())
                        .size(umanoProduct.getSize())
                        .subCategory(umanoProduct.getSubCategory())
                        .storeId(umanoProduct.getStoreId())
                        .build());
    }
    public Mono<UmanoRequest> buildRequestDeleteUmanoProduct(ServerRequest serverRequest){
        return Mono.just(serverRequest.pathVariables()).map(variables-> variables.get("id")).map(id->
                UmanoRequest.builder().id(id).storeId(serverRequest.headers().firstHeader("store-id")).build()
        );
    }
    public Mono<String> buildRequestDeleteAllUmanoProduct(ServerRequest serverRequest){
        return Mono.just(serverRequest.headers().firstHeader("store-id"));
    }
}
