package com.example.sportspal.ui.RoomQueries;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class RoomQueriesCollectionAdapter extends FragmentStateAdapter {
    public RoomQueriesCollectionAdapter(@NonNull @NotNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new RoomQuery1().newInstance();
                break;
            case 1:
                fragment = new RoomQuery2().newInstance();
                break;
            case 2:
                fragment = new RoomQuery3().newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
