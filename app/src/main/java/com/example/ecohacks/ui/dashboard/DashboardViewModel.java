package com.example.ecohacks.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecohacks.MainActivity;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.security.AccessController.getContext;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;


import android.app.Activity;
import android.os.Build;
import android.provider.Settings.Secure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.io.File;  // Import the File class
import java.io.IOException;

public class DashboardViewModel extends ViewModel {


    private  MutableLiveData<String> mEmissionPoints;
    private  MutableLiveData<String> mCovidPoints;
    private  MutableLiveData<String> mTotalPoints;

    public DashboardViewModel() {

        mEmissionPoints = new MutableLiveData<>();
        mEmissionPoints.setValue(this.getPoints(0));
        mCovidPoints = new MutableLiveData<>();
        mCovidPoints.setValue(this.getPoints(1));
        mTotalPoints = new MutableLiveData<>();
        mTotalPoints.setValue(this.getPoints(2));

    }

    public void setPoints(){
        mEmissionPoints = new MutableLiveData<>();
        mEmissionPoints.setValue(this.getPoints(0));
        mCovidPoints = new MutableLiveData<>();
        mCovidPoints.setValue(this.getPoints(1));
        mTotalPoints = new MutableLiveData<>();
        mTotalPoints.setValue(this.getPoints(2));
    }
    public String getPoints(int db){
        System.out.println(MainActivity.points[db]);
        return String.valueOf(MainActivity.points[db]);
    }

    public LiveData<String> getEmissionPoints() {
        return mEmissionPoints;
    }

    public LiveData<String> getCovidPoints() {
        return mCovidPoints;
    }

    public LiveData<String> getTotalPoints() {
        return mTotalPoints;
    }
}