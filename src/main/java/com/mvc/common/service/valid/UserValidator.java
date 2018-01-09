package com.mvc.common.service.valid;

import com.mvc.common.model.User;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      User user = (User) target;
      //errors.rejectValue("name", "personname.valid");
    }
}
