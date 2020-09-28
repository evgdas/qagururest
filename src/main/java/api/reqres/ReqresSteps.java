package api.reqres;

import io.qameta.allure.Step;
import model.ListUsers;

import static io.restassured.RestAssured.given;
import static specification.CustomSpec.spec;

public class ReqresSteps {
    @Step("Получение списка пользователей")
    public ListUsers getListUsers() {
        // @formatter:off
        return
                given().spec(spec().request())
                        .log().uri()
                .when()
                        .get("api/users?page=1")
                .then()
                        .spec(spec().response())
                        .log().body()
                        .extract()
                        .as(ListUsers.class);
        // @formatter:on
    }
}
