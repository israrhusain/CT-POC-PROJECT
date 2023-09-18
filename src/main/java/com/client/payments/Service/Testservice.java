package com.client.payments.Service;

import com.client.payments.Util.HmacSHA256;
import com.client.payments.models.TestRequest;
import com.google.gson.Gson;

public class Testservice {

	  String secretKey="client-poc-key";
	  
	  public String genaerateSign(TestRequest request) {
		     
		    Gson gson=new Gson();
		    String json= gson.toJson(request).toString();
		    System.out.println("json object"+json);
		   
		     String genSignature=HmacSHA256.generateSignature(secretKey, json);
		     System.out.println("generated signature "+genSignature);
		     return genSignature;
	  }
}
