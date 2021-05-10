package Database.Classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "teams_table", foreignKeys = @ForeignKey(entity = Sport.class,
        parentColumns = "sport_id",
        childColumns = "team_sport_id",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = {"team_name"}, unique = true)})

public class Team {

    @ColumnInfo(name = "team_id")
    private int team_id;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "team_name")
    private String teamName;
    @ColumnInfo(name = "team_field_name")
    private String teamFieldName;
    @ColumnInfo(name = "team_city")
    private String teamCity;
    @ColumnInfo(name = "team_country")
    private String teamCountry;
    @ColumnInfo(name = "team_sport_id")
    private int teamSportId;
    @ColumnInfo(name = "team_birth_year")
    private int teamBirthYear;

    public Team(int team_id,
                String teamName,
                String teamFieldName,
                String teamCity,
                String teamCountry,
                int teamSportId,
                int teamBirthYear) {
        this.team_id = team_id;
        this.teamName = teamName;
        this.teamFieldName = teamFieldName;
        this.teamCity = teamCity;
        this.teamCountry = teamCountry;
        this.teamSportId = teamSportId;
        this.teamBirthYear = teamBirthYear;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamFieldName() {
        return teamFieldName;
    }

    public void setTeamFieldName(String teamFieldName) {
        this.teamFieldName = teamFieldName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamCountry() {
        return teamCountry;
    }

    public void setTeamCountry(String teamCountry) {
        this.teamCountry = teamCountry;
    }

    public int getTeamSportId() {
        return teamSportId;
    }

    public void setTeamSportId(int teamSportId) {
        this.teamSportId = teamSportId;
    }

    public int getTeamBirthYear() {
        return teamBirthYear;
    }

    public void setTeamBirthYear(int teamBirthYear) {
        this.teamBirthYear = teamBirthYear;
    }
}
