package Database.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sportspal.ui.Team.TeamCount;

import java.util.List;

import Database.Classes.Sport;
import Database.Classes.Team;

@Dao
public interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTeam(Team... teams);

    @Delete
    void deleteTeam(Team... teams);

    @Update
    void updateTeam(Team... teams);

    @Query("select * from teams_table")
    LiveData<List<Team>> getAllTeams();

    @Query("select count(team_sport_id) as team_count,sport_name,sport_id " +
            "from teams_table,sports_table " +
            "where team_sport_id = sport_id  " +
            "group by team_sport_id " +
            "order by team_count desc")
    LiveData<List<TeamCount>> getTeamsCount();
}
