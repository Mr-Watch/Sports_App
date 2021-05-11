package com.example.sportspal.ui.Team;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.content.Loader;

import com.example.sportspal.MainActivity;
import com.example.sportspal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import org.jetbrains.annotations.NotNull;

import Database.Classes.Team;

public class AddTeam extends Fragment{
    private Button addTeam;
    private EditText team_id_textField;
    private EditText team_name_textField;
    private EditText team_field_name_textField;
    private EditText team_city_textField;
    private EditText team_country_textField;
    private EditText team_sport_id_textField;
    private EditText team_birth_year_textField;
    private TeamViewModel model;
    private Team team = null;

    public AddTeam() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_add_team, container, false);
        addTeam = root.findViewById(R.id.add_team_button);
        team_id_textField = root.findViewById(R.id.team_id_textField);
        team_name_textField = root.findViewById(R.id.team_name_textField);
        team_field_name_textField = root.findViewById(R.id.team_field_name_textField);
        team_city_textField = root.findViewById(R.id.team_city_textField);
        team_country_textField = root.findViewById(R.id.team_country_textField);
        team_sport_id_textField = root.findViewById(R.id.team_sport_id_textField);
        team_birth_year_textField = root.findViewById(R.id.team_birth_year_textField);

        model = new ViewModelProvider(requireActivity()).get(TeamViewModel.class);


        if (getArguments() == null) {
            addTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTeam();
                    addTeamToDataBase();
                }
            });


        } else {
            team_id_textField.setEnabled(false);
            team_id_textField.setText(Integer.toString(getArguments().getInt("team_id")));
            team_name_textField.setText(getArguments().getString("team_name"));
            team_field_name_textField.setText(getArguments().getString("team_field_name"));
            team_city_textField.setText(getArguments().getString("team_city"));
            team_country_textField.setText(getArguments().getString("team_country"));
            team_sport_id_textField.setEnabled(false);
            team_sport_id_textField.setText(Integer.toString(getArguments().getInt("team_sport_id")));
            team_birth_year_textField.setText(Integer.toString(getArguments().getInt("team_birth_year")));

            addTeam.setText("Update");
            addTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTeam();
                    updateTeam();
                }
            });
        }
        return root;
    }

    private void getTeam() {
        String team_id_string = team_id_textField.getText().toString();
        String team_name = team_name_textField.getText().toString();
        String team_field_name = team_field_name_textField.getText().toString();
        String team_city = team_city_textField.getText().toString();
        String team_country = team_country_textField.getText().toString();
        String team_sport_id = team_sport_id_textField.getText().toString();
        String team_birth_year = team_birth_year_textField.getText().toString();


        if (team_id_string.isEmpty() || team_name.isEmpty() || team_field_name.isEmpty() || team_city.isEmpty() || team_country.isEmpty() || team_sport_id.isEmpty() || team_birth_year.isEmpty()) {
            Toast.makeText(getContext(), "No empty fields allowed", Toast.LENGTH_SHORT).show();
            return;
        }

        int team_id = Integer.parseInt(team_id_string);
        int team_Sport_id = Integer.parseInt(team_sport_id);
        int team_Birth_year = Integer.parseInt(team_birth_year);
        team = new Team(team_id, team_name, team_field_name, team_city,team_country,team_Sport_id,team_Birth_year);
    }

    private void addTeamToDataBase() {
        if (team != null) {
            model.insertTeam(team);
            addTeamFS(team);
            Toast.makeText(getContext(), "Team added successfully", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    }

    private void updateTeam() {
        if (team != null) {
            model.updateTeam(team);
            updateTeamFS(team);
            Toast.makeText(getContext(), "Team updated successfully", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    }
    private void addTeamFS(Team team){
        try{
            MainActivity.db.collection("Teams").document(""+team.getTeam_id()).set(team);
        }catch (Exception e){
            String message = e.getMessage();
            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
        }
        }
    private void updateTeamFS(Team team){
        try{
            MainActivity.db.collection("Teams").document(""+team.getTeam_id()).update(
                "teamName", team.getTeamName(),
                    "teamFieldName",team.getTeamFieldName(),
                     "teamCity", team.getTeamCity(),
                     "teamCountry", team.getTeamCountry(),
                     "teamSportId",team.getTeamSportId(),
                     "teamBirthYear", team.getTeamBirthYear()
            );
        }catch (Exception e){
            String message = e.getMessage();
            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
        }
    }
}
