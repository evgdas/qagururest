package api.demowebshop;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Owner("evgdas")
@Feature("Декомпозиция UI to API demowebshop")
@Tag("api")
public class DemowebshopTests {
    static DemowebshopSteps demowebshopSteps;

    @BeforeAll
    public static void init() {
        demowebshopSteps = new DemowebshopSteps();
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addNewItemtoCart() {
        Response response = demowebshopSteps.addItemtoCart();

        assertThat(response.jsonPath().getBoolean("success"), is(true));
    }

    @Test
    @DisplayName("Удаление одного товара из корзины")
    public void removeItemFromCart() {
        //uodate cart, return response with items in cart
        Response response = demowebshopSteps.updateCart("");
        //parse html response for find item ID
        String itemId = response.htmlPath().getString("**.find{it.@name=='removefromcart'}.@value");
        response = demowebshopSteps.updateCart(itemId);
        assertThat(response.getStatusCode(),is(Integer.parseInt("200")));
    }
}
