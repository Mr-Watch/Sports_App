package com.example.sportspal.ui.Firebase;

import java.util.HashMap;
import java.util.Map;

public class Matches {
    public Matches(String match_id, String city, String country, String date, int sport_id, String typeof) {
        Match_id = match_id;
        City = city;
        Country = country;
        Date = date;
        Sport_id = sport_id;
        Typeof = typeof;
    }

    private String Match_id;
    private String City;
    private String Country;
    private String Date;
    private int Sport_id;
    private String Typeof;

    public Matches() {
    }

    public String getMatch_id() {
        return Match_id;
    }

    public void setMatch_id(String Match_id) {
        this.Match_id = Match_id;
    }


    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getSport_id() {
        return Sport_id;
    }

    public void setSport_id(int Sport_id) {
        this.Sport_id = Sport_id;
    }

    public void setTypeof(String type) {
        this.Typeof = type;
    }

    public String getTypeof() {
        return Typeof;
    }
}

class Teambased extends Matches {
    private int Team_id1;
    private int Team_id2;
    private int Score1;
    private int Score2;

    public Teambased(Matches match, int team_id1, int team_id2, int scr1, int scr2) {
        this.setCity(match.getCity());
        this.setCountry(match.getCountry());
        this.setSport_id(match.getSport_id());
        this.setDate(match.getDate());
        this.setMatch_id(match.getMatch_id());
        this.setTypeof("Multiplayer");
        this.Team_id1 = team_id1;
        this.Team_id2 = team_id2;
        this.Score1 = scr1;
        this.Score2 = scr2;
    }

    public Teambased() {
    }

    public int getTeam_id1() {
        return Team_id1;
    }

    public int getTeam_id2() {
        return Team_id2;
    }

    public int getScore1() {
        return Score1;
    }

    public int getScore2() {
        return Score2;
    }

}

class Singleplayer extends Matches {
    private final Map<String, Integer> athlete_id_score = new HashMap<>();

    Singleplayer(Matches match) {
        this.setCity(match.getCity());
        this.setCountry(match.getCountry());
        this.setSport_id(match.getSport_id());
        this.setDate(match.getDate());
        this.setMatch_id(match.getMatch_id());
        this.setTypeof("Single player");
    }

    public void add(int athlete_id, int score) {
        athlete_id_score.put(String.valueOf(athlete_id), score);
    }

    public Map<String, Integer> getAthlete_id_score() {
        return athlete_id_score;
    }
}