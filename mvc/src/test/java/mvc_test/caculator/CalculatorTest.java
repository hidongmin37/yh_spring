package mvc_test.caculator;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import mvc_test.calculator.Calculator;
import mvc_test.calculator.PositiveNumber;

/*
* 요구사항
* 간단한 사칙연산을 할 수 있다.
* 양수로만 계산할 수 있다.
* 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다
* MVC패턴(Model-view-Controller)기반으로 구현한다 */
public class CalculatorTest {


	//
	@DisplayName("사칙 연산을 수행한다.")
	@ParameterizedTest
	@MethodSource("calculateTestMethod")
	void calculateTest(int operand1,String operator, int operand2,int result) {

		int calculate = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

		Assertions.assertThat(calculate).isSameAs(result);
	}

	private static Stream<Arguments> calculateTestMethod() {
		return Stream.of(
			Arguments.of(1, "+",2,3),
			Arguments.of(5, "-",2,3),
			Arguments.of(4, "/",0,0),
			Arguments.of(7, "*",2,14)
		);
	}

	@Test
	void divideException() {
		Assertions.assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(-1)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
