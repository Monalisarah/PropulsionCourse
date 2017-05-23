package factoryMethods;

public class StrongPasswordValidator extends StandardPasswordValidator {

	@Override
	public boolean isValid(String password){
		return isLongEnough(password);
	}

}
