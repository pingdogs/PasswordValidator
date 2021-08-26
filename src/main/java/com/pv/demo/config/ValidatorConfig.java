package com.pv.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pv.demo.validator.PasswordValidatorBuilder;
import com.pv.demo.validator.PasswordValidatorBuilder.PasswordValidator;
import com.pv.demo.validator.constraints.Constraint;
import com.pv.demo.validator.constraints.OnlyLetterAndNumber;
import com.pv.demo.validator.constraints.PasswordLengthConstraint;
import com.pv.demo.validator.constraints.PasswordUnableReapeatConstraint;





@Configuration
public class ValidatorConfig {
 @Bean
 public PasswordValidator createPasswordValidator(List<Constraint> constraints) {
     PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
     for(int i= 0 ; i < constraints.size(); i++) {
    	 builder.addConstraint(constraints.get(i));
     }
     return builder.build();
 }
}
 