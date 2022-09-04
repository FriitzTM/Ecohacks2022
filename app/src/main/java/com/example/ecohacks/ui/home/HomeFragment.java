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

    private Challenge[] shortChallengeList = {new Challenge("Wear a mask when you go out in crowded areas - 200 points", 1, 200),
    new Challenge("Sanitize whenever you touch something from outside - 100 points", 1, 100),
    new Challenge("Eat in a less crowded area (preferably at home if possible) - 100 points", 1, 100),
    new Challenge("Reduce the heat in your house by 3 degrees - 500 points", 0, 500),
    new Challenge("Buy a t-shirt that was made from recyclable material - 300 points", 0, 300)};
    private Challenge[] mediumChallengeList = {new Challenge("walk/bike somewhere you would usually drive to twice this week - 800 points", 0, 800),
    new Challenge("Try to reduce your driving time by 60 minutes this week - 1000 points", 0, 1000),
    new Challenge("Bring reusable bags every time you go shopping - 1500 points", 0, 1500),
    new Challenge("Wear a mask whenever you go out for 7 days straight - 1200 points", 1, 1200),
    new Challenge("Get 7+ hours of sleep for at least 4 days - 2000 points", 0, 2000),
    new Challenge("Make a travel package with a sanitizer, sanitary wipes, tissues, and spare masks - 900 points", 1, 900)};
    private Challenge[] longChallengeList = {new Challenge("Reduce shower time by 3 minutes - 1000 points", 0, 1000),
    new Challenge("Reduce driving time by 30 minutes on average this month - 2100 points", 0, 2100),
    new Challenge("Consume 40% less meat (especially beef) this month - 3000 points", 0, 3000),
    new Challenge("Bring reusable bags every time you go out for shopping/groceries - 1500 points", 0, 1500),
    new Challenge("Replenish travel package at least 3 times this month - 2000 points", 1, 2000),
    new Challenge("Get at least 2 vaccinations - 4000 points", 1, 4000),
    new Challenge("Make a storage of rapid anti-gen test kits just for safety - 3500 points", 1, 3500),
    new Challenge(" Get an avg of 7 hours of sleep this month - 3500 points", 0, 3500),};
    private int[] currentChallenge = {0, 0, 0};

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView challenge1 = binding.challengeBox1;
        shortChallengeList[currentChallenge[0]].getDescription().observe(getViewLifecycleOwner(), challenge1::setText);

        final CheckBox challenge1Check = binding.checkBox;
        challenge1Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                points[shortChallengeList[currentChallenge[0]].getType()] += shortChallengeList[currentChallenge[0]].getValue();
                points[2] += shortChallengeList[currentChallenge[0]].getValue();
                currentChallenge[0] = new Random().nextInt(shortChallengeList.length);
                shortChallengeList[currentChallenge[0]].getDescription().observe(getViewLifecycleOwner(), challenge1::setText);
                challenge1Check.setChecked(false);
            }
        });

        final TextView challenge2 = binding.challengeBox2;
        mediumChallengeList[currentChallenge[1]].getDescription().observe(getViewLifecycleOwner(), challenge2::setText);

        final CheckBox challenge2Check = binding.checkBox2;
        challenge2Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                points[mediumChallengeList[currentChallenge[1]].getType()] += mediumChallengeList[currentChallenge[1]].getValue();
                points[2] += mediumChallengeList[currentChallenge[1]].getValue();
                currentChallenge[1] = new Random().nextInt(mediumChallengeList.length);
                mediumChallengeList[currentChallenge[1]].getDescription().observe(getViewLifecycleOwner(), challenge2::setText);
                challenge2Check.setChecked(false);
            }
        });

        final TextView challenge3 = binding.ChallengeBox3;
        longChallengeList[currentChallenge[2]].getDescription().observe(getViewLifecycleOwner(), challenge3::setText);

        final CheckBox challenge3Check = binding.checkBox3;
        challenge3Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                points[longChallengeList[currentChallenge[2]].getType()] += longChallengeList[currentChallenge[2]].getValue();
                points[2] += longChallengeList[currentChallenge[2]].getValue();
                currentChallenge[2] = new Random().nextInt(longChallengeList.length);
                longChallengeList[currentChallenge[2]].getDescription().observe(getViewLifecycleOwner(), challenge3::setText);
                challenge3Check.setChecked(false);
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