package com.pv.demo.validator.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.pv.demo.constant.ServiceExceptionEnum;
import com.pv.demo.exceptionHandler.PasswordUnableException;


@Component
public class OnlyLetterAndNumber implements Constraint{

	@Override
	public boolean is_valid(String s) {
		boolean pass = s.matches("^(?:[0-9]+[a-z]|[a-z]+[0-9])[a-z0-9]*$");
		if(!pass)
			throw new PasswordUnableException(ServiceExceptionEnum.VALIDATION_ERROR, 
					"Input password should only contain aleast one lowercase letter and one number");
		return true;
		
	}

}
