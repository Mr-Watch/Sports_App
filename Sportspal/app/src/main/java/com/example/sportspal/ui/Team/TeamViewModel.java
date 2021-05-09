package com.example.sportspal.ui.Team;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import Database.Classes.Team;
import Repositories.TeamsRepository;

public class TeamViewModel extends ViewModel {
    private TeamsRepository mRepository;
    private LiveData<List<Team>> mTeams;

    public TeamViewModel(Application application) {
        super(); //application?
        mRepository = new TeamsRepository(application);
        mTeams = mRepository.getAllTeams();
    }

    public LiveData<List<Team>> getAllTeams() {
        return mTeams;
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