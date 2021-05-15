package com.example.sportspal.ui.Team;

import androidx.room.ColumnInfo;

public class TeamStats {
    @ColumnInfo(name = "count_above")
    private final int countAbove;
    @ColumnInfo(name = "count_below")
    private final int countBelow;
    @ColumnInfo(name = "count_equal")
    private final int countEqual;
    @ColumnInfo(name = "count_average")
    private final float countAverage;

    public TeamStats(int countAbove, int countBelow, int countEqual, float countAverage) {
        this.countAbove = countAbove;
        this.countBelow = countBelow;
        this.countEqual = countEqual;
        this.countAverage = countAverage;
    }

    public int getCountAbove() {
        return countAbove;
    }

    public int getCountBelow() {
        return countBelow;
    }

    public int getCountEqual() {
        return countEqual;
    }

    public float getCountAverage() {
        return Math.round(countAverage);
    }
}
