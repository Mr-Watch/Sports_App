package Database.Classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "athletes_table", foreignKeys = @ForeignKey(entity = Sport.class,
        parentColumns = "sport_id",
        childColumns = "athlete_sport_id",
        onDelete = ForeignKey.SET_NULL),
        indices = {@Index(value = {"athlete_surname"}, unique = true)})

public class Athlete {

    @PrimaryKey
    @ColumnInfo(name = "athlete_id")
    private int athleteId;
    @ColumnInfo(name = "athlete_first_name")
    private String athleteFirstName;
    @ColumnInfo(name = "athlete_surname")
    private String athleteSurname;
    @ColumnInfo(name = "athlete_city")
    private String athleteCity;
    @ColumnInfo(name = "athlete_country")
    private String athleteCountry;
    @ColumnInfo(name = "athlete_sport_id")
    private int athleteSportId;
    @ColumnInfo(name = "athlete_birth_year")
    private int athleteBirthYear;

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

    public void setAthleteId(int athleteId) {
        this.athleteId = athleteId;
    }

    public String getAthleteFirstName() {
        return athleteFirstName;
    }

    public void setAthleteFirstName(String athleteFirstName) {
        this.athleteFirstName = athleteFirstName;
    }

    public String getAthleteSurname() {
        return athleteSurname;
    }

    public void setAthleteSurname(String athleteSurname) {
        this.athleteSurname = athleteSurname;
    }

    public String getAthleteCity() {
        return athleteCity;
    }

    public void setAthleteCity(String athleteCity) {
        this.athleteCity = athleteCity;
    }

    public String getAthleteCountry() {
        return athleteCountry;
    }

    public void setAthleteCountry(String athleteCountry) {
        this.athleteCountry = athleteCountry;
    }

    public int getAthleteSportId() {
        return athleteSportId;
    }

    public void setAthleteSportId(int athleteSportId) {
        this.athleteSportId = athleteSportId;
    }

    public int getAthleteBirthYear() {
        return athleteBirthYear;
    }

    public void setAthleteBirthYear(int athleteBirthYear) {
        this.athleteBirthYear = athleteBirthYear;
    }
}
