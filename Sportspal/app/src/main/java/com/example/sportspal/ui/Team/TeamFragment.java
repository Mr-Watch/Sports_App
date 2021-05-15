package com.example.sportspal.ui.Team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Adapters.TeamAdapter;
import Database.Classes.Team;

public class TeamFragment extends Fragment implements TeamAdapter.ListItemClickListener {
    private TeamAdapter teamAdapter;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TeamViewModel teamViewModel = new ViewModelProvider(this).get(TeamViewModel.class);
        root = inflater.inflate(R.layout.fragment_team, container, false);
        FloatingActionButton fab = root.findViewById(R.id.team_fab);
        fab.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.add_team));
        RecyclerView teamRecyclerView = root.findViewById(R.id.team_recyclerview);
        teamRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        teamRecyclerView.setHasFixedSize(true);

        teamAdapter = new TeamAdapter(this);
        teamRecyclerView.setAdapter(teamAdapter);

        teamViewModel.getAllTeams().observe(getViewLifecycleOwner(),
                teams -> teamAdapter.setTeams(teams));
        return root;
    }

    @Override
    public void onListItemClick(int position) {
        Team team = teamAdapter.getTeam(position);
        Bundle bundle = new Bundle();
        bundle.putString("team_name", team.getTeamName());
        bundle.putInt("team_id", team.getTeamId());
        bundle.putString("team_city", team.getTeamCity());
        bundle.putString("team_country", team.getTeamCountry());
        bundle.putInt("team_birth_year", team.getTeamBirthYear());
        bundle.putString("team_field_name", team.getTeamFieldName());
        bundle.putInt("team_sport_id", team.getTeamSportId());
        Navigation.findNavController(root).navigate(R.id.info_team, bundle);//need changing
    }
}