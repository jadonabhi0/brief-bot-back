package com.abhi.briefbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HomeController {
	
	@GetMapping("/response/kl")
	public String homeController() {
		return "Hello, Everything all Set";
	}

}
