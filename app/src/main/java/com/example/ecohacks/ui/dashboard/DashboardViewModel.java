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


    private final MutableLiveData<String> mEmissionPoints;
    private int iEmissionPoints;
    private final MutableLiveData<String> mCovidPoints;
    private int iCovidPoints;
    private final MutableLiveData<String> mTotalPoints;
    private int iTotalPoints;

    public DashboardViewModel() {

        mEmissionPoints = new MutableLiveData<>();
        mEmissionPoints.setValue(this.getPoints(0, getUUID()));
        //iEmissionPoints = Integer.parseInt(mEmissionPoints.getValue());
        mCovidPoints = new MutableLiveData<>();
        mCovidPoints.setValue(this.getPoints(1 , getUUID()));
        //iCovidPoints = Integer.parseInt(mCovidPoints.getValue());
        //iTotalPoints = iEmissionPoints + iCovidPoints;
        mTotalPoints = new MutableLiveData<>();
        mTotalPoints.setValue(this.getPoints(2, getUUID()));

    }

    public String getPoints(int db, String UUID){
        return String.valueOf(MainActivity.points[db]);
    }
    public String getUUID(){
        String android_id = null;
        Storage storage = StorageOptions.getDefaultInstance().getService();
        String m_szDevIDShort = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            String serial = Build.class.getField("SERIAL").get(null).toString();
            android_id = new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
            return android_id;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
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