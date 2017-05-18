package factoryMethods;

public class StandardPasswordValidator implements PasswordValidator {

	@Override
	public boolean isLongEnough(String password) {
		return password != null && password.length() > 8;
	}

}
