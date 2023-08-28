package org.example.exo.exo5bis;

import org.example.exo.exo5bis.exception.MaxConditionException;
import org.example.exo.exo5bis.exception.NegativeConditionException;

public class CarRental {
    public void dailyRoutine(Car car) {
        if (car.getCondition() < 0) {
            throw new NegativeConditionException();
        } else if (car.getCondition() > 100) {
            throw new MaxConditionException();
        }

        int conditionDiff = 0;

        if (car.getType().equals("luxe")) {
            if (car.getCondition() < 100) {
                conditionDiff = -1;
            }
        } else if (car.getType().equals("ancienne")) {
            if (car.getRentDueIn() <= 0) {
                conditionDiff = 4;
            } else {
                conditionDiff = 2;
            }
        } else {
            if (car.getCondition() > 0) {
                if (car.getRentDueIn() <= 0) {
                    conditionDiff = 2;
                } else {
                    conditionDiff = 1;
                }
            }
        }
        if (car.getCondition() > conditionDiff) {
            car.setCondition(car.getCondition() - conditionDiff);
        } else {
            car.setCondition(0);
        }

        car.setRentDueIn(car.getRentDueIn() - 1);
    }

    // Avant Refactor
    /*
    public void dailyRoutine(Car car) {
        if (car.getCondition() < 0) {
            throw new NegativeConditionException();
        } else if (car.getCondition() > 100) {
            throw new MaxConditionException();
        }

        if (car.getType().equals("luxe")) {
            if (car.getCondition() < 100) {
                car.setCondition(car.getCondition() + 1);
            }
        } else if (car.getType().equals("ancienne")) {
            if (car.getRentDueIn() <= 0) {
                car.setCondition(car.getCondition() - 4);
            } else {
                car.setCondition(car.getCondition() - 2);
            }
        } else {
            if (car.getCondition() > 0) {
                if (car.getRentDueIn() <= 0) {
                    car.setCondition(car.getCondition() - 2);
                } else {
                    car.setCondition(car.getCondition() - 1);
                }
            }
        }
        if (car.getCondition() < 0) {
            car.setCondition(0);
        }

        car.setRentDueIn(car.getRentDueIn() - 1);
    }
     */
}
