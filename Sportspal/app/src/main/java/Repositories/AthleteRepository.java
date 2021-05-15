package Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Athlete;
import Database.Interfaces.AthleteDao;
import Database.SportpalDatabase;

public class AthleteRepository {
    private final AthleteDao mAthleteDao;
    private final LiveData<List<Athlete>> mAthletes;

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
        new insertAsyncTask(mAthleteDao).execute(athletes);
    }

    public void deleteAthlete(Athlete... athletes) {
        new deleteAsyncTask(mAthleteDao).execute(athletes);
    }

    public void updateAthlete(Athlete... athletes) {
        new updateAsyncTask(mAthleteDao).execute(athletes);
    }

    private static class deleteAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private final AthleteDao mAsyncTaskDao;

        deleteAsyncTask(AthleteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Athlete... athletes) {
            mAsyncTaskDao.deleteAthlete(athletes);
            return null;
        }
    }

    private static class insertAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private final AthleteDao mAsyncTaskDao;

        insertAsyncTask(AthleteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Athlete... athletes) {
            mAsyncTaskDao.insertAthlete(athletes);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private final AthleteDao mAsyncTaskDao;

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
