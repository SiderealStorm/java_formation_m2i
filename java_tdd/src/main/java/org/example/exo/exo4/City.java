package org.example.exo.exo4;

import java.util.ArrayList;
import java.util.List;

public class City {

    private final List<String> cities = new ArrayList<>();

    public City() {
        cities.addAll(List.of(
                "Paris",
                "Budapest",
                "Skopje",
                "Rotterdam",
                "Valence",
                "Vancouver",
                "Amsterdam",
                "Vienne",
                "Sydney",
                "New York",
                "Londres",
                "Bangkok",
                "Hong Kong",
                "Dubaï",
                "Rome",
                "Istanbul"
        ));
    }

    public List<String> findCity(String search) {
        if (search.equals("*")) {
            return cities;
        } else if (search.length() < 2) {
            return null;
        } else {
            List<String> foundCities = new ArrayList<>();

            for (String city : cities) {
                if (city.equalsIgnoreCase(search)) {
                    foundCities.add(city);
                } else if (city.toLowerCase().contains(search.toLowerCase())) {
                    foundCities.add(city);
                }
            }
            return foundCities;
        }
    }

    public List<String> getCities() {
        return cities;
    }
}
