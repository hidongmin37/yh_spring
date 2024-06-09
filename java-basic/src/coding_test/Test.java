package coding_test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
	public int[] solution(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr.length % 2 == 0 && i%2==1) {

				arr[i] = arr[i] + n;
			} else if (arr.length % 2 == 1 && i%2==0)  {
				arr[i] = arr[i] + n;
			}

		}
		return arr;
	}
}
