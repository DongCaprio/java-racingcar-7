package racingcar;

import exception.CustomIllegalArgException;

public class Name {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        checkNameValid(name);
        return new Name(name);
    }

    public static void checkNameValid(String name) {
        if (name.isEmpty()) {
            throw new CustomIllegalArgException("자동차 이름을 입력해주세요");
        }
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new CustomIllegalArgException("자동차 이름은 최대 5자입니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
