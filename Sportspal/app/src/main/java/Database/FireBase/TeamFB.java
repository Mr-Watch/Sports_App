package Database.FireBase;

import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sportspal.MainActivity;

import Database.Classes.Team;

public class TeamFB extends Fragment {
    public TeamFB() {

    }

    public void insertTeamFS(Team team) {
        try {
            MainActivity.db.collection("Teams").document("" + team.getTeamId()).set(team);
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }

    public void updateTeamFS(Team team) {
        try {
            MainActivity.db.collection("Teams").document("" + team.getTeamId()).update(
                    "teamName", team.getTeamName(),
                    "teamFieldName", team.getTeamFieldName(),
                    "teamCity", team.getTeamCity(),
                    "teamCountry", team.getTeamCountry(),
                    "teamSportId", team.getTeamSportId(),
                    "teamBirthYear", team.getTeamBirthYear()
            );
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }

    public void deleteTeamFS(Team team) {
        try {
            MainActivity.db.collection("Teams").document("" + team.getTeamId()).delete();
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }
}
