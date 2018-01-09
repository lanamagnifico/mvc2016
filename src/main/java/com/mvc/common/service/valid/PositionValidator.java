package com.mvc.common.service.valid;

import com.mvc.common.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PositionValidator implements Validator{
    @Override
    public boolean supports(Class clazz) {
        return Position.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      Position position = (Position) target;
    }
}
