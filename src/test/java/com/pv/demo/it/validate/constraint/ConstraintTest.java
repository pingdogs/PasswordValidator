package com.pv.demo.it.validate.constraint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pv.demo.exceptionHandler.PasswordUnableException;
import com.pv.demo.validator.constraints.OnlyLetterAndNumber;
import com.pv.demo.validator.constraints.PasswordLengthConstraint;
import com.pv.demo.validator.constraints.PasswordUnableReapeatConstraint;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConstraintTest {
	
	@Autowired
	private OnlyLetterAndNumber onlyLetterAndNumber;
	
	@Autowired
	private PasswordLengthConstraint passwordLengthConstraint;
	
	@Autowired
	private PasswordUnableReapeatConstraint passwordUnableReapeatConstraint;
	
	
	@Test
    public void onlyLetterAndNumberIsValidTest(){
		String[] pass = new String[] {"1a", "a1", "aa11", "aaaaaaaaaaaaaaaa1", "11111111111111a"};
		boolean result;
		for(int i = 0 ; i < pass.length; i++) {
			result = onlyLetterAndNumber.is_valid(pass[i]);
			Assert.assertNotNull(result);
	        Assert.assertEquals(true, result);
		}
		String[] notPass = new String[] {"", "1", "b", "A", "Aa", "A1", "Aa111a32a"};
		for(int i = 0 ; i < notPass.length; i++) {
			try {
				result = onlyLetterAndNumber.is_valid(notPass[i]);
			}catch(PasswordUnableException e) {
				Assert.assertEquals("Input password should only contain aleast one lowercase letter and one number", e.getMessage());
			}
		}
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
	
	@Test
    public void passwordUnableReapeatConstraintIsValidTest(){
		String[] pass = new String[] {"abcd", "a", "12345", "abcba", "", "2014", "abcdefg", "12321", "1234567898764321"};
		boolean result;
		for(int i = 0 ; i < pass.length; i++) {
			result = passwordUnableReapeatConstraint.is_valid(pass[i]);
			Assert.assertNotNull(result);
	        Assert.assertEquals(true, result);
		}
		String[] notPass = new String[] {"aa123456", "abba", "a1a3a1a3", "a1a33dfs", "bacbabdcaa", "cccccc",};
		for(int i = 0 ; i < notPass.length; i++) {
			try {
				result = passwordUnableReapeatConstraint.is_valid(notPass[i]);
			}catch(PasswordUnableException e) {
				Assert.assertEquals("Input password must not contain any sequence of characters immediately followed by the same sequence.", e.getMessage());
			}
		}
    }
	
}
