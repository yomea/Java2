package youth.hong;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MyValidation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return User.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "date", "username.required");
	}

}
