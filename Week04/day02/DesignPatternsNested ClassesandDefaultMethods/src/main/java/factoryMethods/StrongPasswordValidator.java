package factoryMethods;

public class StrongPasswordValidator extends StandardPasswordValidator {

	@Override
	default boolean isValid(String password){
		return isLongEnough(password);
	}

}
