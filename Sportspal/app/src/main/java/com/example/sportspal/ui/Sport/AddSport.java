package com.example.sportspal.ui.Sport;

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

import Database.Classes.Sport;


public class AddSport extends Fragment {
    private Button addSport;
    private EditText sport_id_textField;
    private EditText sport_name_textField;
    private RadioGroup sport_gender_radioGroup;
    private RadioGroup sport_type_radioGroup;
    private SportViewModel model;
    private Sport sport = null;

    public AddSport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_add_sport, container, false);
        addSport = root.findViewById(R.id.add_sport_button);
        sport_id_textField = root.findViewById(R.id.sport_id_textField);
        sport_name_textField = root.findViewById(R.id.sport_name_textField);
        sport_gender_radioGroup = root.findViewById(R.id.sport_gender_radioGroup);
        sport_type_radioGroup = root.findViewById(R.id.sport_type_radioGroup);

        model = new ViewModelProvider(requireActivity()).get(SportViewModel.class);


        if (getArguments() == null) {
            addSport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSport();
                    addSportToDataBase();
                }
            });
        } else {
            sport_id_textField.setEnabled(false);
            sport_id_textField.setText(Integer.toString(getArguments().getInt("sport_id")));
            sport_name_textField.setText(getArguments().getString("sport_name"));

            if (getArguments().getString("sport_gender").equals("Male")) {
                sport_gender_radioGroup.check(R.id.male_radioButton);
            } else {
                sport_gender_radioGroup.check(R.id.female_radioButton);
            }

            if (getArguments().getString("sport_type").equals("Team")) {
                sport_type_radioGroup.check(R.id.team_radioButton);
            } else {
                sport_type_radioGroup.check(R.id.single_radioButton);
            }

            addSport.setText("Update");

            addSport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSport();
                    updateSport();
                }
            });
        }
        return root;
    }

    private void getSport() {
        String sport_id_string = sport_id_textField.getText().toString();
        String sport_name = sport_name_textField.getText().toString();
        int selected_gender_id = sport_gender_radioGroup.getCheckedRadioButtonId();
        int selected_type_id = sport_type_radioGroup.getCheckedRadioButtonId();

        RadioButton selected_gender_button = getView().findViewById(selected_gender_id);
        RadioButton selected_type_button = getView().findViewById(selected_type_id);

        String sport_gender = selected_gender_button.getText().toString();
        String sport_type = selected_type_button.getText().toString();

        if (sport_id_string.isEmpty() || sport_name.isEmpty()) {
            Toast.makeText(getContext(), "No empty fields allowed", Toast.LENGTH_SHORT).show();
            return;
        }

        int sport_id = Integer.parseInt(sport_id_string);
        sport = new Sport(sport_id, sport_name, sport_type, sport_gender);
    }

    private void addSportToDataBase() {
        if (sport != null) {
            model.insertSports(sport);
            Toast.makeText(getContext(), "Sport added successfully", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    }

    private void updateSport() {
        if (sport != null) {
            model.updateSports(sport);
            Toast.makeText(getContext(), "Sport updated successfully", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    }
}