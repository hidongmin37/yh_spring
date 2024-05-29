package mvc_test.calculator;

import java.util.Arrays;

public enum ArithemeticOperator {
	ADDITION("+") {
		@Override
		public int arithemeticOperator(int operand1, int operand2) {
			return operand1 + operand2;
		}
	},
	SUBTRACT("-") {
		@Override
		public int arithemeticOperator(int operand1, int operand2) {
			return operand1 - operand2;
		}
	},
	MULTIPLICATION("*") {
		@Override
		public int arithemeticOperator(int operand1, int operand2) {
			return operand1 * operand2;
		}
	},
	DIVISION("/") {
		@Override
		public int arithemeticOperator(int operand1, int operand2) {
			if (operand2 == 0) {
				throw new IllegalArgumentException("0으로 나눌 수 없습니다");
			}
			return operand1 / operand2;
		}
	};

	private final String operator;

	ArithemeticOperator(String operator) {
		this.operator = operator;
	}

	public abstract int arithemeticOperator(final int operand1, final int operand2);


	public static int calculate(int operand1,String operator , int operand2){
		ArithemeticOperator arithemeticOperator = Arrays.stream(values())
			.filter(v -> v.operator.equals(operator))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
		return arithemeticOperator.arithemeticOperator(operand1, operand2);
	}
}
