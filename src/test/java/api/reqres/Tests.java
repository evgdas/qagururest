package api.reqres;

import model.ListUsers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
    static ReqresSteps reqresSteps;

    @BeforeAll
    public static void init() {
        reqresSteps = new ReqresSteps();

    }
    @Test
    public void isNotNullUsersPropertys(){
        ListUsers listUsers=reqresSteps.getListUsers();

        assertThat(listUsers.getData(), everyItem(hasProperty("id", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("email", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("first_name", is(notNullValue()))));
        assertThat(listUsers.getData(), everyItem(hasProperty("last_name", is(notNullValue()))));
    }
}
