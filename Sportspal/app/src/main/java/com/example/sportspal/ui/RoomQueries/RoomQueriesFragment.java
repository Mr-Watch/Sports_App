package com.example.sportspal.ui.RoomQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sportspal.R;
import com.example.sportspal.ui.Athlete.AthleteFragment;

public class RoomQueriesFragment extends Fragment {

    private RoomQueriesViewModel mViewModel;
    private Button executeQuery;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.room_queries_fragment, container, false);
        executeQuery = root.findViewById(R.id.button);
        executeQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment athlete = new AthleteFragment();
                getChildFragmentManager().beginTransaction().add(R.id.fragmentContainerView, athlete).commit();
            }
        });

        return root;
    }
}