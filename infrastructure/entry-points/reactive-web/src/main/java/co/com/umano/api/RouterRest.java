package co.com.umano.api;


import co.com.umano.api.config.ProductRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouterRest {
    private final ProductRoutes routes;
    private final Handler handler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route().POST(routes.getList(),handler::getAllProductsWithFilters).build()
                .and(route().GET(routes.getListById(),handler::getProductById).build())
                .and(route().POST(routes.getCreate(),handler::createProduct).build())
                .and(route().PATCH(routes.getUpdate(),handler::updateProduct).build())
                .and(route().DELETE(routes.getDelete(),handler::deleteProduct).build());
    }
}
