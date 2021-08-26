package com.pv.demo.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pv.demo.Service.PasswordService;
import com.pv.demo.core.vo.CommonResult;



@RestController
@RequestMapping("/api/v1/")
public class PasswordValidateController {
//	
//	
	@Autowired
	PasswordService passwordService;
//	
	@RequestMapping(path = "/check", method=RequestMethod.POST)
	 public CommonResult<Boolean> passwordCheckPOST(@RequestParam("password") String password) {
		 return CommonResult.success(passwordService.is_valid(password));
	 }
	

}
