package api.reqres;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.ListUsers;
import model.UserCreate;

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

    @Step("Создание нового пользователя")
    public UserCreate createUser() {
        String userData = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        // @formatter:off
        return
                given().spec(spec().request())
                        .body(userData)
                .when()
                        .post("api/users")
                .then()
                        .statusCode(201)
                        .log().body()
                        .extract()
                        .as(UserCreate.class);
        // @formatter:on
    }
}
