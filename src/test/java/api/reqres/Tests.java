package api.reqres;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import model.ListUsers;
import model.UserCreate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Owner("evgdas")
@Feature("Работа с API reqres.in")
@Tag("api")
public class Tests {
    static ReqresStepsRestAssured reqresStepsRestAssured;
    static ReqresStepsRetrofit reqresStepsRetrofit;

    @BeforeAll
    public static void init() {
        reqresStepsRestAssured = new ReqresStepsRestAssured();
        reqresStepsRetrofit = new ReqresStepsRetrofit();
    }

    @Test
    @DisplayName("Проверка списка пользователей на пустые поля RestAssured")
     public void isNotNullUsersPropertysWithRestAssured() {
        ListUsers listUsers = reqresStepsRestAssured.getAllListUsers();

        assertThat(listUsers.getData(), everyItem(hasProperty("id", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("email", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("first_name", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("last_name", is(notNullValue()))));
    }

    @Test
    @DisplayName("Создание нового пользователя RestAssured")
    public void isNewUserCreatedWithRestAssured() {
        UserCreate newUser = reqresStepsRestAssured.createUser();

        assertThat(newUser.getId(), is(notNullValue()));
        assertThat(newUser.getName(), is(notNullValue()));
        assertThat(newUser.getJob(), is(notNullValue()));
        assertThat(newUser.getCreatedAt(), is(notNullValue()));
    }

    @Test
    @DisplayName("Проверка списка пользователей на пустые поля Retrofit")
    public void isNotNullUsersPropertysWithRetrofit() {
        ListUsers listUsers = reqresStepsRetrofit.getAllListUsers();

        assertThat(listUsers.getData(), everyItem(hasProperty("id", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("email", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("first_name", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("last_name", is(notNullValue()))));
    }

    @Test
    @DisplayName("Создание нового пользователя Retrofit")
    public void isNewUserCreatedWithRetrofit() {
        UserCreate newUser = reqresStepsRetrofit.createUser();

        assertThat(newUser.getId(), is(notNullValue()));
        assertThat(newUser.getName(), is(notNullValue()));
        assertThat(newUser.getJob(), is(notNullValue()));
        assertThat(newUser.getCreatedAt(), is(notNullValue()));
    }
}
