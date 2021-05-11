package com.example.sportspal.ui.Firebase;


import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportspal.MainActivity;
import com.example.sportspal.R;



import com.example.sportspal.ui.Firebase.Matches;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import org.jetbrains.annotations.NotNull;


public class AddMatch extends Fragment {

    private Button addMatch;
    private EditText Match_id_textField;
    private EditText Country_textField;
    private EditText City_textField;
    private EditText Date_textField;
    private EditText Sport_id_textField;

    public AddMatch(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_add_match,container,false);
        Match_id_textField = view.findViewById(R.id.Match_id_textField);
        Country_textField = view.findViewById(R.id.Country_textField);
        City_textField = view.findViewById(R.id.City_textField);
        Date_textField = view.findViewById(R.id.Date_textField);
        Sport_id_textField = view.findViewById(R.id.Sport_id_textField);
        addMatch = view.findViewById(R.id.add_matches_button);
        addMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String var_match_id = Match_id_textField.getText().toString();
            String var_matchCity = City_textField.getText().toString();
            String var_matchCountry = Country_textField.getText().toString();
            String var_matchSport_id = Sport_id_textField.getText().toString();
            String var_matchDate = Date_textField.getText().toString();
            try {

                Matches matches = new Matches();
                matches.setCity(var_matchCity);
                matches.setCountry(var_matchCountry);
                matches.setSport_id(var_matchSport_id);
                matches.setDate(var_matchDate);
                MainActivity.db.collection("Matches").document(""+var_match_id).set(matches).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        Toast.makeText(getActivity(),"Match added.",Toast.LENGTH_LONG).show();
                    }
                })
                 .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull @NotNull Exception e) {
                         Toast.makeText(getActivity(), "Match added.", Toast.LENGTH_LONG).show();
                     }
                 });
            }catch (Exception e){
                String message =e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }

        }
    });
        Match_id_textField.setText("");
        Country_textField.setText("");
        City_textField.setText("");
        Date_textField.setText("");
        Sport_id_textField.setText("");
        return  view;
    }
}