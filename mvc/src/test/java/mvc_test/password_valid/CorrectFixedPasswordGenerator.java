package mvc_test.password_valid;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{

	@Override
	public String generatePassword() {
		return "abcdefgddd";
	}
}
