package com.login.exchange.userlogin.service.impl;

import javax.activity.InvalidActivityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.exchange.userlogin.Exception.InvalidUserIdException;
import com.login.exchange.userlogin.entity.Usr;
import com.login.exchange.userlogin.model.LoginRequestModel;
import com.login.exchange.userlogin.model.Response;
import com.login.exchange.userlogin.model.SuccessResponse;
import com.login.exchange.userlogin.repository.UserRepository;
import com.login.exchange.userlogin.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Response<SuccessResponse> login(LoginRequestModel request) throws InvalidUserIdException {
		Response<SuccessResponse> response= new Response<>();
		SuccessResponse successResponse = new SuccessResponse();
		if (request != null && request.getUserName() != null && request.getPassWord() != null) {
				Usr usr= userRepository.findByUserName(request.getUserName());
				if(usr != null) {
					if(request.getPassWord().equals(usr.getPassword())) {
						String loginKey=generateLoginKey(request.getUserName());
						userRepository.updateLoginKey(request.getUserName(),loginKey);
						successResponse.setLoginKey(loginKey);
						successResponse.setUserId(request.getUserName());
						response.setSuccess(successResponse);
						
					}
				} else {
					throw new InvalidUserIdException("Invalid User Id"); 
				}
		} else {
			StringBuilder sb=new StringBuilder();
			
			if(request!=null ) {
				sb.append("Mandetory field missing");
				if(request.getUserName() ==null) {
					sb.append(" :User Id");
				}
				if(request.getPassWord() == null) {
					sb.append(" :Passwprd");
				}
			} else {
				sb.append("Request is null");
			}
		}
		request.setPassWord("********");
		return response;
	}

	private String generateLoginKey(String userName) {
		final Object obj = new Object();
		Integer loginKey=obj.hashCode();
		return loginKey.toString()+"-"+userName;
	}

}
