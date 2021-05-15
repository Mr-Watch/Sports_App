package Database.Classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "teams_table", foreignKeys = @ForeignKey(entity = Sport.class,
        parentColumns = "sport_id",
        childColumns = "team_sport_id",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = {"team_name"}, unique = true)})

public class Team {

    @ColumnInfo(name = "team_id")
    private final int teamId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "team_name")
    private final String teamName;
    @ColumnInfo(name = "team_field_name")
    private final String teamFieldName;
    @ColumnInfo(name = "team_city")
    private final String teamCity;
    @ColumnInfo(name = "team_country")
    private final String teamCountry;
    @ColumnInfo(name = "team_sport_id")
    private final int teamSportId;
    @ColumnInfo(name = "team_birth_year")
    private final int teamBirthYear;

    public Team(int teamId,
                @NotNull String teamName,
                String teamFieldName,
                String teamCity,
                String teamCountry,
                int teamSportId,
                int teamBirthYear) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamFieldName = teamFieldName;
        this.teamCity = teamCity;
        this.teamCountry = teamCountry;
        this.teamSportId = teamSportId;
        this.teamBirthYear = teamBirthYear;
    }

    public int getTeamId() {
        return teamId;
    }

    @NotNull
    public String getTeamName() {
        return teamName;
    }

    public String getTeamFieldName() {
        return teamFieldName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public String getTeamCountry() {
        return teamCountry;
    }

    public int getTeamSportId() {
        return teamSportId;
    }

    public int getTeamBirthYear() {
        return teamBirthYear;
    }
}
