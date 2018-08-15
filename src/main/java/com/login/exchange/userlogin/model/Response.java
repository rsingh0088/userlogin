package com.login.exchange.userlogin.model;

public class Response<E> {
	
	public E success;
	
	public ErrorResponse error;

	public E getSuccess() {
		return success;
	}

	public void setSuccess(E success) {
		this.success = success;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
	

}
