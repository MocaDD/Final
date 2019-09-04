package P2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Spaceship {

    private int foodOnBoard;
    private List<String> visitedPlanets = new ArrayList<>();
    private HashSet<String> crewMembers = new HashSet<>();
    private HashMap<String, Integer> foodPerDayForEveryMember = new HashMap<>();


    Spaceship(int foodOnBoard) {
        this.foodOnBoard = foodOnBoard;
    }


    public void board(String crewMemberName, int foodPerDay) {
        foodPerDayForEveryMember.put(crewMemberName, foodPerDay);
        crewMembers.add(crewMemberName);
    }

    public void unboard(String crewMemberName) {
        foodPerDayForEveryMember.remove(crewMemberName);
        crewMembers.remove(crewMemberName);
    }

    public String getPlanetsVisited() {
        StringBuilder planets = new StringBuilder("[");
        for (String visitedPlanet : visitedPlanets) {
            planets.append(visitedPlanet).append(", ");
        }

        planets.replace(planets.toString().length() - 2, planets.toString().length(), "]");

        return planets.toString();
    }

    public boolean flyTo(String planetName, int daysRequired) {

        int foodRequiredPerDay = 0;
        int foodRequiredForTrip;

        for (String key : foodPerDayForEveryMember.keySet()) {
            foodRequiredPerDay += foodPerDayForEveryMember.get(key);
        }

        foodRequiredForTrip = foodRequiredPerDay * daysRequired;

        if (foodRequiredForTrip <= foodOnBoard) {
            foodOnBoard -= foodRequiredForTrip;
            visitedPlanets.add(planetName);

            return true;
        } else {
            return false;
        }
    }

    HashSet<String> getCrewMembers() {
        return crewMembers;
    }
}