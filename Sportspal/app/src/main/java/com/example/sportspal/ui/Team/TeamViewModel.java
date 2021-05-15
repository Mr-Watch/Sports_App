package com.example.sportspal.ui.Team;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Team;
import Repositories.TeamsRepository;

public class TeamViewModel extends AndroidViewModel {
    private final TeamsRepository mRepository;
    private final LiveData<List<Team>> mTeams;

    public TeamViewModel(Application application) {
        super(application);
        mRepository = new TeamsRepository(application);
        mTeams = mRepository.getAllTeams();
    }

    public LiveData<List<Team>> getAllTeams() {
        return mTeams;
    }

    public LiveData<List<TeamCount>> getTeamsCount() {
        return mRepository.getTeamsCount();
    }

    public LiveData<TeamStats> getTeamStats(int year) {
        return mRepository.getTeamStats(year);
    }

    public void insertTeam(Team... teams) {
        mRepository.insertTeams(teams);
    }

    public void deleteTeam(Team... teams) {
        mRepository.deleteTeams(teams);
    }

    public void updateTeam(Team... teams) {
        mRepository.updateTeams(teams);
    }
}