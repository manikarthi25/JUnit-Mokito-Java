package com.manikarthi25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manikarthi25.service.IOrderService;

@RestController
@RequestMapping("order")
public class JunitController {

	@Autowired
	private IOrderService junitService;

	@GetMapping("/{name}")
	public String getWelcomeMesage(@PathVariable("name") String name) {
		return junitService.getWelcomeMesage(name);
	}

}
