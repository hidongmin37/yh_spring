package mvc_test.password_valid;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	@DisplayName("패스워드 초기화 여부를 판단한다.")
	@Test
	void passwordTest() {
		// given
		User user = new User();

		// when
		user.initPassword(new CorrectFixedPasswordGenerator());

		//then
		Assertions.assertThat(user.getPassword()).isNotNull();

	}
}