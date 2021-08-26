package com.pv.demo.it.validate;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pv.demo.exceptionHandler.PasswordUnableException;
import com.pv.demo.validator.PasswordValidatorBuilder.PasswordValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordServiceImplTest {

	@Autowired
	PasswordValidator passwordValidator;
	
	
	@Test
    public void passwordValidateTest() {
		String[] pass = new String[] {"132abc", "abcd1352", "ab321ab", "abcd123", "0123456abc"};
		boolean result;
		for(int i = 0 ; i < pass.length; i++) {
			result = passwordValidator.validate(pass[i]);
			Assert.assertNotNull(result);
	        Assert.assertEquals(true, result);
		}
    }
	
	@Test(expected = PasswordUnableException.class)
    public void passwordValidateTestEmpytString() {
		passwordValidator.validate("");
		Assert.fail("Didn't validate right!");
	}
	
	@Test(expected = PasswordUnableException.class)
    public void passwordValidateTestRepeat() {
		passwordValidator.validate("aaaaaaaaa1");
		Assert.fail("Didn't validate right!");
	}
	@Test(expected = PasswordUnableException.class)
    public void passwordValidateTestWrongLength() {
		passwordValidator.validate("12ab");
		Assert.fail("Didn't validate right!");
	}
	@Test(expected = PasswordUnableException.class)
    public void passwordValidateTestOtherChar() {
		passwordValidator.validate("!@#$%@*(#");
		Assert.fail("Didn't validate right!");
	}
}
