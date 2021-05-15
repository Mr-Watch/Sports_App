package com.example.sportspal.ui.Firebase;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sportspal.MainActivity;
import com.example.sportspal.R;


public class AddMatch extends Fragment {

    private EditText Match_id_textField;
    private EditText Country_textField;
    private EditText City_textField;
    private EditText Date_textField;
    private EditText Sport_id_textField;
    private RadioGroup match_type_radioGroup;
    private EditText Team_id_1;
    private EditText Team_id_2;
    private EditText Team_score_1;
    private EditText Team_score_2;
    private LinearLayout Single_player_layout;

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
        match_type_radioGroup = view.findViewById(R.id.match_type_radioGroup);
        Team_id_1=view.findViewById(R.id.Team1_id_number);
        Team_id_2=view.findViewById(R.id.Team2_id_number);
        Team_score_1=view.findViewById(R.id.Team1_score_number);
        Team_score_2=view.findViewById(R.id.Team2_score_number);
        Single_player_layout=view.findViewById(R.id.Single_player_layout);

        Button addMatch = view.findViewById(R.id.add_matches_button);
        addMatch.setOnClickListener(v -> {
            String var_match_id = Match_id_textField.getText().toString();
            String var_matchCity = City_textField.getText().toString();
            String var_matchCountry = Country_textField.getText().toString();
            int var_matchSport_id = Integer.parseInt(Sport_id_textField.getText().toString());
            String var_matchDate = Date_textField.getText().toString();

            int selected_type_id = match_type_radioGroup.getCheckedRadioButtonId();
            RadioButton selected_type_button = requireView().findViewById(selected_type_id);
            String match_type = selected_type_button.getText().toString();

            try {

                Matches matches = new Matches();
                matches.setCity(var_matchCity);
                matches.setCountry(var_matchCountry);
                matches.setSport_id(var_matchSport_id);
                matches.setDate(var_matchDate);
                matches.setMatch_id(var_match_id);
                if(match_type.equals("Single player")){
                    Singleplayer singleplayer = new Singleplayer(matches);
                    for (int i=0;i<=Single_player_layout.getChildCount();i=i+2){
                        View v1 = Single_player_layout.getChildAt(i);
                        View v2 = Single_player_layout.getChildAt(i+1);
                        EditText et1 = (EditText) v1;
                        EditText et2 = (EditText) v2;
                        if(et1 != null && et2 != null){
                            singleplayer.add(Integer.parseInt(et1.getText().toString()),Integer.parseInt(et2.getText().toString()));}
                    }
                    MainActivity.db.collection("Matches").document(""+var_match_id).set(singleplayer).addOnCompleteListener(task -> Toast.makeText(getActivity(),"Match added.",Toast.LENGTH_LONG).show())
                     .addOnFailureListener(e -> Toast.makeText(getActivity(), "Match added.", Toast.LENGTH_LONG).show());
                }else{
                    int var_team_id_1 = Integer.parseInt(Team_id_1.getText().toString());
                    int var_team_id_2 = Integer.parseInt(Team_id_2.getText().toString());
                    int var_team_score_1 = Integer.parseInt(Team_score_1.getText().toString());
                    int var_team_score_2 = Integer.parseInt(Team_score_2.getText().toString());
                    Teambased teambased = new Teambased(matches,var_team_id_1,var_team_id_2,var_team_score_1,var_team_score_2);

                    MainActivity.db.collection("Matches").document(""+var_match_id).set(teambased).addOnCompleteListener(task -> Toast.makeText(getActivity(),"Match added.",Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getActivity(), "Match added.", Toast.LENGTH_LONG).show());


                }
            }catch (Exception e){
                String message =e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
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