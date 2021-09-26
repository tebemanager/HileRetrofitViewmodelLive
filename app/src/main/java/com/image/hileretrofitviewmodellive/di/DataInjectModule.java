package com.image.hileretrofitviewmodellive.di;

import android.app.Service;

import com.image.hileretrofitviewmodellive.Retrofit.ServiceInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Charles Raj I on 26/09/21.
 *
 * @author Charles Raj I
 */

@Module
@InstallIn(SingletonComponent.class)
public class DataInjectModule {

    String baseUrl = "https://api.github.com/search/"; //repositories?q=india

    @Singleton
    @Provides
    public ServiceInterface getServiceInterface(Retrofit retrofit){
        return  retrofit.create(ServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
