package com.pv.demo.validator.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.pv.demo.constant.ServiceExceptionEnum;
import com.pv.demo.exceptionHandler.PasswordUnableException;


@Component
public class PasswordLengthConstraint implements Constraint{

	@Override
	public boolean is_valid(String s) {
		boolean pass = s.matches("^.{5,12}$");
		if(!pass)
			throw new PasswordUnableException(ServiceExceptionEnum.VALIDATION_ERROR,
					"The length of input password should between 5 and 12");
		return true;
	}

}
