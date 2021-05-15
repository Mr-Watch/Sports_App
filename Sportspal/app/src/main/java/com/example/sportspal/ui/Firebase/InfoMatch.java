package com.example.sportspal.ui.Firebase;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.sportspal.MainActivity;
import com.example.sportspal.R;
import com.example.sportspal.ui.Firebase.Matches;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;

import Database.FireBase.MatchFB;


public class InfoMatch extends Fragment {
    private View root;
    private TextView Match_id_textView;
    private TextView Country_textView;
    private TextView City_textView;
    private TextView Date_textView;
    private TextView Sport_id_textView;
    private TextView id_score_textview;
    private LinearLayout id_score_layout;

    private Button deleteMatch;
    private Button updateMatch;
    private CollectionReference matchesref = MainActivity.db.collection("Matches");

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

        Match_id_textView = root.findViewById(R.id.Match_id_textView);
        Country_textView = root.findViewById(R.id.Country_textView);
        City_textView = root.findViewById(R.id.City_textView);
        Date_textView = root.findViewById(R.id.Date_textView);
        Sport_id_textView = root.findViewById(R.id.Sport_id_textView);
        id_score_textview=root.findViewById(R.id.id_score_textview);
        id_score_layout=root.findViewById(R.id.id_score_layout);

        Match_id_textView.setText(getArguments().getString("match_id"));
        Country_textView.setText(getArguments().getString("country"));
        City_textView.setText(getArguments().getString("city"));
        Date_textView.setText(getArguments().getString("date"));
        Sport_id_textView.setText(Integer.toString(getArguments().getInt("sport_id")));
        if(getArguments().getString("typeof").equals("Multiplayer")) {
            id_score_textview.setText("Team id:Score");
            TextView a = new TextView(this.getContext());
            TextView b = new TextView(this.getContext());
            matchesref.document(getArguments().getString("match_id")).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Teambased team = documentSnapshot.toObject(Teambased.class);
                    a.setText(team.getTeam_id1()+":"+team.getScore1());
                    id_score_layout.addView(a);
                    b.setText(team.getTeam_id2()+""+team.getScore2());
                    id_score_layout.addView(b);

                }
            });


        }else{
            id_score_textview.setText("Athlete id:Score");
        }
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