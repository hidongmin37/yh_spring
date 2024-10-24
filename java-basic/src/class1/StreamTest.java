package class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {

		System.out.println("== 배열 스트림 ==");
		String[] arr = {"a", "b", "c"};

		System.out.println("== fori == ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("== forEach == ");
		for (String one: arr) {
			System.out.println(one);
		}

		System.out.println("== to Stream == ");
		Arrays.stream(arr).forEach(System.out::println);

		// 1-2 컬렉션 스트림
		System.out.println("== 컬렉션 스트림 ==");
		ArrayList arrayList = new ArrayList(Arrays.asList(1, 2, 3));
		arrayList.forEach(System.out::println);
		arrayList.forEach(i-> System.out.println(i+"sss"));


		// 1-3 스트림 빌더
		System.out.println("== 스트림 빌더==");
		Stream<Object> build = Stream.builder().add(1).add(2).add(3).build();
		build.forEach(System.out::println);

		// 1-3 스트림 generate
		System.out.println("== 스트림 generate==");
		Stream.generate(() -> Arrays.asList(1,2, 3))
			.limit(1)
			.forEach(System.out::println);

		// 1-4 스트림 iterate
		System.out.println("== 스트림 iterate == ");
		Stream.iterate(1, i -> i + 1).limit(3).forEach(System.out::println);

		// 1-5 기본 타입 스트림
		System.out.println("== 기본 스트림 == ");
		IntStream.range(1, 4).forEach(System.out::println);


		// 2. 스트림 중개 연산

		// 2-1 Filtering
		System.out.println("== Filtering == ");
		IntStream.range(1, 10).filter(i->i%2==0).forEach(System.out::println);

		// 2-2 Mapping
		System.out.println("== Map == ");
		IntStream.range(1, 10).map(i-> i+1).forEach(System.out::println);

		// 2-3 Sorting
		System.out.println("== not Sorting == ");
		IntStream build1 = IntStream.builder().add(5).add(10).add(3).build();
		build1.forEach(System.out::println);
		System.out.println("== Sorting == ");
		IntStream.builder().add(5).add(10).add(3).build().sorted().forEach(System.out::println);

		// 3. 최종연산
		System.out.println("== sum,average == ");
		int sum = IntStream.range(1, 10).sum();
		System.out.println("sum = " + sum);
		double asDouble = IntStream.range(1, 10).average().getAsDouble();
		System.out.println("asDouble = " + asDouble);

		// min,max
		System.out.println("== min,max == ");
		IntStream.range(1, 10).min().ifPresent(System.out::println);
		IntStream.range(1, 10).max().ifPresent(System.out::println);

		//reduce -> 연쇄적인
		System.out.println("== reduce == ");
		Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 4,5)).stream();
		System.out.println("stream = " + stream.reduce(Integer::sum).get());




	}
}
