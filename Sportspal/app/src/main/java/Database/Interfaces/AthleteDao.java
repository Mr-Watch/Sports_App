package Database.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Database.Classes.Athlete;
import Database.Classes.Sport;

@Dao
public interface AthleteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAthlete(Athlete... athletes);

    @Delete
    void deleteAthlete(Athlete... athletes);

    @Update
    void updateAthlete(Athlete... athletes);

    @Query("SELECT * FROM ATHLETES_TABLE")
    LiveData<List<Athlete>> getAllAthletes();
}
