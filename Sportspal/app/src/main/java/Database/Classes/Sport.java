package Database.Classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "sports_table",
        indices = {@Index(value = {"sport_name",
                "sport_type",
                "sport_gender"},
                unique = true)})

public class Sport {

    @PrimaryKey
    @ColumnInfo(name = "sport_id")
    private int sportId;
    @ColumnInfo(name = "sport_name")
    private String sportName;
    @ColumnInfo(name = "sport_type")
    private String sportType;
    @ColumnInfo(name = "sport_gender")
    private String sportGender;

    public Sport(int sportId,
                 String sportName,
                 String sportType,
                 String sportGender) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.sportType = sportType;
        this.sportGender = sportGender;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getSportGender() {
        return sportGender;
    }

    public void setSportGender(String sportGender) {
        this.sportGender = sportGender;
    }
}
