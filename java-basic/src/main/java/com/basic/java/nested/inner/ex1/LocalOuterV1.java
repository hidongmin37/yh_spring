package com.basic.java.nested.inner.ex1;

public class LocalOuterV1 {

	private int outerInstanceNum = 10;

	public void process(int param) {
		int localNum = 20;
		System.out.println("localNum = " + localNum);

		class LocalPrinter {
			int innerNum = 100;
			public void printData() {
				innerNum += 10;
				outerInstanceNum += 10;
				// param += 10; // 에러나는 이유: param은 final로 선언되어 있기 때문에 값을 변경할 수 없다.
				// localNum += 10; //에러 나는 이유: final이 생략되어있지만,
				System.out.println("param = " + param);
				System.out.println("innerNum = " + innerNum);
				System.out.println("outerInstanceNum = " + outerInstanceNum);
				System.out.println("localNum = " + localNum);
			}
		}

		LocalPrinter printer = new LocalPrinter();
		printer.printData();

	}

	public static void main(String[] args) {
		LocalOuterV1 outer = new LocalOuterV1();
		outer.process(30);
	}
}
