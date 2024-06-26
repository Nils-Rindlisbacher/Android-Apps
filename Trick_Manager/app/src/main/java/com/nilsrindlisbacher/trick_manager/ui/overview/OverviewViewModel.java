package com.nilsrindlisbacher.trick_manager.ui.overview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OverviewViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public OverviewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Trick Overview");
    }

    public LiveData<String> getText() {
        return mText;
    }
}