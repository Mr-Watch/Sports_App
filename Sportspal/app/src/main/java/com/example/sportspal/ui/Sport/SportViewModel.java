package com.example.sportspal.ui.Sport;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Sport;
import Repositories.SportRepository;

public class SportViewModel extends AndroidViewModel {
    private final SportRepository mRepository;
    private final LiveData<List<Sport>> mSports;

    public SportViewModel(Application application) {
        super(application);
        mRepository = new SportRepository(application);
        mSports = mRepository.getAllSports();
    }

    LiveData<List<Sport>> getAllSports() {
        return mSports;
    }

    public void insertSports(Sport... sports) {
        mRepository.insertSports(sports);
    }

    public void deleteSports(Sport... sports) {
        mRepository.deleteSports(sports);
    }

    public void updateSports(Sport... sports) {
        mRepository.updateSports(sports);
    }

}