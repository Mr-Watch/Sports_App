package com.example.sportspal.ui.FirebaseQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sportspal.R;
import com.example.sportspal.ui.Firebase.MatchFragment;


public class FirebaseQuery2 extends Fragment {
    public FirebaseQuery2() {
    }

    public FirebaseQuery2 newInstance() {
        return new FirebaseQuery2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_firebase_query_2, container, false);
        Button queryButton = root.findViewById(R.id.firebase_query_2_button);
        TextView MonthTextView = root.findViewById(R.id.firebase_query_2_month_editTextNumber);
        TextView YearTextView = root.findViewById(R.id.firebase_query_2_year_editTextNumber);
        TextView dayTextView = root.findViewById(R.id.firebase_query_2_day_editTextNumber);
        queryButton.setOnClickListener(v -> {
            String DATEmatch = dayTextView.getText().toString() + "/" + MonthTextView.getText().toString() + "/" + YearTextView.getText().toString();
            Bundle bundle = new Bundle();

            bundle.putString("query_date", DATEmatch);
            MatchFragment matchFragment = new MatchFragment();
            matchFragment.setArguments(bundle);
            getChildFragmentManager().beginTransaction().replace(R.id.firebase_query_2_fragmentContainerView,
                    matchFragment).commit();
        });
        return root;
    }
}