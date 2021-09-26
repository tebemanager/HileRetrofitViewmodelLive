package com.image.hileretrofitviewmodellive.Retrofit;

import com.image.hileretrofitviewmodellive.module.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Charles Raj I on 26/09/21.
 *
 * @author Charles Raj I
 */
public interface ServiceInterface {

    @GET("repositories")
    Call<Response> getAllData(@Query("q") String query);
}
