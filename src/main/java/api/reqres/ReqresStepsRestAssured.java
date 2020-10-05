package api.reqres;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.ListUsers;
import model.UserCreate;

import static io.restassured.RestAssured.given;
import static specificationrestassured.ReqresSpecification.specificationReqres;

public class ReqresStepsRestAssured {
    @Step("Получение списка пользователей RestAssured")
    public ListUsers getAllListUsers() {
        // @formatter:off
        return
                given().spec(specificationReqres().request())
                        .log().uri()
                .when()
                        .get("api/users?page=1")
                .then()
                        .spec(specificationReqres().response())
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
                given().spec(specificationReqres().request())
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
                given().spec(specificationReqres().request())
                .when()
                        .delete("api/users/2");
        // @formatter:on
    }
}
