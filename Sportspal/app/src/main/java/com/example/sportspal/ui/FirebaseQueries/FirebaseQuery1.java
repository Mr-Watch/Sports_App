package com.example.sportspal.ui.FirebaseQueries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.sportspal.R;
import com.example.sportspal.ui.Firebase.MatchFragment;



public class FirebaseQuery1 extends Fragment {
    public FirebaseQuery1() {
        // Required empty public constructor
    }

    public static com.example.sportspal.ui.FirebaseQueries.FirebaseQuery1 newInstance(){
        return new com.example.sportspal.ui.FirebaseQueries.FirebaseQuery1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_firebase_query_1, container, false);
        Button queryButton = root.findViewById(R.id.firebase_query_1_button);

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                RadioGroup typeofRadioGroup = root.findViewById(R.id.firebase_query_1_typeof_RadioGroup);
                int typeofRadioButtonId = typeofRadioGroup.getCheckedRadioButtonId();
                RadioButton typeofRadioButton = getView().findViewById(typeofRadioButtonId);
                bundle.putString("query_typeof",typeofRadioButton.getText().toString());
                MatchFragment matchFragment = new MatchFragment();
                matchFragment.setArguments(bundle);
                getChildFragmentManager().beginTransaction().replace(R.id.firebase_query_1_fragmentContainerView,
                        matchFragment).commit();
            }
        });
        return root;
    }
}