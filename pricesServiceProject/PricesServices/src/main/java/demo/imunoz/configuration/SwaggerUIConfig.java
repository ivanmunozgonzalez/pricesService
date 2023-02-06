package demo.imunoz.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerUIConfig {

    public static final String PRICE_SERVICE_OPENAPI_RESOURCE_LOCATION = "/api/prices-service.yml";

    @Primary
    @Bean
    public SwaggerResourcesProvider openAPIResourcesProvider() {

	return () -> {
	    List<SwaggerResource> resources = new ArrayList<>();

	    addToResources(resources, "prices service API", PRICE_SERVICE_OPENAPI_RESOURCE_LOCATION);

	    return resources;
	};
    }

    private void addToResources(List<SwaggerResource> resources, String name, String location) {

	SwaggerResource wsResource = new SwaggerResource();
	wsResource.setName(name);
	wsResource.setLocation(location);
	resources.add(wsResource);
    }

}
