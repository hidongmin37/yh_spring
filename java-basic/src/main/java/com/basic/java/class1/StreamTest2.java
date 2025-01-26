package com.basic.java.class1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest2 {
	public static void main(String[] args) {

		LamdaTest<Integer> test = (x) -> x * x;
		LamdaTest<Double> test2 = Math::sqrt;

		ArrayList<Object> objects = new ArrayList<>();



	}
	public static List<Integer> calculatePrimeNumbers(int n) {
		return IntStream.rangeClosed(2,n)
			.filter(StreamTest2::isPrime).boxed()
			.collect(Collectors.toList());
	}

	public static boolean isPrime(int n) {
		return IntStream.rangeClosed(2, (int)Math.sqrt(n))
			.allMatch(i -> n % i == 0);
	}


}
