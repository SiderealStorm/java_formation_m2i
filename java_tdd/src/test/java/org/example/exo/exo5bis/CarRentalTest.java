package org.example.exo.exo5bis;

import org.example.exo.exo5bis.exception.MaxConditionException;
import org.example.exo.exo5bis.exception.NegativeConditionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarRentalTest {
    private Car car;
    private CarRental carRental;

    private void init(int rentDueIn, int condition, String type) {
        carRental = new CarRental();
        car = new Car();
        car.setRentDueIn(rentDueIn);
        car.setCondition(condition);
        car.setType(type);
    }

    // Traitement de base
    @Test
    public void testDailyRoutineShouldDecreaseRentDueIn() {
        init(5, 100, "citadine");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(4, car.getRentDueIn());
    }

    // Traitement de base
    @Test
    public void testDailyRoutineShouldDecreaseCondition() {
        init(5, 100, "citadine");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(99, car.getCondition());
    }

    // Cas 1 : après expiration du contrat
    @Test
    public void testDailyRoutineShouldDecreaseConditionTwiceWhenRentDueInIsBelow0() {
        init(0, 100, "citadine");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(98, car.getCondition());
    }

    // Cas 2 : voiture passée avec état négatif
    @Test
    public void testDailyRoutineShouldRaiseNegativeConditionExceptionWhenConditionIsNegative() {
        init(5, -1, "citadine");

        Assertions.assertThrowsExactly(NegativeConditionException.class, () -> carRental.dailyRoutine(car));
    }

    // Cas 2 : voiture dont l'état est à 0
    @Test
    public void testDailyRoutineShouldNotDecreaseConditionWhenConditionIs0() {
        init(5, 0, "citadine");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(0, car.getCondition());
    }

    // Cas 2 : voiture dont l'état est à 1 et contrat expiré
    @Test
    public void testDailyRoutineShouldNotDecreaseConditionUnder0WhenRentDueInIs0() {
        init(0, 1, "citadine");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(0, car.getCondition());
    }


    // Cas 3 : voiture passée avec un état > 100
    @Test
    public void testDailyRoutineShouldRaiseMaxConditionExceptionWhenConditionIsAbove100() {
        init(5, 101, "citadine");

        Assertions.assertThrowsExactly(MaxConditionException.class, () -> carRental.dailyRoutine(car));
    }

    // Cas 4 : voiture de luxe
    @Test
    public void testDailyRoutineShouldIncreaseConditionWhenTypeIsLuxe() {
        init(5, 50, "luxe");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(51, car.getCondition());
    }

    // Cas 4 : voiture de luxe dont l'état est à 100
    @Test
    public void testDailyRoutineShouldNotIncreaseConditionWhenTypeIsLuxeAndConditionIs100() {
        init(5, 100, "luxe");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(100, car.getCondition());
    }


    // Cas 5 : voiture ancienne
    @Test
    public void testDailyRoutineShouldDecreaseConditionTwiceWhenTypeIsAncienne() {
        init(5, 100, "ancienne");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(98, car.getCondition());
    }

    // Cas 5 : voiture ancienne avec contrat expiré
    @Test
    public void testDailyRoutineShouldDecreaseConditionBy4WhenTypeIsAncienneAndRentDueInIs0() {
        init(0, 100, "ancienne");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(96, car.getCondition());
    }


    // Cas 5 : voiture ancienne dont l'état est à 1
    @Test
    public void testDailyRoutineShouldNotDecreaseConditionBelow0WhenTypeIsAncienne() {
        init(0, 1, "ancienne");

        carRental.dailyRoutine(car);

        Assertions.assertEquals(0, car.getCondition());
    }

}
