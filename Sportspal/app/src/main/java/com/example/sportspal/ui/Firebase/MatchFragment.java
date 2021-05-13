package com.example.sportspal.ui.Firebase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.MainActivity;
import com.example.sportspal.R;
import com.example.sportspal.ui.Athlete.AthleteViewModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Adapters.MatchAdapter;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.example.sportspal.MainActivity;

public class MatchFragment extends Fragment{


    private CollectionReference matchesref = MainActivity.db.collection("Matches");
    private MatchAdapter matchAdapter;
    private FloatingActionButton fab2;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_match, container, false);

        fab2 = view.findViewById(R.id.add_match_button);
        System.out.println(container);
        SetUpRecyclerview();
        fab2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.add_match);
            }
        });


        RecyclerView matchRecyclerView = view.findViewById(R.id.match_recyclerview);
        matchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        matchRecyclerView.setHasFixedSize(true);
        matchRecyclerView.setAdapter(matchAdapter);


        return view;
    }

    private void SetUpRecyclerview() {
        Query query = matchesref.orderBy("country", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Matches> options = new FirestoreRecyclerOptions.Builder<Matches>()
                .setQuery(query, Matches.class)
                .build();

        matchAdapter = new MatchAdapter(options);
    }

    @Override
    public void onStart(){
        super.onStart();
        matchAdapter.startListening();
    }

    public void onStop(){
        super.onStop();
        matchAdapter.stopListening();
    }
/*
    public void onListItemClick(int position) {
        Matches matches = matchAdapter.getMatches(position);
        Bundle bundle = new Bundle();
        bundle.putString("Match_id", matches.getMatch_id());
        bundle.putString("City", matches.getCity());
        bundle.putString("Country", matches.getCountry());
        bundle.putString("Date", matches.getDate());
        bundle.putString("Typeof", matches.getTypeof());
        bundle.putInt("Sport_id", matches.getSport_id());

        Navigation.findNavController(view).navigate(R.id.info_match, bundle);
    }




 */



}