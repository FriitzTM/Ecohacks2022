package com.example.ecohacks.ui.home;

import androidx.lifecycle.MutableLiveData;

public class Challenge {

    private int length;
    private int type;
    private MutableLiveData<String> description;
    private int value;

    public Challenge(String description, int type, int length, int value){
        this.description = new MutableLiveData<>();
        this.description.setValue(description);
        this.type = type;
        this.length = length;
        this.value = value;
    }

    public int getLength(){
        return length;
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
