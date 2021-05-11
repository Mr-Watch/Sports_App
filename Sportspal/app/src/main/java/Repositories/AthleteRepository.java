package Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Athlete;
import Database.Interfaces.AthleteDao;
import Database.SportpalDatabase;

public class AthleteRepository {
    private AthleteDao mAthleteDao;
    private LiveData<List<Athlete>> mAthletes;
    private LiveData<List<Athlete>> mAthletesBasedOnGender;

    public AthleteRepository(Application application) {
        SportpalDatabase db = SportpalDatabase.getDatabase(application);
        mAthleteDao = db.athleteDao();
        mAthletes = mAthleteDao.getAllAthletes();
    }

    public LiveData<List<Athlete>> getAllAthletes() {
        return mAthletes;
    }

    public LiveData<List<Athlete>> getAthletesBasedOnGender(String gender) {
        return mAthleteDao.getAthletesBasedOnGender(gender);
    }

    public void insertAthlete(Athlete... athletes) {
        new AthleteRepository.insertAsyncTask(mAthleteDao).execute(athletes);
    }

    public void deleteAthlete(Athlete... athletes) {
        new AthleteRepository.deleteAsyncTask(mAthleteDao).execute(athletes);
    }

    public void updateAthlete(Athlete... athletes) {
        new AthleteRepository.updateAsyncTask(mAthleteDao).execute(athletes);
    }

    private class deleteAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private AthleteDao mAsyncTaskDao;

        deleteAsyncTask(AthleteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Athlete... athletes) {
            mAsyncTaskDao.deleteAthlete(athletes);
            return null;
        }
    }

    private class insertAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private AthleteDao mAsyncTaskDao;

        insertAsyncTask(AthleteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Athlete... athletes) {
            mAsyncTaskDao.insertAthlete(athletes);
            return null;
        }
    }

    private class updateAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private AthleteDao mAsyncTaskDao;

        updateAsyncTask(AthleteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Athlete... athletes) {
            mAsyncTaskDao.updateAthlete(athletes);
            return null;
        }
    }

}
