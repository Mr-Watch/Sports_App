package com.example.sportspal.ui.Sport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Adapters.SportAdapter;
import Database.Classes.Sport;

public class SportFragment extends Fragment implements SportAdapter.ListItemClickListener {

    private SportViewModel sportViewModel;
    private SportAdapter sportAdapter;
    private FloatingActionButton fab;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sportViewModel =
                new ViewModelProvider(this).get(SportViewModel.class);
        root = inflater.inflate(R.layout.fragment_sport, container, false);
        fab = root.findViewById(R.id.sport_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.add_sport);
            }
        });
        RecyclerView sportRecyclerView = root.findViewById(R.id.sport_recyclerview);
        sportRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        sportRecyclerView.setHasFixedSize(true);

        sportAdapter = new SportAdapter(this);
        sportRecyclerView.setAdapter(sportAdapter);

        sportViewModel.getAllSports().observe(getViewLifecycleOwner(), new Observer<List<Sport>>() {
            @Override
            public void onChanged(List<Sport> sports) {
                sportAdapter.setSports(sports);
            }
        });
        return root;
    }

    @Override
    public void onListItemClick(int position) {
        Sport sport = sportAdapter.getSport(position);
        Bundle bundle = new Bundle();
        bundle.putString("sport_name", sport.getSportName());
        bundle.putInt("sport_id", sport.getSportId());
        bundle.putString("sport_gender", sport.getSportGender());
        bundle.putString("sport_type", sport.getSportType());
        Navigation.findNavController(root).navigate(R.id.info_sport, bundle);
    }
}