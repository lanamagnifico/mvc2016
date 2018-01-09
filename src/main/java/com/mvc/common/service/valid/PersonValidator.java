package com.mvc.common.service.valid;

import com.mvc.common.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      Person person = (Person) target;

        if (person.getName().length()<5){
            errors.rejectValue("name", "personname.valid");
        }
    }
}
