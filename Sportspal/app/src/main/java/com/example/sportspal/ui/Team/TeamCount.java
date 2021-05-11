package com.example.sportspal.ui.Team;

import androidx.room.ColumnInfo;

public class TeamCount {
    @ColumnInfo(name = "team_count")
    private int numberOfTeams;
    @ColumnInfo(name = "sport_name")
    private String sportName;
    @ColumnInfo(name = "sport_id")
    private int sportId;

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public String getSportName() {
        return sportName;
    }

    public int getSportId() {
        return sportId;
    }
}
