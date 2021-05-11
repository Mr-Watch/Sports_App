package com.example.sportspal.ui.RoomQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sportspal.R;

public class RoomQuery3 extends Fragment {
    public RoomQuery3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room_query_3, container, false);
    }

    public Fragment newInstance() {
        return new RoomQuery3();
    }
}