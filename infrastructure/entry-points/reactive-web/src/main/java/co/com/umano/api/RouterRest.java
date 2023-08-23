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
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route().POST(routes.getList(),handler::getAllProductsWithFilters).build();
    }
}
