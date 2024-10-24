package nested.inner.ex1;

public class InnerOuter {

	private static int outerStaticNum = 10;

	private int outInstanceNum = 20;

	 class InnerInner {

		public void print() {
			System.out.println("outerStaticNum = " + outerStaticNum);
			System.out.println("outInstanceNum = " + outInstanceNum);}
	}
}
