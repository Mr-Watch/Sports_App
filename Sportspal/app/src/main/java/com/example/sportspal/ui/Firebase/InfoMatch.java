package com.example.sportspal.ui.Firebase;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.example.sportspal.ui.Firebase.MatchFB;
import com.example.sportspal.R;
import com.example.sportspal.ui.Firebase.Matches;

import java.sql.Timestamp;

import Database.FireBase.TeamFB;


public class InfoMatch extends Fragment {
    private View root;
    private TextView Match_id_textView;
    private TextView Country_textView;
    private TextView City_textView;
    private TextView Date_textView;
    private TextView Sport_id_textView;
    private TextView Typeof_textView;

    private Button deleteMatch;
    private Button updateMatch;

    private MatchFB fDB=null;
    public InfoMatch() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_info_match, container, false);

        deleteMatch = root.findViewById(R.id.match_delete_button);
        updateMatch = root.findViewById(R.id.match_update_button);

      deleteMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMatchFromDataBase();
            }
        });

        updateMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateMatchFromDatabase(v);
            }
        });


        Country_textView = root.findViewById(R.id.Country_textView);
        City_textView = root.findViewById(R.id.City_textView);
        Date_textView = root.findViewById(R.id.Date_textView);
        Sport_id_textView = root.findViewById(R.id.Sport_id_textView);



        Country_textView.setText(getArguments().getString("country"));
        City_textView.setText(getArguments().getString("city"));
        Date_textView.setText(getArguments().getString("date"));
        Sport_id_textView.setText(Integer.toString(getArguments().getInt("sport_id")));


        return root;
    }

    private void updateMatchFromDatabase(View v) {
        Navigation.findNavController(v).navigate(R.id.add_match, getArguments());
    }

    private void deleteMatchFromDataBase() {
        Matches match = new Matches(
                getArguments().getString("Match_id"),
                getArguments().getString("Country"),
                getArguments().getString("City"),
                getArguments().getString("Date"),
                getArguments().getInt("Sport_id"),
                getArguments().getString("Typeof")

                );
        fDB=new MatchFB();
        fDB.deleteMatchFS(match);


        Toast.makeText(getContext(), "Match Removed", Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

}