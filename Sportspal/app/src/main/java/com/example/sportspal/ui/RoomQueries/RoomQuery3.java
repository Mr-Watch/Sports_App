package com.example.sportspal.ui.RoomQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportspal.R;
import com.example.sportspal.ui.Team.TeamViewModel;

public class RoomQuery3 extends Fragment {
    public RoomQuery3() {
    }

    public Fragment newInstance() {
        return new RoomQuery3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_room_query_3, container, false);
        TeamViewModel model = new ViewModelProvider(requireActivity()).get(TeamViewModel.class);

        Button queryButton = root.findViewById(R.id.room_query_3_button);
        TextView countAboveTextView = root.findViewById(R.id.room_query_3_above_textView);
        TextView countBelowTextView = root.findViewById(R.id.room_query_3_below_textView);
        TextView countEqualTextView = root.findViewById(R.id.room_query_3_equal_textView);
        TextView countAverageTextView = root.findViewById(R.id.room_query_3_average_textView);
        TextView yearEditText = root.findViewById(R.id.room_query_3_year_editTextNumber);

        queryButton.setOnClickListener(v -> {
            try {
                int year = Integer.parseInt(yearEditText.getText().toString());
                model.getTeamStats(year).observe(getViewLifecycleOwner(), teamStats -> {
                    countAboveTextView.setText(Integer.toString(teamStats.getCountAbove()));
                    countBelowTextView.setText(Integer.toString(teamStats.getCountBelow()));
                    countEqualTextView.setText(Integer.toString(teamStats.getCountEqual()));
                    countAverageTextView.setText(Float.toString(teamStats.getCountAverage()));
                });
            } catch (NumberFormatException ex) {
                Toast.makeText(getContext(), "No empty fields allowed", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}