package com.example.sportspal.ui.Team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.sportspal.R;

import Database.Classes.Team;
import Database.FireBase.TeamFB;

public class InfoTeam extends Fragment {
    private TeamViewModel model;

    public InfoTeam() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_info_team, container, false);
        model = new ViewModelProvider(requireActivity()).get(TeamViewModel.class);

        Button deleteTeam = root.findViewById(R.id.team_delete_button);
        Button updateTeam = root.findViewById(R.id.team_update_button);

        deleteTeam.setOnClickListener(v -> deleteTeamFromDataBase());

        updateTeam.setOnClickListener(this::updateTeamFromDatabase);

        TextView team_name_textView = root.findViewById(R.id.team_name_textView);
        TextView team_id_textView = root.findViewById(R.id.team_id_textView);
        TextView team_field_name_textView = root.findViewById(R.id.team_field_name_textView);
        TextView team_city_textView = root.findViewById(R.id.team_city_textView);
        TextView team_country_textView = root.findViewById(R.id.team_country_textView);
        TextView team_sport_id_textView = root.findViewById(R.id.team_sport_id_textView);
        TextView team_birth_year_textView = root.findViewById(R.id.team_birth_year_textView);

        assert getArguments() != null;
        team_name_textView.setText(getArguments().getString("team_name"));
        team_id_textView.setText(Integer.toString(getArguments().getInt("team_id")));
        team_field_name_textView.setText(getArguments().getString("team_field_name"));
        team_city_textView.setText(getArguments().getString("team_city"));
        team_country_textView.setText(getArguments().getString("team_country"));
        team_sport_id_textView.setText(Integer.toString(getArguments().getInt("team_sport_id")));
        team_birth_year_textView.setText(Integer.toString(getArguments().getInt("team_birth_year")));

        return root;
    }

    private void updateTeamFromDatabase(View v) {
        Navigation.findNavController(v).navigate(R.id.add_team, getArguments());
    }

    private void deleteTeamFromDataBase() {
        assert getArguments() != null;
        Team team = new Team(
                getArguments().getInt("team_id"),
                getArguments().getString("team_name"),
                getArguments().getString("team_field_name"),
                getArguments().getString("team_city"),
                getArguments().getString("team_country"),
                getArguments().getInt("team_sport_id"),
                getArguments().getInt("team_birth_year")
        );
        TeamFB fDB = new TeamFB();
        fDB.deleteTeamFS(team);
        model.deleteTeam(team);

        Toast.makeText(getContext(), "Team Removed", Toast.LENGTH_SHORT).show();
        requireActivity().onBackPressed();
    }
}
