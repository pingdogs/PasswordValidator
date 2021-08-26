package com.pv.demo.it.exceptionHandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pv.demo.constant.ServiceExceptionEnum;
import com.pv.demo.core.vo.CommonResult;
import com.pv.demo.exceptionHandler.GlobalExceptionHandler;
import com.pv.demo.exceptionHandler.PasswordUnableException;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=GlobalExceptionHandler.class)
public class GlobalExceptionHandlerTest {
	
	@Autowired
	GlobalExceptionHandler globalExceptionHandler;
	
	@Test
    public void PasswordUnableExceptionHandlerTest() throws Exception{
		CommonResult cr = globalExceptionHandler.PasswordUnableExceptionHandler(new PasswordUnableException(ServiceExceptionEnum.VALIDATION_ERROR,
				"Exception"));
		PasswordUnableException pue = new PasswordUnableException(ServiceExceptionEnum.VALIDATION_ERROR,
				"Exception");
		CommonResult expect = CommonResult.error(pue.getCode(), pue.getMessage());
		Assert.assertEquals(cr, expect);
		
    }
	
	@Test
    public void exceptionHandlerHandlerTest() {
		CommonResult cr = globalExceptionHandler.exceptionHandler(new Exception("Exception"));
		CommonResult expect = CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
		Assert.assertEquals(cr, expect);
    }

}
