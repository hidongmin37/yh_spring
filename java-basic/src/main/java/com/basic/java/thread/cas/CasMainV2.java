package com.basic.java.thread.cas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

import static com.basic.java.thread.util.MyLogger.log;

public class CasMainV2 {
    private static final Logger log = LoggerFactory.getLogger(CasMainV2.class);

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        // incrementAndGet구현
        int resultValue1 = incrementAndGet(atomicInteger);
        System.out.println("resultValue1 " + resultValue1 + ", value = " + atomicInteger.get());

        int resultValue2 = incrementAndGet(atomicInteger);
        System.out.println("resultValue2 " + resultValue2 + ", value = " + atomicInteger.get());
    }

    public static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get();
            log("getValue : " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result : " + result);
        } while (!result);

        return getValue + 1;
    }
}
