package com.example.sportspal.ui.Athlete;

import androidx.lifecycle.LiveData;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;


import java.util.List;

import Database.Classes.Athlete;

import Repositories.AthleteRepository;

public class AthleteViewModel extends AndroidViewModel {
    private AthleteRepository mRepository;
    private LiveData<List<Athlete>> mAthletes;



    public AthleteViewModel(Application application1) {
        super(application1);
        mRepository = new AthleteRepository(application1);
        mAthletes = mRepository.getAllAthletes();
    }

    LiveData<List<Athlete>> getAllAthletes() {
        return mAthletes;
    }

    public void insertAthletes(Athlete... athletes) {
        mRepository.insertAthlete(athletes);
    }

    public void deleteAthletes(Athlete... athletes) {
        mRepository.deleteAthlete(athletes);
    }

    public void updateAthletes(Athlete... athletes) {
        mRepository.updateAthlete(athletes);
    }

}