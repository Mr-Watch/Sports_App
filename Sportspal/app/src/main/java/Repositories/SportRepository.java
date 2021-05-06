package Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import Database.Classes.Sport;
import Database.Interfaces.SportDao;
import Database.SportpalDatabase;

public class SportRepository {
    private SportDao mSportDao;
    private LiveData<List<Sport>> mSports;

    public SportRepository(Application application) {
        SportpalDatabase db = SportpalDatabase.getDatabase(application);
        mSportDao = db.sportDao();
        mSports = mSportDao.getAllSports();
    }


    public LiveData<List<Sport>> getAllSports() {
        return mSports;
    }

    public void insertSports(Sport... sports) {
        new insertAsyncTask(mSportDao).execute(sports);
    }

    public void deleteSports(Sport... sports) {
        new deleteAsyncTask(mSportDao).execute(sports);
    }

    public void updateSports(Sport... sports) {
        new updateAsyncTask(mSportDao).execute(sports);
    }

    private class deleteAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDao mAsyncTaskDao;

        deleteAsyncTask(SportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Sport... sports) {
            mAsyncTaskDao.deleteSports(sports);
            return null;
        }
    }

    private class insertAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDao mAsyncTaskDao;

        insertAsyncTask(SportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Sport... sports) {
            mAsyncTaskDao.insertSports(sports);
            return null;
        }
    }

    private class updateAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDao mAsyncTaskDao;

        updateAsyncTask(SportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Sport... sports) {
            mAsyncTaskDao.updateSports(sports);
            return null;
        }
    }
}
