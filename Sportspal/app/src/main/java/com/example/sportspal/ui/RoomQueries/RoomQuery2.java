package com.example.sportspal.ui.RoomQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;
import com.example.sportspal.ui.Team.TeamViewModel;

import Adapters.TeamCountAdapter;

public class RoomQuery2 extends Fragment {
    public RoomQuery2() {
    }

    public Fragment newInstance() {
        return new RoomQuery2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_room_query_2, container, false);
        TeamViewModel model = new ViewModelProvider(requireActivity()).get(TeamViewModel.class);

        RecyclerView recyclerView = root.findViewById(R.id.room_query_2_recyclerViewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        TeamCountAdapter adapter = new TeamCountAdapter();
        recyclerView.setAdapter(adapter);

        model.getTeamsCount().observe(getViewLifecycleOwner(),
                adapter::setItems);

        return root;
    }
}