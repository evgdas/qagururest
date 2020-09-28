package retrofit.controller;

import model.ListUsers;
import model.UserCreate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReqresController {
    @GET("api/users?page=1")
    Call<ListUsers> getListUsers();

    @POST("api/users")
    Call<UserCreate> postNewUser(@Body UserCreate user);
}
