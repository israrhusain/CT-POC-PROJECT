package com.client.payments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.payments.Service.Testservice;
import com.client.payments.models.TestRequest;
import com.client.payments.models.TestResponse;

@RestController
@RequestMapping("/controller")
public class Testcontroller {

	@GetMapping("/test")
	public String Test() {
           return "Hi this is spring boot app";
       }
	
	
    @PostMapping("/addrequest")
    @ResponseBody
	public TestResponse addRequest(@RequestBody TestRequest request,@RequestHeader String clientSign) {
		  
    	  Testservice test=new Testservice();
    	 String gensign= test.genaerateSign(request);
//    	 TestResponse response=null;
    	 TestResponse response1=new TestResponse();
    	 if(clientSign.equals(gensign)) {
    		 
    		 int res=request.getNum1()+request.getNum2();
   		  
	   		 
	   		  response1.setRes(res);
	   		  return response1;
    		 
    	 }
    	 
    	 else {
    		 return null;
    	 }
    	 
		
	}
	
}
