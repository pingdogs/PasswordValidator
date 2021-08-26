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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OnlyLetterAndNumberContraintTest {
	private OnlyLetterAndNumber onlyLetterAndNumber;
	
	@Before
    public void init() {
		onlyLetterAndNumber = new OnlyLetterAndNumber();
    }
	
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

}
