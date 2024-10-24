package util;

import static console.Input.OUTPUT_WINNERS;
import static console.Input.generateExceptionIfNameAbove5;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.Car;

public class CarUtil {

    public static ArrayList<Car> makeCarList(String carsWithComma) {
        String[] carNames = carsWithComma.split(",");
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            generateExceptionIfNameAbove5(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int makeRandomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void advanceSixTimesOutOfTen(Car car) {
        int randomInt = makeRandomInt();
        if (randomInt >= 4) {
            car.addAdvanceCount();
        }
    }

    public static int getMaxAdvanceCount(ArrayList<Car> cars) {
        return cars
                .stream()
                .mapToInt(Car::getAdvanceCount)
                .max()
                .orElse(0);
    }

    public static String getWinnerNames(ArrayList<Car> cars) {
        int maxAdvanceCount = getMaxAdvanceCount(cars);
        return cars.stream()
                .filter(car -> car.getAdvanceCount() == maxAdvanceCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public static void printWinners(ArrayList<Car> cars) {
        String winners = getWinnerNames(cars);
        System.out.println(OUTPUT_WINNERS + winners);
    }
}