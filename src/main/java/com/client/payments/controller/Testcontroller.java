package com.client.payments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {

	@GetMapping("/controller")
	public String Test() {

		return "Hi this is spring boot apppsjhssabasbsjasbashgahsawghasba";
        
		

	}
	
	public String Test1() {
		return "hi";
	}
	 
	public String  ssss() {
		return "hfjh";
	}
	
	public String Test1() {
		return "hi";
	}
	
}
