package com.example.sportspal.ui.RoomQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sportspal.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class RoomQueriesFragment extends Fragment {

    private RoomQueriesViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.room_queries_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RoomQueriesCollectionAdapter collectionAdapter = new RoomQueriesCollectionAdapter(this);
        ViewPager2 viewPager = view.findViewById(R.id.room_queries_ViewPager);
        viewPager.setAdapter(collectionAdapter);
        TabLayout tabLayout = view.findViewById(R.id.room_queries_TabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("Query " + (position + 1))).attach();
    }
}