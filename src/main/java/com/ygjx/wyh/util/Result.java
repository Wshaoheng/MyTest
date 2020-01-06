package com.ygjx.wyh.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result{
	 
	private ResultCode resultCode;
	private String message;
	private Object data;
	
	public ResultCode getResultCode() {
		return resultCode;
	}
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	
	public Result() {
		// TODO Auto-generated constructor stub
	}	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	//查询成功返回的东西
	public static Result success(Object data){
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}
	
	//添加删除修改成功之后调用
	public static Result success(){
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}
	
	//添加失败调用
	public static Result failure(ResultCode resultCode){
		Result result = new Result();
		result.setResultCode(resultCode);
		return result;
	}
	
	//其他失败调用的
	//查询成功返回的东西
	public static Result success(Object data,ResultCode resultCode){
		Result result = new Result();
		result.setResultCode(resultCode);
		result.setData(data);
		return result;
	}
	
}
