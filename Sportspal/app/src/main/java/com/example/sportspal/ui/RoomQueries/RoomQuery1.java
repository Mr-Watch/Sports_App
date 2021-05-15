package com.example.sportspal.ui.RoomQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.sportspal.R;
import com.example.sportspal.ui.Athlete.AthleteFragment;

public class RoomQuery1 extends Fragment {
    public RoomQuery1() {
    }

    public Fragment newInstance() {
        return new RoomQuery1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_room_query_1, container, false);
        Button queryButton = root.findViewById(R.id.room_query_1_button);

        queryButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            RadioGroup genderRadioGroup = root.findViewById(R.id.room_query_1_gender_RadioGroup);
            int genderRadioButtonId = genderRadioGroup.getCheckedRadioButtonId();
            RadioButton genderRadioButton = requireView().findViewById(genderRadioButtonId);
            bundle.putString("query_gender", genderRadioButton.getText().toString());
            AthleteFragment athleteFragment = new AthleteFragment();
            athleteFragment.setArguments(bundle);
            getChildFragmentManager().beginTransaction().replace(R.id.room_query_1_fragmentContainerView,
                    athleteFragment).commit();
        });
        return root;
    }
}