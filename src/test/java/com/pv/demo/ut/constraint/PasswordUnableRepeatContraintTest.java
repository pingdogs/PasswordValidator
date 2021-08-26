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
import com.pv.demo.validator.constraints.PasswordUnableReapeatConstraint;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordUnableRepeatContraintTest {
	private PasswordUnableReapeatConstraint passwordUnableReapeatConstraint;
	
	@Before
    public void init() {
		passwordUnableReapeatConstraint = new PasswordUnableReapeatConstraint();
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
