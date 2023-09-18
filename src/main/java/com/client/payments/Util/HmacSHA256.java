package com.client.payments.Util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256 {

	
	   public static String generateSignature(String secretKey,String json) {
		      
		  String hmacSha256=null;
		   try {
	            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
	            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	            sha256Hmac.init(secretKeySpec);

	            byte[] hmacBytes = sha256Hmac.doFinal(json.getBytes(StandardCharsets.UTF_8));
	            hmacSha256=Base64.getEncoder().encodeToString(hmacBytes);
	            System.out.println("HMACSHA256: " + hmacSha256);
	  
	        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
	            throw new RuntimeException("Error generating HMACSHA256", e);
	        }
		   return hmacSha256;
	   }
}
