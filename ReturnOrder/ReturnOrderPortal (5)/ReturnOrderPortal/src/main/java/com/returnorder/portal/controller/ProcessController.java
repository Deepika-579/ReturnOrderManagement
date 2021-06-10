package com.returnorder.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

import com.returnorder.portal.client.AuthClient;

import com.returnorder.portal.client.ComponentClient;
import com.returnorder.portal.dto.PaymentStatusDTO;
import com.returnorder.portal.model.ProcessRequest;
import com.returnorder.portal.model.ProcessResponse;

import com.returnorder.portal.service.ProcessRequestServiceImpl;



@Controller
@Slf4j
public class ProcessController {

	@Autowired
	private ProcessRequestServiceImpl processRequestServiceImplObj;
	@Autowired
	ComponentClient componentClient;
	@Autowired
	ProcessResponse processResponse;
	@Autowired
	AuthClient authClient;

	PaymentStatusDTO paymentStatusDTO = new PaymentStatusDTO();

	@GetMapping("/order")
	public ModelAndView showProcessing() {
		ModelAndView mv = new ModelAndView("orderDetails");
		mv.addObject("model", new ProcessRequest());
		return mv;
	}

	@PostMapping("/order")
	public ModelAndView performLogin(@Valid @ModelAttribute("model") ProcessRequest model, BindingResult result,
			HttpServletRequest request) throws FeignException{
		ModelAndView mv = new ModelAndView("orderDetails");
		if (result.hasErrors()) {
			return mv;
		}
		try {
			processResponse = processRequestServiceImplObj.processRequestSaveService(model,(String)request.getSession().getAttribute("token"));

			mv.addObject("response", processResponse);

			paymentStatusDTO = processRequestServiceImplObj.statusDetails(model,(String)request.getSession().getAttribute("token"));
			mv.addObject("payment", paymentStatusDTO);
			log.info(model.toString());
      
				mv.setViewName("cart");
				return mv;
	

		} catch (Exception e) {
			mv.setViewName("cart");
				return mv;
			
			
		}

		

	}





}
