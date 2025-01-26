package com.basic.java.nested.inner.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InnerOuterMain {

	public static void main(String[] args) {
		String[] arr =new String[]{"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);

		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> stream1 = list.stream();

		Stream<String> build = Stream.<String>builder()
			.add("a")
			.add("b")
			.add("c")
			.build();
	}
}
