package com.pv.demo.validator.constraints;

import org.springframework.stereotype.Component;

import com.pv.demo.constant.ServiceExceptionEnum;
import com.pv.demo.exceptionHandler.PasswordUnableException;

@Component
public class PasswordUnableReapeatConstraint implements Constraint{

	@Override
	public boolean is_valid(String s) {
		int n = s.length();
		for(int i = 1 ; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(i-j < 0)
					break;
				String pre = s.substring(i - j, i);
				String back = s.substring(i, j+1);
				if(pre.equals(back))
					throw new PasswordUnableException(ServiceExceptionEnum.VALIDATION_ERROR,
							"Input password must not contain any sequence of characters immediately followed by the same sequence.");
			}
			
		}
		return true;
	}

}
