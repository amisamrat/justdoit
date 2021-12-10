package com.example.justdoit.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("manule book: \nthis is a simple guide book for using this app");
    }

    public LiveData<String> getText() {
        return mText;
    }
}