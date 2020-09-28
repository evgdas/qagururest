package api.reqres;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.ListUsers;
import model.UserCreate;

import static io.restassured.RestAssured.given;
import static specificationrestassured.CustomSpec.spec;

public class ReqresStepsRestAssured {
    @Step("Получение списка пользователей RestAssured")
    public ListUsers getAllListUsers() {
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

    @Step("Создание нового пользователя RestAssured")
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

    @Step("Удаление пользователя")
    public Response deleteUser() {
        // @formatter:off
        return
                given().spec(spec().request())
                .when()
                        .delete("api/users/2");
        // @formatter:on
    }

}
