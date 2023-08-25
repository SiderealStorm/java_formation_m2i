package org.example.exo.exo4;

import org.example.exo.exo4.exception.CityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CityTest {

    private City city;

    // Correction : ajout des villes en tant que constante
    private static final List<String> MOCK_CITIES = List.of(
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
    );

    private List<String> result;

    // Correction : on set les villes dans la méthode de test plutôt que dans la classe
    @BeforeEach
    public void setUp() {
        city = new City();
        city.setCities(MOCK_CITIES);
    }

    @Test
    public void testFindCitiesShouldBeParis() {
        result = city.findCities("Paris");

        Assertions.assertEquals(List.of("Paris"), result);
    }

    // Original : avec retour nul
    /*
    @Test
    public void testFindCitiesShouldBeNullWhenSearchLessThan2Char() {
        result = city.findCities("P");

        Assertions.assertNull(result);
    }
     */

    // Correction : avec classe d'exception
    @Test
    public void testFindCitiesShouldRaiseNotFoundExceptionWHENSearchLessThan2Char() {
        Assertions.assertThrowsExactly(CityNotFoundException.class, () -> city.findCities("P"));
    }

    @Test
    public void testFindCitiesShouldHave2CitiesWhenSearchIsVa() {
        result = city.findCities("Va");

        Assertions.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void testFindCitiesShouldHaveResultsWhenSearchIsLowercase() {
        result = city.findCities("va");

        Assertions.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void testFindCitiesShouldBeBudapestWhenSearchIsApe() {
        result = city.findCities("ape");

        Assertions.assertEquals(List.of("Budapest"), result);
    }

    @Test
    public void testFindCitiesShouldHaveAllCitiesWhenSearchIsStar() {
        result = city.findCities("*");

        Assertions.assertEquals(MOCK_CITIES, result);

    }

}
