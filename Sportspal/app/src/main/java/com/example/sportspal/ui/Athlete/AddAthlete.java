package com.example.sportspal.ui.Athlete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportspal.R;
import com.example.sportspal.ui.Athlete.AthleteViewModel;

import Database.Classes.Athlete;


public class AddAthlete extends Fragment {

    private Button addAthlete;
    private EditText athlete_id_textField;
    private EditText athlete_firstname_textField;
    private EditText athlete_surname_textField;
    private EditText athlete_city_textField;
    private EditText athlete_country_textField;
    private EditText athlete_sport_id_textField;
    private EditText athlete_birth_year_textField;
    private AthleteViewModel model;
    private Athlete athlete = null;

    public AddAthlete() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_add_sport, container, false);
        addAthlete = root.findViewById(R.id.add_athlete_button);
        athlete_id_textField = root.findViewById(R.id.athlete_id_textField);
        athlete_firstname_textField = root.findViewById(R.id.athlete_firstname_textField);
        athlete_surname_textField = root.findViewById(R.id.athlete_surname_textField);
        athlete_city_textField = root.findViewById(R.id.athlete_city_textField);
        athlete_country_textField = root.findViewById(R.id.athlete_country_textField);
        athlete_sport_id_textField = root.findViewById(R.id.athlete_sport_id_textField);
        athlete_birth_year_textField = root.findViewById(R.id.athlete_birth_year_textField);

        model = new ViewModelProvider(requireActivity()).get(AthleteViewModel.class);


        if (getArguments() == null) {
            addAthlete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getAthlete();
                    addAthleteToDataBase();
                }
            });


        } else {
            athlete_id_textField.setEnabled(false);
            athlete_id_textField.setText(Integer.toString(getArguments().getInt("athlete_id")));
            athlete_firstname_textField.setText(getArguments().getString("athlete_first_name"));
            athlete_firstname_textField.setText(getArguments().getString("athlete_surname"));
            athlete_firstname_textField.setText(getArguments().getString("athlete_city"));
            athlete_firstname_textField.setText(getArguments().getString("athlete_country"));
            athlete_sport_id_textField.setEnabled(false);
            athlete_sport_id_textField.setText(Integer.toString(getArguments().getInt("athlete_sport_id")));
            athlete_birth_year_textField.setEnabled(false);
            athlete_birth_year_textField.setText(Integer.toString(getArguments().getInt("athlete_birth_year")));

            addAthlete.setText("Update");
            addAthlete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getAthlete();
                    updateAthlete();
                }
            });
        }
        return root;
    }

    private void getAthlete() {
        String athlete_id_string = athlete_id_textField.getText().toString();
        String athlete_first_name = athlete_firstname_textField.getText().toString();
        String athlete_surname = athlete_surname_textField.getText().toString();
        String athlete_city = athlete_city_textField.getText().toString();
        String athlete_country = athlete_country_textField.getText().toString();
        String athlete_sport_id = athlete_sport_id_textField.getText().toString();
        String athlete_birth_year = athlete_birth_year_textField.getText().toString();


        if (athlete_id_string.isEmpty() || athlete_first_name.isEmpty() || athlete_surname.isEmpty() || athlete_city.isEmpty() || athlete_country.isEmpty() || athlete_sport_id.isEmpty() || athlete_birth_year.isEmpty()) {
            Toast.makeText(getContext(), "No empty fields allowed", Toast.LENGTH_SHORT).show();
            return;
        }

        int athlete_id = Integer.parseInt(athlete_id_string);
        int athlete_Sport_id = Integer.parseInt(athlete_sport_id);
        int athlete_Birth_year = Integer.parseInt(athlete_birth_year);
        athlete = new Athlete(athlete_id, athlete_first_name, athlete_surname, athlete_city,athlete_country,athlete_Sport_id,athlete_Birth_year);
    }

    private void addAthleteToDataBase() {
        if (athlete != null) {
            model.insertAthletes(athlete);
            Toast.makeText(getContext(), "Athlete added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateAthlete() {
        if (athlete != null) {
            model.updateAthletes(athlete);
            Toast.makeText(getContext(), "Athlete updated successfully", Toast.LENGTH_SHORT).show();
        }
    }
}