package Database.Classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "athletes_table", foreignKeys = @ForeignKey(entity = Sport.class,
        parentColumns = "sport_id",
        childColumns = "athlete_sport_id",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = {"athlete_surname"}, unique = true)})

public class Athlete {

    @PrimaryKey
    @ColumnInfo(name = "athlete_id")
    private final int athleteId;
    @ColumnInfo(name = "athlete_first_name")
    private final String athleteFirstName;
    @ColumnInfo(name = "athlete_surname")
    private final String athleteSurname;
    @ColumnInfo(name = "athlete_city")
    private final String athleteCity;
    @ColumnInfo(name = "athlete_country")
    private final String athleteCountry;
    @ColumnInfo(name = "athlete_sport_id")
    private final int athleteSportId;
    @ColumnInfo(name = "athlete_birth_year")
    private final int athleteBirthYear;

    public Athlete(int athleteId,
                   String athleteFirstName,
                   String athleteSurname,
                   String athleteCity,
                   String athleteCountry,
                   int athleteSportId,
                   int athleteBirthYear) {
        this.athleteId = athleteId;
        this.athleteFirstName = athleteFirstName;
        this.athleteSurname = athleteSurname;
        this.athleteCity = athleteCity;
        this.athleteCountry = athleteCountry;
        this.athleteSportId = athleteSportId;
        this.athleteBirthYear = athleteBirthYear;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public String getAthleteFirstName() {
        return athleteFirstName;
    }

    public String getAthleteSurname() {
        return athleteSurname;
    }

    public String getAthleteCity() {
        return athleteCity;
    }

    public String getAthleteCountry() {
        return athleteCountry;
    }

    public int getAthleteSportId() {
        return athleteSportId;
    }

    public int getAthleteBirthYear() {
        return athleteBirthYear;
    }
}
