package api.reqres;

import model.ListUsers;
import model.UserCreate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
    static ReqresStepsRestAssured reqresStepsRestAssured;
    static ReqresStepsRetrofit reqresStepsRetrofit;

    @BeforeAll
    public static void init() {
        reqresStepsRestAssured = new ReqresStepsRestAssured();
        reqresStepsRetrofit = new ReqresStepsRetrofit();
    }

    @Test
    public void isNotNullUsersPropertysWithRestAssured() {
        ListUsers listUsers = reqresStepsRestAssured.getAllListUsers();

        assertThat(listUsers.getData(), everyItem(hasProperty("id", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("email", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("first_name", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("last_name", is(notNullValue()))));
    }

    @Test
    public void isNewUserCreatedWithRestAssured() {
        UserCreate newUser = reqresStepsRestAssured.createUser();

        assertThat(newUser.getId(), is(notNullValue()));
        assertThat(newUser.getName(), is(notNullValue()));
        assertThat(newUser.getJob(), is(notNullValue()));
        assertThat(newUser.getCreatedAt(), is(notNullValue()));
    }

    @Test
    public void isNotNullUsersPropertysWithRetrofit() {
        ListUsers listUsers = reqresStepsRetrofit.getAllListUsers();

        assertThat(listUsers.getData(), everyItem(hasProperty("id", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("email", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("first_name", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("last_name", is(notNullValue()))));
    }

    @Test
    public void isNewUserCreatedWithRetrofit() {
        UserCreate newUser = reqresStepsRetrofit.createUser();

        assertThat(newUser.getId(), is(notNullValue()));
        assertThat(newUser.getName(), is(notNullValue()));
        assertThat(newUser.getJob(), is(notNullValue()));
        assertThat(newUser.getCreatedAt(), is(notNullValue()));
    }
}
