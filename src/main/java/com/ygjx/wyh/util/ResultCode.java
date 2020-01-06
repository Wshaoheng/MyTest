package com.ygjx.wyh.util;

public enum ResultCode {
	
	SUCCESS(1,"成功"),
	ERROR(0,"错误"),
	
	PARAM_IS_INVALID(1001,"参数无效"),
	PARAM_IS_BLANK(1002,"参数为空"),
	PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
	PARAM_NOT_COMPLETE(1004,"参数缺失"),
	
	USER_NOT_LOGGED_IN(2001,"用户未登录，访问的路径须验证，请登录"),
	USER_LOGIN_ERROR(2002,"账户不存在或密码错误"),
	USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
	USER_NOT_EXIST(2004,"用户不存在"),
	USER_HAS_EXISTED(2005,"用户已存在"),
	
	RESULT_IS_NOT(5000,"没有符合您想要的查询结果"),
	RESULT_OTHER_ERROR(9999,"没有进入方法，直接跳转返回"); 
	
	
	private Integer code;
	private String message;
	
	private ResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Integer code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}
	
}
