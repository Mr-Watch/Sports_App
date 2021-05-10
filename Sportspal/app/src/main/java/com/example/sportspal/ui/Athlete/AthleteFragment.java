package com.example.sportspal.ui.Athlete;

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

import Adapters.AthleteAdapter;
import Database.Classes.Athlete;


public class AthleteFragment extends Fragment implements AthleteAdapter.ListItemClickListener {

    private AthleteViewModel athleteViewModel;
    private AthleteAdapter athleteAdapter;
    private FloatingActionButton fab1;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        athleteViewModel =
                new ViewModelProvider(this).get(AthleteViewModel.class);
        root = inflater.inflate(R.layout.fragment_athlete, container, false);
        fab1 = root.findViewById(R.id.athlete_fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.add_athlete);
            }
        });
        RecyclerView athleteRecyclerView = root.findViewById(R.id.athlete_recyclerview);
        athleteRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        athleteRecyclerView.setHasFixedSize(true);

        athleteAdapter = new AthleteAdapter(this);
        athleteRecyclerView.setAdapter(athleteAdapter);

        athleteViewModel.getAllAthletes().observe(getViewLifecycleOwner(), new Observer<List<Athlete>>() {
            @Override
            public void onChanged(List<Athlete> athletes) {
                athleteAdapter.setAthletes(athletes);
            }
        });
        return root;

    }

    @Override
    public void onListItemClick(int position) {
        Athlete athlete = athleteAdapter.getAthlete(position);
        Bundle bundle = new Bundle();
        bundle.putString("athlete_firstname", athlete.getAthleteFirstName());
        bundle.putInt("athlete_id", athlete.getAthleteId());
        bundle.putString("athlete_surname", athlete.getAthleteSurname());
        bundle.putString("athlete_city", athlete.getAthleteCity());
        bundle.putString("athlete_Country", athlete.getAthleteCountry());
        bundle.putInt("athlete_birth_year", athlete.getAthleteBirthYear());
        bundle.putInt("athlete_sport_id", athlete.getAthleteSportId());
        Navigation.findNavController(root).navigate(R.id.info_athlete, bundle);
    }
}