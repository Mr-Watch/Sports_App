package com.example.sportspal.ui.Athlete;

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

import Database.Classes.Athlete;

public class InfoAthlete extends Fragment {
    private AthleteViewModel model;

    public InfoAthlete() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info_athlete, container, false);
        model = new ViewModelProvider(requireActivity()).get(AthleteViewModel.class);

        Button deleteAthlete = root.findViewById(R.id.athlete_delete_button);
        Button updateAthlete = root.findViewById(R.id.athlete_update_button);

        deleteAthlete.setOnClickListener(v -> deleteAthleteFromDataBase());

        updateAthlete.setOnClickListener(this::updateAthleteFromDatabase);

        TextView athlete_firstname_textView = root.findViewById(R.id.athlete_firstname_textView);
        TextView athlete_id_textView = root.findViewById(R.id.athlete_id_textView);
        TextView athlete_surname_textView = root.findViewById(R.id.athlete_surname_textView);
        TextView athlete_city_textView = root.findViewById(R.id.athlete_city_textView);
        TextView athlete_country_textView = root.findViewById(R.id.athlete_country_textView);
        TextView athlete_sport_id_textView = root.findViewById(R.id.athlete_sport_id_textView);
        TextView athlete_birth_year_textView = root.findViewById(R.id.athlete_birth_year_textView);

        assert getArguments() != null;
        athlete_firstname_textView.setText(getArguments().getString("athlete_first_name"));
        athlete_id_textView.setText(Integer.toString(getArguments().getInt("athlete_id")));
        athlete_surname_textView.setText(getArguments().getString("athlete_surname"));
        athlete_city_textView.setText(getArguments().getString("athlete_city"));
        athlete_country_textView.setText(getArguments().getString("athlete_country"));
        athlete_sport_id_textView.setText(Integer.toString(getArguments().getInt("athlete_sport_id")));
        athlete_birth_year_textView.setText(Integer.toString(getArguments().getInt("athlete_birth_year")));

        return root;
    }

    private void updateAthleteFromDatabase(View v) {
        Navigation.findNavController(v).navigate(R.id.add_athlete, getArguments());
    }

    private void deleteAthleteFromDataBase() {
        assert getArguments() != null;
        Athlete athlete = new Athlete(
                getArguments().getInt("athlete_id"),
                getArguments().getString("athlete_first_name"),
                getArguments().getString("athlete_surname"),
                getArguments().getString("athlete_city"),
                getArguments().getString("athlete_country"),
                getArguments().getInt("athlete_sport_id"),
                getArguments().getInt("athlete_birth_year")
        );
        model.deleteAthletes(athlete);
        Toast.makeText(getContext(), "Athlete Removed", Toast.LENGTH_SHORT).show();
        requireActivity().onBackPressed();
    }
}