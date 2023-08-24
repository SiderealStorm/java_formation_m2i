package org.example.exo.exo4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CityTest {

    private City city;
    private List<String> result;

    @BeforeEach
    public void setUp() {
        city = new City();
    }

    @Test
    public void testFindCityShouldBeParis() {
        result = city.findCity("Paris");

        Assertions.assertEquals(List.of("Paris"), result);
    }

    @Test
    public void testFindCityShouldBeNullWhenSearchLessThan2Char() {
        result = city.findCity("P");

        Assertions.assertNull(result);
    }

    @Test
    public void testFindCityShouldHave2CitiesWhenSearchIsVa() {
        result = city.findCity("Va");

        Assertions.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void testFindCityShouldHaveResultsWhenSearchIsLowercase() {
        result = city.findCity("va");

        Assertions.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void testFindCityShouldBeBudapestWhenSearchIsApe() {
        result = city.findCity("ape");

        Assertions.assertEquals(List.of("Budapest"), result);
    }

    @Test
    public void testFindCityShouldHaveAllCitiesWhenSearchIsStar() {
        result = city.findCity("*");

        Assertions.assertEquals(List.of(
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
                ), result);

        // OU ?
//        Assertions.assertEquals(city.getCities(), result);
    }

}
