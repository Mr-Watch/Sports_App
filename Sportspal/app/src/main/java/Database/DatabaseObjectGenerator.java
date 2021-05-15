package Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Database.Classes.Athlete;
import Database.Classes.Sport;
import Database.Classes.Team;

public class DatabaseObjectGenerator {
    private final List<Sport> generatedSports = new ArrayList<>();
    private final List<Athlete> generatedAthletes = new ArrayList<>();
    private final List<Team> generatedTeams = new ArrayList<>();
    private final Random random = new Random();
    private final int numberOfSports;
    private final int numberOfAthletes;
    private final int numberOfTeams;

    public DatabaseObjectGenerator(int numberOfSports, int numberOfAthletes, int numberOfTeams) {
        this.numberOfSports = numberOfSports;
        this.numberOfAthletes = numberOfAthletes;
        this.numberOfTeams = numberOfTeams;
    }

    public void generateObjects() {
        setGeneratedSports();
        setGeneratedAthletes();
        setGeneratedTeams();
    }

    public void setGeneratedSports() {
        for (int i = 1; i <= numberOfSports; i++) {
            String sportName = "sport name " + i;
            String sportGender;
            String sportType;
            if (random.nextInt(2) == 0) sportGender = "Male";
            else sportGender = "Female";

            if (random.nextInt(2) == 0) sportType = "Team";
            else sportType = "Single Player";
            generatedSports.add(new Sport(
                    i,
                    sportName,
                    sportType,
                    sportGender));
        }
    }

    public void setGeneratedAthletes() {
        for (int i = 1; i <= numberOfAthletes; i++) {
            String athleteFirstName = "athlete name " + i;
            String athleteSurname = "athlete surname " + i;
            String athleteCity = "athlete city " + i;
            String athleteCountry = "athlete country " + i;
            int athleteSportId = random.nextInt(numberOfSports - 1) + 1;
            int athleteBirthYear = random.nextInt(2005 - 1985) + 1985;
            generatedAthletes.add(new Athlete(
                    i,
                    athleteFirstName,
                    athleteSurname,
                    athleteCity,
                    athleteCountry,
                    athleteSportId,
                    athleteBirthYear));
        }
    }

    public void setGeneratedTeams() {
        for (int i = 1; i <= numberOfTeams; i++) {
            String teamFirstName = "team name " + i;
            String teamFieldName = "team field name " + i;
            String teamCity = "team city " + i;
            String teamCountry = "team country " + i;
            int teamSportId = random.nextInt(numberOfSports - 1) + 1;
            int teamBirthYear = random.nextInt(1945 - 1880) + 1880;
            generatedTeams.add(new Team(
                    i,
                    teamFirstName,
                    teamFieldName,
                    teamCity,
                    teamCountry,
                    teamSportId,
                    teamBirthYear));
        }
    }

    public Sport[] getGeneratedSports() {
        return generatedSports.toArray(new Sport[0]);
    }

    public Athlete[] getGeneratedAthletes() {
        return generatedAthletes.toArray(new Athlete[0]);
    }

    public Team[] getGeneratedTeams() {
        return generatedTeams.toArray(new Team[0]);
    }
}
