package specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static filter.LogFilter.filters;

/**
 * Предоставляет шаблоны для запроса и ответа, которые могут быть использованы
 * для однотипных запросов.
 */
public class CustomSpec {
    private final RequestSpecification baseRequestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .addFilter(filters().withCustomTemplates())
            .build();

    private final ResponseSpecification baseResponseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .build();

    private static class Initializer {
        private static final CustomSpec spec = new CustomSpec();
    }

    private CustomSpec() {
    }

    public static CustomSpec spec() {
        return Initializer.spec;
    }

    public ResponseSpecification response() {
        return baseResponseSpecification;
    }

    public RequestSpecification request() {
        return baseRequestSpecification;
    }
}
