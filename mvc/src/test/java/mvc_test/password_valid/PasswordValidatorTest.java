package mvc_test.password_valid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PasswordValidator.class)
class PasswordValidatorTest {

	@Test
	void passWordValidator() {
		// Assertions.assertThrows(IllegalArgumentException.class, () -> {
		// 	PasswordValidator.validate("servicewizard");
		// });        //
		org.assertj.core.api.Assertions.assertThatCode(() -> PasswordValidator.validate("serverwizard")).doesNotThrowAnyException();
	}

	@DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings ={"abc","sdfsdsdlkfjelkjfelkj"} )
	void passWordValidatorError(String password) {
		extracted_check_wrong(password);
		extracted_check_wrong(password);
	}

	private static void extracted_check_wrong(String IllegalArgumentException) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PasswordValidator.validate(IllegalArgumentException);
		});
	}
}