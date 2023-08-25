package org.example.exo.exo4;

import org.example.exo.exo4.exception.CityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class City {

    private List<String> cities = new ArrayList<>();

    public City() {}

    public List<String> findCities(String search) {
        if (search.equals("*")) {
            return cities;
        } else if (search.length() < 2) {
            // Original : avec retour nul
//            return null;
            // Correction : avec levée d'exception
            throw new CityNotFoundException();
        } else {
            List<String> foundCities = new ArrayList<>();

            for (String city : cities) {
                if (city.toLowerCase().contains(search.toLowerCase())) {
                    foundCities.add(city);
                }
            }
            return foundCities;
        }
    }


    // Méthode avant Refactor (toutes les étapes) :
    /*
    public List<String> findCities(String search) {
        if (search.equals("*")) {   // Etape 5
            return cities;
        } else if (search.length() < 2) {   // Etape 1
            return null;
        } else {
            List<String> foundCities = new ArrayList<>();

            for (String city : cities) {
                if (city.equals(search)) {  // Etape 0
                    foundCities.add(city);
                } else if (city.toLowerCase().startsWith(search.toLowerCase())) {   // Etapes 2 et 3
                    foundCities.add(city);
                } else if (city.toLowerCase().contains(search.toLowerCase())) {     // Etape 4
                    foundCities.add(city);
                }
            }
            return foundCities;
        }
    }
     */


    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
