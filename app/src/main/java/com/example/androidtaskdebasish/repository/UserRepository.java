package com.example.androidtaskdebasish.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidtaskdebasish.model.DataClass;
import com.example.androidtaskdebasish.model.Image;
import com.example.androidtaskdebasish.model.Item;
import com.example.androidtaskdebasish.rest.ApiClient;
import com.example.androidtaskdebasish.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public static UserRepository userRepository;

    public static UserRepository getInstance(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    ApiInterface apiInterface;

    public UserRepository(){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public MutableLiveData<List<Item>> getImages(String searchType){
        final  MutableLiveData<List<Item>> imagesData  = new MutableLiveData<>();
        apiInterface.getImages(searchType,"","","image")
                .enqueue(new Callback<DataClass>() {
                    @Override
                    public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                        if(response.body().equals(null)){

                        } else {
                            imagesData.setValue(response.body().getItems());
                        }

                    //    Log.d("!!!responsebody",String.valueOf(response.body().getItems().size()));
                    }

                    @Override
                    public void onFailure(Call<DataClass> call, Throwable t) {
                        Log.d("!!!error",t.toString());
                        imagesData.setValue(null);

                    }
                });
        Log.d("!!!null",imagesData.toString());
        return imagesData;
    }
}
