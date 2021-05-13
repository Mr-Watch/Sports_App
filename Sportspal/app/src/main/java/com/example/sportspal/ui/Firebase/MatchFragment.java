package com.example.sportspal.ui.Firebase;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
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
import com.example.sportspal.ui.Team.TeamViewModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Adapters.MatchAdapter;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.example.sportspal.MainActivity;

public class MatchFragment extends Fragment implements  MatchAdapter.ListItemClickListener{

    private MatchViewModel matchViewModel;
    private CollectionReference matchesref = MainActivity.db.collection("Matches");
    private MatchAdapter matchAdapter;
    private FloatingActionButton fab2;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_match, container, false);
        fab2 = view.findViewById(R.id.add_match_button);
        System.out.println(container);
        Query query = matchesref.orderBy("country", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Matches> options = new FirestoreRecyclerOptions.Builder<Matches>()
                .setQuery(query, Matches.class)
                .build();

        matchAdapter = new MatchAdapter(options,this);
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

    @Override
    public void onStart(){
        super.onStart();
        matchAdapter.startListening();
    }

    public void onStop(){
        super.onStop();
        matchAdapter.stopListening();
    }
    public void onListItemClick(int position) {

        matchesref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot documentSnapshots) {
                if (documentSnapshots.isEmpty()) {
                    Log.d(this.getClass().toString(), "onSuccess: LIST EMPTY");
                    return;
                } else {
                    List<Matches> matchesList = documentSnapshots.toObjects(Matches.class);
                    Matches matches = matchesList.get(position) ;
                    Bundle bundle = new Bundle();
                    bundle.putString("match_id", matches.getMatch_id());
                    bundle.putString("city", matches.getCity());
                    bundle.putString("country", matches.getCountry());
                    bundle.putString("date", matches.getDate());
                    bundle.putString("typeof", matches.getTypeof());
                    bundle.putInt("sport_id", matches.getSport_id());

                    Navigation.findNavController(view).navigate(R.id.info_match, bundle);
                    Log.d(this.getClass().toString(), "onSuccess: ");
                }

            }
        });

    }
}