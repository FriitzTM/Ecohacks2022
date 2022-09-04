package com.example.ecohacks.ui.home;

import com.example.ecohacks.ui.home.Challenge;

import static com.example.ecohacks.MainActivity.points;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecohacks.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private Challenge[] shortChallengeList = {new Challenge("Wear a mask when you go out in crowded areas", 1, 0, 200),
    new Challenge("Sanitize whenever you touch something from outside", 1, 0, 100),
    new Challenge("Eat in a less crowded area (preferably at home if possible)", 1, 0, 100),
    new Challenge("Reduce shower time by 3 minutes", 0, 0, 100),
    new Challenge("Reduce the heat in your house by 3 degrees", 0, 0, 500),
    new Challenge("Buy a t-shirt that was made from recyclable material", 0, 0, 300)};
    private Challenge[] mediumChallengeList = new Challenge[20];
    private Challenge[] longChallengeList = new Challenge[20];
    private int currentChallenge1 = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView challenge1 = binding.challengeBox1;
        shortChallengeList[currentChallenge1].getDescription().observe(getViewLifecycleOwner(), challenge1::setText);

        final CheckBox challenge1Check = binding.checkBox;
        challenge1Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                points[shortChallengeList[currentChallenge1].getType()] += shortChallengeList[currentChallenge1].getValue();
                points[2] += shortChallengeList[currentChallenge1].getValue();
                currentChallenge1 = new Random().nextInt(shortChallengeList.length);
                shortChallengeList[currentChallenge1].getDescription().observe(getViewLifecycleOwner(), challenge1::setText);
                challenge1Check.setChecked(false);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}