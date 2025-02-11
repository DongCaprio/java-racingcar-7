package racingcar;

import util.NumberGenerator;

public class Car {

    private static final int MINIMUM_MOVE_VALUE = 4;
    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position;

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car createDefaultCar(String name) {
        return new Car(Name.of(name), DEFAULT_POSITION);
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.makeNumber() >= MINIMUM_MOVE_VALUE) {
            this.position++;
        }
    }

    public boolean isSamePosition(int position) {
        return position == this.position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
