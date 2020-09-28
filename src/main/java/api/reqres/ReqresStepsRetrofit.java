package api.reqres;

import io.qameta.allure.Step;
import model.ListUsers;
import model.UserCreate;
import retrofit.controller.ReqresController;

import java.io.IOException;

import static retrofit.client.RetrofitClient.client;

public class ReqresStepsRetrofit {
    private final ReqresController reqresController;
    private final String REQRES_URL = "https://reqres.in/";

    public ReqresStepsRetrofit() {
        this.reqresController = client().withoutAuth(REQRES_URL).create(ReqresController.class);
    }

    @Step("Получение списка пользователей Retrofit")
    public ListUsers getAllListUsers() {
        try {
            return reqresController.getListUsers().execute().body();
        } catch (IOException e) {
            return null;
        }
    }

    @Step("Создание нового пользователя Retrofit")
    public UserCreate createUser() {
        UserCreate user=new UserCreate();
        user.setName("morf");
        user.setJob("nojob");
        try {
            return reqresController.postNewUser(user).execute().body();
        } catch (IOException e) {
            return null;
        }
    }
}
