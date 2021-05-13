package com.example.sportspal.ui.Firebase;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.sportspal.ui.Firebase.Matches;
import Repositories.MatchRepository;

public class MatchViewModel extends AndroidViewModel {
    private MatchRepository mRepository;
    private LiveData<List<Matches>> mMatches;


    public MatchViewModel(Application application) {
        super(application);
        mRepository = new MatchRepository(application);
        mMatches = mRepository.getAllMatches();
    }

    LiveData<List<Matches>> getAllMatches() {
        return mMatches;
    }

    LiveData<List<Matches>> getMatchesBasedOnId(String Id) {
        return mRepository.getMatchesBasedOnId(Id);
    }

    public void insertMatches(Matches... matches) {
        mRepository.insertMatches(matches);
    }

    public void deleteMatches(Matches... matches) {
        mRepository.deleteMatches(matches);
    }

    public void updateMatches(Matches... matches) {
        mRepository.updateMatches(matches);
    }

}