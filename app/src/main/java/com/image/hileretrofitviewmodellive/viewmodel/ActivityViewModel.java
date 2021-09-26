package com.image.hileretrofitviewmodellive.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.image.hileretrofitviewmodellive.Retrofit.ServiceInterface;
import com.image.hileretrofitviewmodellive.Retrofit.ServiceRepocitory;
import com.image.hileretrofitviewmodellive.module.ItemsItem;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * Created by Charles Raj I on 26/09/21.
 *
 * @author Charles Raj I
 */


@HiltViewModel
public class ActivityViewModel extends androidx.lifecycle.ViewModel {

    MutableLiveData<List<ItemsItem>> liveData;

    @Inject
    ServiceInterface serviceInterface;

    @Inject
    public ActivityViewModel(){
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<ItemsItem>> getLiveData() {
        return liveData;
    }

    public void makeApiCall(){
        ServiceRepocitory repocitory = new ServiceRepocitory(serviceInterface);
        repocitory.makeCalls("us",liveData);
    }
}
