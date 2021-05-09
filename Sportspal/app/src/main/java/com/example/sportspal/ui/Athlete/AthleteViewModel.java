package com.example.sportspal.ui.Athlete;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Athlete;
import Database.Classes.Sport;
import Repositories.SportRepository;

public class AthleteViewModel extends AndroidViewModel {
    private SportRepository mRepository;
    private LiveData<List<Athlete>> mAthletes;



    public AthleteViewModel(Application application1) {
        super(application1);
        mRepository = new SportRepository(application1);
        mAthletes = mRepository.getAllAthletes();
    }

    LiveData<List<Athlete>> getAllAthletes() {
        return mAthletes;
    }

    public void insertAthletes(Athlete... athletes) {
        mRepository.insertAthletes(athletes);
    }

    public void deleteAthletes(Athlete... athletes) {
        mRepository.deleteAthletes(athletes);
    }

    public void updateAthletes(Athlete... athletes) {
        mRepository.updateAthletes(athletes);
    }

}