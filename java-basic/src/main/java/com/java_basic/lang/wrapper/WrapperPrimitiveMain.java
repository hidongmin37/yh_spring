package main.lang.wrapper;

public class WrapperPrimitiveMain {

    public static void main(String[] args) {
        int iterations = 1_000_000_000;
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        long sumPrimitive = 0;
        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumPrimitive);
        System.out.println("걸린 시간 = " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        Long sumWrapper = 0L;
        for (int i = 0; i < iterations; i++) {
            sumWrapper += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumWrapper);
        System.out.println("걸린 시간 = " + (endTime - startTime) + "ms");
    }
}
