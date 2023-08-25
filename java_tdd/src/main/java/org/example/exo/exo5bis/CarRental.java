package org.example.exo.exo5bis;

public class CarRental {

    public Car dailyRoutine(Car car) {
        car.setCondition(car.getCondition() - 1);

        car.setRentDueIn(car.getCondition() - 1);
        return car;
    }
}
