package com.pv.demo.ut.constraint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pv.demo.exceptionHandler.PasswordUnableException;
import com.pv.demo.validator.constraints.OnlyLetterAndNumber;
import com.pv.demo.validator.constraints.PasswordLengthConstraint;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordLengthContraintTest {
	private PasswordLengthConstraint passwordLengthConstraint;
	
	@Before
    public void init() {
		passwordLengthConstraint = new PasswordLengthConstraint();
    }
	
	@Test
    public void passwordLengthConstraintIsValidTest(){
		String[] pass = new String[] {"12345", "1235678", "------", "123456789111", "abcdefghijkl"};
		boolean result;
		for(int i = 0 ; i < pass.length; i++) {
			result = passwordLengthConstraint.is_valid(pass[i]);
			Assert.assertNotNull(result);
	        Assert.assertEquals(true, result);
		}
		String[] notPass = new String[] {"", "1", "777", "----", "123b", "1234", "abcdefghijklk"};
		for(int i = 0 ; i < notPass.length; i++) {
			try {
				result = passwordLengthConstraint.is_valid(notPass[i]);
			}catch(PasswordUnableException e) {
				Assert.assertEquals("The length of input password should between 5 and 12", e.getMessage());
			}
		}
    }

}
