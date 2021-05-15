package com.example.sportspal.ui.Firebase;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.sportspal.MainActivity;
import com.example.sportspal.R;
import com.google.firebase.firestore.CollectionReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Database.FireBase.MatchFB;


public class InfoMatch extends Fragment {
    private LinearLayout id_score_layout;
    private final CollectionReference matchesref = MainActivity.db.collection("Matches");

    public InfoMatch() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_info_match, container, false);

        Button deleteMatch = root.findViewById(R.id.match_delete_button);
        Button updateMatch = root.findViewById(R.id.match_update_button);

        deleteMatch.setOnClickListener(v -> deleteMatchFromDataBase());

        updateMatch.setOnClickListener(this::updateMatchFromDatabase);

        TextView match_id_textView = root.findViewById(R.id.Match_id_textView);
        TextView country_textView = root.findViewById(R.id.Country_textView);
        TextView city_textView = root.findViewById(R.id.City_textView);
        TextView date_textView = root.findViewById(R.id.Date_textView);
        TextView sport_id_textView = root.findViewById(R.id.Sport_id_textView);
        TextView id_score_textview = root.findViewById(R.id.id_score_textview);
        id_score_layout = root.findViewById(R.id.id_score_layout);

        assert getArguments() != null;
        match_id_textView.setText(getArguments().getString("match_id"));
        country_textView.setText(getArguments().getString("country"));
        city_textView.setText(getArguments().getString("city"));
        date_textView.setText(getArguments().getString("date"));
        sport_id_textView.setText(Integer.toString(getArguments().getInt("sport_id")));
        if (getArguments().getString("typeof").equals("Multiplayer")) {
            id_score_textview.setText("Team id:Score");
            TextView a = new TextView(this.getContext());
            TextView b = new TextView(this.getContext());
            matchesref.document(getArguments().getString("match_id")).get().addOnSuccessListener(documentSnapshot -> {
                Teambased team = documentSnapshot.toObject(Teambased.class);
                a.setText(team.getTeam_id1() + ":" + team.getScore1());
                id_score_layout.addView(a);
                b.setText(team.getTeam_id2() + ":" + team.getScore2());
                id_score_layout.addView(b);
            });


        } else {
            id_score_textview.setText("Athlete id:Score");
            Context c = this.getContext();
            matchesref.document(getArguments().getString("match_id")).get().addOnSuccessListener(documentSnapshot -> {
                Singleplayer athlete = documentSnapshot.toObject(Singleplayer.class);
                assert athlete != null;
                Map<String, Integer> athlete_id_score = new HashMap<>(athlete.getAthlete_id_score());
                Set set = athlete_id_score.entrySet();
                for (Object o : set) {
                    TextView a = new TextView(c);
                    Map.Entry entry = (Map.Entry) o;
                    a.setText(entry.getKey() + ":" + entry.getValue());
                    id_score_layout.addView(a);
                }
            });
        }
        return root;
    }

    private void updateMatchFromDatabase(View v) {
        Navigation.findNavController(v).navigate(R.id.add_match, getArguments());
    }

    private void deleteMatchFromDataBase() {
        assert getArguments() != null;
        Matches match = new Matches(
                getArguments().getString("Match_id"),
                getArguments().getString("Country"),
                getArguments().getString("City"),
                getArguments().getString("Date"),
                getArguments().getInt("Sport_id"),
                getArguments().getString("Typeof")

        );
        MatchFB fDB = new MatchFB();
        fDB.deleteMatchFS(match);

        Toast.makeText(getContext(), "Match Removed", Toast.LENGTH_SHORT).show();
        requireActivity().onBackPressed();
    }

}