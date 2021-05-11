package com.example.sportspal.ui.Sport;

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

import Database.Classes.Sport;

public class InfoSport extends Fragment {
    private View root;
    private TextView sport_name_textView;
    private TextView sport_id_textView;
    private TextView sport_gender_textView;
    private TextView sport_type_textView;
    private Button deleteSport;
    private Button updateSport;

    private SportViewModel model;

    public InfoSport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_info_sport, container, false);
        model = new ViewModelProvider(requireActivity()).get(SportViewModel.class);

        deleteSport = root.findViewById(R.id.sport_delete_button);
        updateSport = root.findViewById(R.id.sport_update_button);

        deleteSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteSportFromDataBase();
            }
        });

        updateSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSportFromDatabase(v);
            }
        });

        sport_name_textView = root.findViewById(R.id.sport_name_textView);
        sport_id_textView = root.findViewById(R.id.sport_id_textView);
        sport_gender_textView = root.findViewById(R.id.sport_gender_textView);
        sport_type_textView = root.findViewById(R.id.sport_type_textView);

        sport_name_textView.setText(getArguments().getString("sport_name"));
        sport_id_textView.setText(Integer.toString(getArguments().getInt("sport_id")));
        sport_gender_textView.setText(getArguments().getString("sport_gender"));
        sport_type_textView.setText(getArguments().getString("sport_type"));

        return root;
    }

    private void updateSportFromDatabase(View v) {
        Navigation.findNavController(v).navigate(R.id.add_sport, getArguments());
    }

    private void deleteSportFromDataBase() {
        Sport sport = new Sport(
                getArguments().getInt("sport_id"),
                getArguments().getString("sport_name"),
                getArguments().getString("sport_gender"),
                getArguments().getString("sport_type")
        );
        model.deleteSports(sport);
        Toast.makeText(getContext(), "Sport Removed", Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }
}