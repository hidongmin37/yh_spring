package coding_test;

class Solution2 {
	public int solution(int a, int b, int n) {
		int answer = 0;
		int mock = n;

		while (true) {
			int pool = mock / a;
			int pool2 = mock % a;

			mock = (pool) + (pool2);
			answer += pool *b;

			if (mock< a ) {
				break;
			} else if (mock ==a) {
				answer += b;
				break;
			}
		}
		return answer;
	}
}