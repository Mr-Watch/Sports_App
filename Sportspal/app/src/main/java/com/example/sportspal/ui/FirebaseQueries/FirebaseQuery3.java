package com.example.sportspal.ui.FirebaseQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sportspal.R;
import com.example.sportspal.ui.Firebase.MatchFragment;


public class FirebaseQuery3 extends Fragment {
    public FirebaseQuery3() {
    }

    public FirebaseQuery3 newInstance() {
        return new FirebaseQuery3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_firebase_query_3, container, false);
        Button queryButton = root.findViewById(R.id.firebase_query_3_button);
        TextView team1TextView = root.findViewById(R.id.firebase_query_3_team1_editTextNumber);
        TextView team2TextView = root.findViewById(R.id.firebase_query_3_team2_editTextNumber);

        queryButton.setOnClickListener(v -> {
            try {

                Bundle bundle = new Bundle();
                int team1 = Integer.parseInt(team1TextView.getText().toString());
                int team2 = Integer.parseInt(team2TextView.getText().toString());
                bundle.putInt("query_team1", team1);
                bundle.putInt("query_team2", team2);
                MatchFragment matchFragment = new MatchFragment();
                matchFragment.setArguments(bundle);
                getChildFragmentManager().beginTransaction().replace(R.id.firebase_query_3_fragmentContainerView,
                        matchFragment).commit();

            } catch (NumberFormatException ex) {
                Toast.makeText(getContext(), "No empty fields allowed", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}