package api.reqres;

import io.qameta.allure.Step;
import model.ListUsers;

import static io.restassured.RestAssured.given;
import static specification.CustomSpec.spec;

public class ReqresSteps {
    @Step("Логин на github")
    public ListUsers getListUsers() {
        // @formatter:off
        return
                given().spec(spec().request())
                        .log().uri()
                .when()
                        .get("api/users?page=2")
                .then()
                        .log().body()
                        .extract()
                        .as(ListUsers.class);
        // @formatter:on
    }

//    public void checkThatIssueIsCreated(final int issue,
//                                        final String assignee,
//                                        final String title,
//                                        final String... labels) {
//        // @formatter:off
//        given().spec(spec().request())
//                .log().uri()
//        .when()
//                .get("issues/{issue}", issue)
//        .then()
//                .log().body()
//                .spec(spec().response())//
//        // @formatter:on
//    }
}
