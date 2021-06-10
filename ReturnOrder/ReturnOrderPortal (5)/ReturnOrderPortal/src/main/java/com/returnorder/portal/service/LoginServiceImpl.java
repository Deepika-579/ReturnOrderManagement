package com.returnorder.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnorder.portal.client.AuthClient;
import com.returnorder.portal.dto.AuthenticationResponseDTO;

import com.returnorder.portal.model.LoginModel;
import com.returnorder.portal.repo.LoginRepo;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
    private AuthClient authClient;


	@Override
	public LoginModel LoginSaveService(LoginModel loginModelObj) {
		loginRepo.save(loginModelObj);

		return loginModelObj;
	}

	@Override
	public boolean getValidity( @RequestHeader("Authorization")String token) {
		log.info("LoginServiceImpl [getValidity Method]");
		boolean validityStatus = authClient.getsValidity(token).isValidStatus();
		log.info("Status is ");
		System.out.println(validityStatus);
		return validityStatus;
	}

	@Override
	public AuthenticationResponseDTO login(LoginModel model) {
		log.info("LoginServiceImpl [login Method]");
		return authClient.login(model);
        
	}
	   
}
