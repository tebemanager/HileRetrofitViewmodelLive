package com.image.hileretrofitviewmodellive.Retrofit;

import androidx.lifecycle.MutableLiveData;

import com.image.hileretrofitviewmodellive.module.ItemsItem;
import com.image.hileretrofitviewmodellive.module.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Charles Raj I on 26/09/21.
 *
 * @author Charles Raj I
 */
public class ServiceRepocitory {

    private ServiceInterface serviceInterface;

    public ServiceRepocitory(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }


    public  void makeCalls(String query, MutableLiveData<List<ItemsItem>> liveData){
        Call<Response> call = serviceInterface.getAllData(query);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    liveData.postValue(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }
}
