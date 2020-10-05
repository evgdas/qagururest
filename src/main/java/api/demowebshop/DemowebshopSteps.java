package api.demowebshop;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static specificationrestassured.DemowebshopSpecification.specificationDemowebshop;
import static specificationrestassured.ReqresSpecification.specificationReqres;

public class DemowebshopSteps {
    @Step("Добавление товара в корзину")
    public Response addItemtoCart() {

        return
                given().spec(specificationDemowebshop().request())
                        .log().uri()
                        .when()
                        .post("addproducttocart/details/53/1")
                        .then()
                        .spec(specificationReqres().response())
                        .log().body()
                        .extract().response();
    }

    @Step("Обновление корзины")
    //Если param itemId не пустой, то удаляется один заданный товар
    public Response updateCart(String itemId) {
        String itemRemove = "";
        String itemQuantaty = "";
        if (!itemId.equals("")) {
            itemQuantaty = "itemquantity" + itemId;
            itemRemove = "removefromcart";
        }
        Map<String, String> formParams = new HashMap<>();
        formParams.put(itemQuantaty, "1");
        formParams.put(itemRemove, itemId);
        formParams.put("updatecart", "Update shopping cart");
        return
                given().spec(specificationDemowebshop().request())
                        .log().uri()
                        .config(
                                RestAssured.config()
                                        .encoderConfig(
                                                encoderConfig()
                                                        .encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                        .formParams(formParams)
                        .when()
                        .post("/cart")
                        .then()
                        .spec(specificationReqres().response())
                        .log().body()
                        .extract().response();
    }
}
