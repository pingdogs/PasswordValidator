package com.pv.demo.validator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.pv.demo.validator.constraints.Constraint;

public class PasswordValidatorBuilder {
	private List<Constraint> constraints;
	
	public PasswordValidatorBuilder() {
		constraints = new LinkedList();
	}
	
	public class PasswordValidator{
		
		private List<Constraint> constraints;
		
		public PasswordValidator(List<Constraint> constraints) {
			this.constraints = constraints;
		}
		
		public boolean validate(String s) {
			Iterator<Constraint> it = constraints.iterator();
			while(it.hasNext()) {
				Constraint c = it.next();
				if(!c.is_valid(s))
					return false;
			}
			return true;
		}
	}
	
	public PasswordValidatorBuilder addConstraint(Constraint c) {
		constraints.add(0, c);
		return this;
	}
	
	public PasswordValidator build() {
        return new PasswordValidator(constraints);
    }
	

}
