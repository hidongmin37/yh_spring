package nested.inner.ex2;

import java.util.Random;

public class Ex2MainTest {
	public static void helloTotal(SumClass sumClass) {
		System.out.println("프로그램 시작");

		sumClass.process();

		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		helloTotal(() -> {
			int randomValue = new Random().nextInt(6) + 1;
			System.out.println("주사위 값: " + randomValue);

		});
		helloTotal(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("i = " + i);
			}
		});

		Math.sqrt(4);

	}


}
