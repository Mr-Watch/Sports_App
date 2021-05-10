package Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import Database.Classes.Athlete;
import Database.Classes.Sport;
import Database.Classes.Team;
import Database.Interfaces.AthleteDao;
import Database.Interfaces.SportDao;
import Database.Interfaces.TeamDao;

@Database(entities = {Sport.class,
        Athlete.class,
        Team.class},
        version = 1)

public abstract class SportpalDatabase extends RoomDatabase {
    private static SportpalDatabase instance;
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {

        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabaseAsyncTask(instance).execute();
        }
    };

    public static SportpalDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (SportpalDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            SportpalDatabase.class, "sportspal_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallBack)
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract SportDao sportDao();

    public abstract AthleteDao athleteDao();

    public abstract TeamDao teamDao();

    private static class PopulateDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        private SportDao sportDao;
        private AthleteDao athleteDao;
        private TeamDao teamDao;

        private PopulateDatabaseAsyncTask(SportpalDatabase db) {
            sportDao = db.sportDao();
            athleteDao = db.athleteDao();
            teamDao = db.teamDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DatabaseObjectGenerator generator = new DatabaseObjectGenerator(
                    10,
                    20,
                    15);
            generator.generateObjects();
            sportDao.insertSports(generator.getGeneratedSports());
            athleteDao.insertAthlete(generator.getGeneratedAthletes());
            teamDao.insertTeam(generator.getGeneratedTeams());
            return null;
        }
    }

}
