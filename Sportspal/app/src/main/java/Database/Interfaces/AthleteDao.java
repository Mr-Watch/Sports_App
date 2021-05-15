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

@Dao
public interface AthleteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAthlete(Athlete... athletes);

    @Delete
    void deleteAthlete(Athlete... athletes);

    @Update
    void updateAthlete(Athlete... athletes);

    @Query("select * from athletes_table")
    LiveData<List<Athlete>> getAllAthletes();

    @Query("select * " +
            "from athletes_table " +
            "where athlete_sport_id in" +
            "(select sport_id from sports_table where sport_gender = :gender)")
    LiveData<List<Athlete>> getAthletesBasedOnGender(String gender);
}
