package mvc_test.password_valid;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomPasswordGenerator implements mvc_test.password_valid.PasswordGenerator {

	public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";

	public static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";

	@Override
	public String generatePassword() {
		PasswordGenerator gen = new PasswordGenerator();

		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(2);

		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(2);

		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(2);

		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return ERROR_CODE;
			}

			public String getCharacters() {
				return ALLOWED_SPL_CHARACTERS;
			}
		};
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(2);

		// 0 ~ 12
		String password_new = gen.generatePassword((int)(Math.random() * 13), splCharRule, lowerCaseRule, upperCaseRule,
			digitRule);
		log.info("password = {}",password_new);
		return password_new;
	}
}
