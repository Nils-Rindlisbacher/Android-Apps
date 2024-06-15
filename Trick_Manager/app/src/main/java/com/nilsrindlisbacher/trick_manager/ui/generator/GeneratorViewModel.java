package com.nilsrindlisbacher.trick_manager.ui.generator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GeneratorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GeneratorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}