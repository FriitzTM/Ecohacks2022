package com.example.ecohacks.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecohacks.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView totalEmissionPoints = binding.tEmissionPoints;
        dashboardViewModel.getEmissionPoints().observe(getViewLifecycleOwner(), totalEmissionPoints::setText);
        final TextView totalCovidPoints= binding.tCovidPoints;
        dashboardViewModel.getCovidPoints().observe(getViewLifecycleOwner(), totalCovidPoints::setText);
        final TextView totalOverallPoints= binding.tTotalPoints;
        dashboardViewModel.getTotalPoints().observe(getViewLifecycleOwner(), totalOverallPoints::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}