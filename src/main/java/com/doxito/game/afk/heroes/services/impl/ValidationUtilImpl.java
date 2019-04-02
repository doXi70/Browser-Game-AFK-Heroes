package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.services.ValidationUtil;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author pmiroslav
 */
@Component
public final class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Override
    public <T> boolean isValid(T object) {
        return object != null && validator.validate(object).isEmpty();
    }

    @Override
    public <T> String getViolationMessage(T object) {
        return validator.validate(object).iterator().next().getMessage();
    }
}
