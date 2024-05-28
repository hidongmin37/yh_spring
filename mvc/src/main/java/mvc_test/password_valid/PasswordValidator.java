package mvc_test.password_valid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordValidator {

	private static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자이상 최대 12자이하여야한다.";
	public static void validate(String password) {
		int length = password.length();
		if (length < 8 || length > 12) {
			log.info("비밀번호가 알맞게 입력되지 않았습니다.");
			throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
		}
	}


}
