package com.example.sportspal.ui.Team;

import androidx.room.ColumnInfo;

public class TeamStats {
    @ColumnInfo(name = "count_above")
    private int countAbove;
    @ColumnInfo(name = "count_below")
    private int countBelow;
    @ColumnInfo(name = "count_equal")
    private int countEqual;
    @ColumnInfo(name = "count_average")
    private float countAverage;

    public TeamStats(int countAbove, int countBelow, int countEqual, float countAverage) {
        this.countAbove = countAbove;
        this.countBelow = countBelow;
        this.countEqual = countEqual;
        this.countAverage = countAverage;
    }

    public int getCountAbove() {
        return countAbove;
    }

    public void setCountAbove(int countAbove) {
        this.countAbove = countAbove;
    }

    public int getCountBelow() {
        return countBelow;
    }

    public void setCountBelow(int countBelow) {
        this.countBelow = countBelow;
    }

    public int getCountEqual() {
        return countEqual;
    }

    public void setCountEqual(int countEqual) {
        this.countEqual = countEqual;
    }

    public float getCountAverage() {
        return Math.round(countAverage);
    }

    public void setCountAverage(float countAverage) {
        this.countAverage = countAverage;
    }
}
