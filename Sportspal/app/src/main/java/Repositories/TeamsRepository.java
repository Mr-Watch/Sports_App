package Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sportspal.ui.Team.TeamCount;
import com.example.sportspal.ui.Team.TeamStats;

import java.util.List;

import Database.Classes.Team;
import Database.Interfaces.TeamDao;
import Database.SportpalDatabase;

public class TeamsRepository {
    private final TeamDao mTeamDao;
    private final LiveData<List<Team>> mTeams;

    public TeamsRepository(Application application) {
        SportpalDatabase db = SportpalDatabase.getDatabase(application);
        mTeamDao = db.teamDao();
        mTeams = mTeamDao.getAllTeams();
    }

    public LiveData<List<Team>> getAllTeams() {
        return mTeams;
    }

    public LiveData<List<TeamCount>> getTeamsCount() {
        return mTeamDao.getTeamsCount();
    }

    public LiveData<TeamStats> getTeamStats(int year) {
        return mTeamDao.getTeamStats(year);
    }

    public void insertTeams(Team... teams) {
        new insertAsyncTask(mTeamDao).execute(teams);
    }

    public void deleteTeams(Team... teams) {
        new deleteAsyncTask(mTeamDao).execute(teams);
    }

    public void updateTeams(Team... teams) {
        new updateAsyncTask(mTeamDao).execute(teams);
    }

    private static class deleteAsyncTask extends AsyncTask<Team, Void, Void> {
        private final TeamDao mAsyncTaskDao;

        deleteAsyncTask(TeamDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Team... teams) {
            mAsyncTaskDao.deleteTeam(teams);
            return null;
        }
    }

    private static class insertAsyncTask extends AsyncTask<Team, Void, Void> {
        private final TeamDao mAsyncTaskDao;

        insertAsyncTask(TeamDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Team... teams) {
            mAsyncTaskDao.insertTeam(teams);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<Team, Void, Void> {
        private final TeamDao mAsyncTaskDao;

        updateAsyncTask(TeamDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Team... teams) {
            mAsyncTaskDao.updateTeam(teams);
            return null;
        }
    }
}
