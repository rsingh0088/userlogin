package com.login.exchange.userlogin.service;

import com.login.exchange.userlogin.Exception.InvalidUserIdException;
import com.login.exchange.userlogin.model.LoginRequestModel;
import com.login.exchange.userlogin.model.Response;
import com.login.exchange.userlogin.model.SuccessResponse;

public interface UserLoginService {

	public Response<SuccessResponse> login (LoginRequestModel request) throws InvalidUserIdException;

}
