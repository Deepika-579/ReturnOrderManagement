package com.returnorder.portal.service;


import org.springframework.stereotype.Service;


import com.returnorder.portal.dto.AuthenticationResponseDTO;

import com.returnorder.portal.model.LoginModel;

@Service
public interface LoginService {

	LoginModel LoginSaveService(LoginModel loginModelObj);
	
	boolean getValidity(String token);

    AuthenticationResponseDTO login(LoginModel model);

}
  