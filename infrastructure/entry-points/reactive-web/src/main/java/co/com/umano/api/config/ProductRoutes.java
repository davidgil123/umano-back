package co.com.umano.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "umano.paths")
public class ProductRoutes {
    private String list;
    private String listById;
    private String create;
    private String update;
    private String delete;
}
