package com.example.sportspal.ui.FirebaseQueries;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;



import org.jetbrains.annotations.NotNull;

public class FirebaseQueriesCollectionAdapter extends FragmentStateAdapter {
    public FirebaseQueriesCollectionAdapter(@NonNull @NotNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FirebaseQuery1().newInstance();
                break;
            case 1:
                fragment = new FirebaseQuery2().newInstance();
                break;
            case 2:
                fragment = new FirebaseQuery3().newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
