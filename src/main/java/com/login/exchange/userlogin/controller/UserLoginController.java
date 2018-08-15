package com.login.exchange.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.exchange.userlogin.Exception.InvalidUserIdException;
import com.login.exchange.userlogin.model.ErrorResponse;
import com.login.exchange.userlogin.model.LoginRequestModel;
import com.login.exchange.userlogin.model.Response;
import com.login.exchange.userlogin.model.SuccessResponse;
import com.login.exchange.userlogin.service.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response<SuccessResponse> userLogin(@RequestBody LoginRequestModel request) {
		Response<SuccessResponse> response;
		try {
			response = userLoginService.login(request);
		} catch (InvalidUserIdException iuException) {
			ErrorResponse er = new ErrorResponse();
			er.setUserName(request.getUserName());
			er.setStatus(400);
			er.setReason("Invalid User ID");
			response = new Response<>();
			response.setError(er);
		}
		return response;

	}

}
