//package com.example.sportspal.ui.Firebase;
//
//
//import androidx.annotation.NonNull;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.Navigation;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.sportspal.R;
//import com.example.sportspal.ui.Athlete.AthleteViewModel;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.List;
//
//
//import Adapters.AthleteAdapter;
//import Adapters.MatchAdapter;
//
//import com.google.firebase.firestore.FirebaseFirestore;
//
//
//public class MatchFragment extends Fragment implements MatchAdapter {
//
//    private MatchViewModel matchViewModel;
//    private MatchAdapter matchAdapter;
//    private FloatingActionButton fab2;
//    private View root;
//    public static FirebaseFirestore db;
//
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        matchViewModel =
//                new ViewModelProvider(this).get(MatchViewModel.class);
//        root = inflater.inflate(R.layout.fragment_match, container, false);
//        fab2 = root.findViewById(R.id.match_fab);
//        System.out.println(container);
//        fab2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.add_match);
//            }
//        });
//        RecyclerView matchRecyclerView = root.findViewById(R.id.match_recyclerview);
//        matchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        matchRecyclerView.setHasFixedSize(true);
//    }
//}