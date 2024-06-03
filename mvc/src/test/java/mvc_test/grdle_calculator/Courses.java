package mvc_test.grdle_calculator;

import java.util.List;

public class Courses {
	private final List<Course> courses;

	public Courses(List<Course> courses) {
		this.courses = courses;
	}

	public double multiplyCreditAndCourse() {
		// double totalCourseGrade = 0;
		// for (Course course : courses) {
		// 	// totalCourseGrade += course.getCredit() * course.getGradeToNumber();
		// 	totalCourseGrade += course.multipleCreditWithGrade();
		// }
		// return totalCourseGrade;
		return courses.stream()
			.mapToDouble(Course::multipleCreditWithGrade)
			.sum();
	}

	public double calculateTotalCompletedCredit() {

		double resultGrade = courses.stream().mapToDouble(Course::getCredit)
			.sum();
		return resultGrade;
	}
}
