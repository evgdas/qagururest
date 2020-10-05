package specificationrestassured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static filter.LogFilter.filters;

/**
 * Предоставляет шаблоны для запроса и ответа, которые могут быть использованы
 * для однотипных запросов.
 */
public class DemowebshopSpecification {
    private final RequestSpecification baseRequestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://demowebshop.tricentis.com/")
            .log(LogDetail.ALL)
            .addFilter(filters().withCustomTemplates())
            .addCookie("Nop.customer=8c802d8d-3454-44b6-a83c-c0822ef9c541; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=44; ARRAffinity=ee34a24226ab32a8911d8213bc61638c0a238bf662e0bad7090e344fefc05587")
            .build();

    private final ResponseSpecification baseResponseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .build();

    private static class Initializer {
        private static final DemowebshopSpecification spec = new DemowebshopSpecification();
    }

    private DemowebshopSpecification() {
    }

    public static DemowebshopSpecification specificationDemowebshop() {
        return Initializer.spec;
    }

    public ResponseSpecification response() {
        return baseResponseSpecification;
    }

    public RequestSpecification request() {
        return baseRequestSpecification;
    }
}
