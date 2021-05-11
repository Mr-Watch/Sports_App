package com.example.sportspal.ui.Athlete;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Athlete;
import Repositories.AthleteRepository;

public class AthleteViewModel extends AndroidViewModel {
    private AthleteRepository mRepository;
    private LiveData<List<Athlete>> mAthletes;


    public AthleteViewModel(Application application) {
        super(application);
        mRepository = new AthleteRepository(application);
        mAthletes = mRepository.getAllAthletes();
    }

    LiveData<List<Athlete>> getAllAthletes() {
        return mAthletes;
    }

    LiveData<List<Athlete>> getAthletesBasedOnGender(String gender) {
        return mRepository.getAthletesBasedOnGender(gender);
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