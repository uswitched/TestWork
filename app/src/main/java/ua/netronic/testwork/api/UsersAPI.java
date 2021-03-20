package ua.netronic.testwork.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.netronic.testwork.models.Response;

public interface  UsersAPI {

    @GET(".")
    Observable<Response> getResponse(@Query("results") Integer id);
}
