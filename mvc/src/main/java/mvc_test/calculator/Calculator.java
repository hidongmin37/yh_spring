package mvc_test.calculator;

import java.util.List;

public class Calculator {
	private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
		new DivisionOperator(), new MultiplicationOperator(),new SubtractOperator());

	public static int calculate(PositiveNumber operand1,String operator,PositiveNumber operand2) {
		// int result = 0;
		// switch(operator){
		// 	case "+":
		// 		result = operand1 + operand2;
		// 		break;
		// 	case "-":
		// 		result = operand1 - operand2;
		// 		break;
		// 	case "/":
		// 		if (operand2 == 0) {
		// 			throw new IllegalArgumentException("0으로 나눌 수 없습니다");
		// 		}
		// 		result = operand1 / operand2;
		// 		break;
		// 	case "*":
		// 		result = operand1 * operand2;
		// 		break;
		// 	default:
		// 		break;
		// }
		// return result;

		// return ArithemeticOperator.calculate(operand1,operator ,operand2);
		return arithmeticOperators.stream()
			.filter(arithmeticOperators -> arithmeticOperators.supports(operator))
			.map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}
