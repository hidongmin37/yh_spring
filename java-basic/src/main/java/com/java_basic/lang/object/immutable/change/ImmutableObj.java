package main.lang.object.immutable.change;

public class ImmutableObj {
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add(int addValue) {
        int result = value + addValue;
        return new ImmutableObj(result); //새로 생성한 객체 반환
    }


    public int getValue() {
        return value;
    }
}
