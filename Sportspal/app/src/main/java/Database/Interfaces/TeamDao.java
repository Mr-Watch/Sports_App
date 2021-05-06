package Database.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("SELECT * FROM TEAMS_TABLE")
    LiveData<List<Team>> getAllTeams();
}
