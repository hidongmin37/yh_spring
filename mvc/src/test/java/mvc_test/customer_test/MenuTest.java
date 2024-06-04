package mvc_test.customer_test;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {

	@DisplayName("메뉴이름에 해당한느 메뉴를 반환한다.")
	@Test
	void chooseTest() {
		Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

		MenuItem menuItem = menu.choose("돈까스");

		Assertions.assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
	}
	@DisplayName("메뉴판에 없는 메뉴를 선택할 시 예외를 반환한다.")
	@Test
	void chooseTest2() {
		Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

		Assertions.assertThatCode(() -> menu.choose("통닭"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("잘못된 메뉴 입니다.");

	}
}
