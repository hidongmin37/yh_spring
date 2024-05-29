package mvc_test.password_valid;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class User {
	private String password;

	public void initPassword(PasswordGenerator passwordGenerator) {
		// RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
		String randomPassword = passwordGenerator.generatePassword();

		/*
		* 비밀번호는 최소 8자 이상 12자 이하여야 한다..
		* */
		if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
			this.password = randomPassword;
			log.info("password = {}",randomPassword);
		}
	}
}
