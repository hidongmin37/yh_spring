package mvc_test.grdle_calculator;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/*
* 요구사항
* 평균학점 계산 방법  = (학점수 * 교과목 평점)의 합계 / 수강 신청 총학점 수
* 일급 컬렉션 사용*/
public class GradleCalculatorTest {
	//학점계산기 도메인 : 이수한 과목, 학점 계산기
	// 이수한 과목: 객체 지향 프로그래밍, 자료구조,중국어회화 --> 과목(코스) 클래스

	// 이수한 과목을 전달하여 평균학점 계산 요청 ----> 학점 계산기

	@Test
	void calculateGradeTest() {
		List<Course> courses = List.of(new Course("OOP", 3, "A+")
			, new Course("자료구조",3,"A+")
		);

		GradleCalculator gradleCalculator = new GradleCalculator(courses);
		double result = gradleCalculator.calculateGrade();
		Assertions.assertThat(result).isEqualTo(4.5);
	}
}
