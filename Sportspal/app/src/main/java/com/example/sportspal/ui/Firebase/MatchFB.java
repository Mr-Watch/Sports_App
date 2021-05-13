package com.example.sportspal.ui.Firebase;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Query;

import com.example.sportspal.MainActivity;

import com.example.sportspal.ui.Firebase.Matches;

public class MatchFB extends Fragment {
    public MatchFB(){

    }


    public void updateMatchFS(Matches matches){

        try {
            MainActivity.db.collection("Matches").document("" + matches.getMatch_id()).update(
                    "City", matches.getCity(),
                    "Country", matches.getCountry(),
                    "Date", matches.getDate(),
                    "Sport_id", matches.getSport_id(),
                    "Typeof", matches.getTypeof()

 );
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }
    public void deleteMatchFS(Matches matches){
        try{
            MainActivity.db.collection("Matches").document("" + matches.getMatch_id()).delete();
        }catch (Exception e){
            String message = e.getMessage();
            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
        }
    }
}