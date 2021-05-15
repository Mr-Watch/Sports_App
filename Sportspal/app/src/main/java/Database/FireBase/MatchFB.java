package Database.FireBase;

import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sportspal.MainActivity;
import com.example.sportspal.ui.Firebase.Matches;

public class MatchFB extends Fragment {
    public MatchFB() {

    }

    public void deleteMatchFS(Matches matches) {
        try {
            MainActivity.db.collection("Matches").document("" + matches.getMatch_id()).delete();
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }
}