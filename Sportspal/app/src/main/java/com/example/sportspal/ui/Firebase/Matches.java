package com.example.sportspal.ui.Firebase;

import java.sql.Timestamp;
import java.util.Map;

public class Matches {

    private String City;
    private String Country;
    private Timestamp Date;
    private String Sport_id;
    private String Typeof;

    public Matches() {
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

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Timestamp.valueOf(Date);
    }

    public String getSport_id() {
        return Sport_id;
    }

    public void setSport_id(String Sport_id) {
        this.Sport_id = Sport_id;
    }

    public void setTypeof(String type) {
        this.Typeof = type;
    }

    public String getTypeof() {
        return Typeof;
    }
}
