package com.example.androidtaskdebasish.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidtaskdebasish.model.Item;
import com.example.androidtaskdebasish.repository.UserRepository;

import java.util.List;

public class ActivityViewModel extends ViewModel {

    private MutableLiveData<List<Item>> mutableLiveData;

    private UserRepository userRepository;

    public void init(String searchType){
        if(mutableLiveData != null){
            return;
        }
        userRepository = UserRepository.getInstance();
        mutableLiveData = userRepository.getImages(searchType);
    }
    public LiveData<List<Item>> getImageRepository(){
        return mutableLiveData;
    }

}
