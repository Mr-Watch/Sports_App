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

@Dao
public interface SportDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSports(Sport... sports);

    @Delete
    void deleteSports(Sport... sports);

    @Update
    void updateSports(Sport... sports);

    @Query("select * from sports_table")
    LiveData<List<Sport>> getAllSports();
}
