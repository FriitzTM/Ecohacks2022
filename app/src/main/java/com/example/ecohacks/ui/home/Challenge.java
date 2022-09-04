package com.example.ecohacks.ui.home;

import androidx.lifecycle.MutableLiveData;

public class Challenge {

    private int type;
    private MutableLiveData<String> description;
    private int value;

    public Challenge(String description, int type, int value){
        this.description = new MutableLiveData<>();
        this.description.setValue(description);
        this.type = type;
        this.value = value;
    }


    public int getType(){
        return type;
    }

    public MutableLiveData<String> getDescription(){
        return description;
    }

    public int getValue(){
        return value;
    }
}
