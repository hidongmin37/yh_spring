package mvc_test.grdle_calculator;

import java.util.List;

public class GradleCalculator {

	private final Courses courses;
	public GradleCalculator(List<Course> courses) {
		this.courses = new Courses(courses);
	}



	public double calculateGrade() {
		double v = courses.multiplyCreditAndCourse();
		double v1 = courses.calculateTotalCompletedCredit();
		return v/v1;
	}
}
