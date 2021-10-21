package aequitas.springbootecommerce.config;

import aequitas.springbootecommerce.model.Product;
import aequitas.springbootecommerce.model.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//a put, post, delete kikapcsolása => konfigurálása -->> implementálni kell a RepositoryRestConfigurer-t
//a Product és a ProductCategory repo-t már csak olvasni lehet (readonly)
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

  //generate -->> implement methods.. -->> a metódus/metódusok kiválasztása, amivel dolgozni akarunk
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
      CorsRegistry cors) {

    HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

    config.getExposureConfiguration()
        .forDomainType(Product.class)
        .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    config.getExposureConfiguration()
        .forDomainType(ProductCategory.class)
        .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

  }

}
