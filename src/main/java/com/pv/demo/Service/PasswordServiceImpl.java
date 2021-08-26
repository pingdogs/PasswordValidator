package com.pv.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.demo.validator.PasswordValidatorBuilder.PasswordValidator;

@Service
public class PasswordServiceImpl implements PasswordService{
	
	@Autowired
	PasswordValidator passwordValidator;

	@Override
	public boolean is_valid(String s) {
		return passwordValidator.validate(s);
	}

}
