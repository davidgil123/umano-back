package co.com.umano.api.util;

import co.com.umano.model.umanoproduct.UmanoProduct;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
@UtilityClass
public class ResponseUtil {
    public Mono<ServerResponse> buildResponseGetAllProducts(List<UmanoProduct> umanoProductList){
        System.out.printf(umanoProductList.toString());
        return (!umanoProductList.isEmpty())? ServerResponse.ok()
                .bodyValue(umanoProductList):ServerResponse.ok().bodyValue("No se encontro lista de productos");
    }
    public Mono<ServerResponse> buildResponseGetProductById(UmanoProduct umanoProduct){
        return (!"000".equals(umanoProduct.getProductId()))? ServerResponse.ok()
                .bodyValue(umanoProduct):ServerResponse.ok().bodyValue("No se encontro registros");
    }
    public Mono<ServerResponse> buildResponseCreateProduct(List<UmanoProduct> umanoProductList){
        return ServerResponse.ok().bodyValue(umanoProductList);
    }
    public Mono<ServerResponse> buildResponseUpdateProduct(UmanoProduct umanoProduct){
        return ServerResponse.ok().bodyValue(umanoProduct);
    }
    public Mono<ServerResponse> buildResponseDeleteProduct(Boolean responseOk){
        return ServerResponse.ok().bodyValue(responseOk);
    }
    public Mono<ServerResponse> buildResponseDeleteAllProduct(Boolean responseOk){
        return ServerResponse.ok().bodyValue("Delete all successfully");
    }
}
