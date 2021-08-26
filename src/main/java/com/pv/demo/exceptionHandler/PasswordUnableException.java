package com.pv.demo.exceptionHandler;

import com.pv.demo.constant.ServiceExceptionEnum;

public final class PasswordUnableException extends RuntimeException {
    private final Integer code;
    private String message;
 
    public PasswordUnableException(ServiceExceptionEnum serviceExceptionEnum, String message) {
        super(serviceExceptionEnum.getMessage() + " : " + message);
        this.message = message;
        this.code = serviceExceptionEnum.getCode();
    }
    
    @Override
    public String getMessage() {
    	return message;
    }

    public Integer getCode() {
        return code;
    }

	@Override
	public String toString() {
		return "ServiceException [code=" + code + "]";
	}
    
    

}
