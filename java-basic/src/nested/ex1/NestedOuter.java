package nested.ex1;

public class NestedOuter {

	private static int outerStaticNum = 10;
	private int outInstanceNum = 20;

	static class NestedInner {
		private int innerNum = 100;
		private static int innerStaticNum = 200;

		public void print() {
			System.out.println("outerStaticNum = " + outerStaticNum);
			System.out.println("innerNum = " + innerNum);
			System.out.println("innerStaticNum = " + innerStaticNum);
		}
	}


}
