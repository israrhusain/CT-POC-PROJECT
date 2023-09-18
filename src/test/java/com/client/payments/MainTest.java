package com.client.payments;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;





public class MainTest {
	
	

	    public static void main(String[] args) {
	        
	        // JSON data to be hashed
	        String jsonData = "{\"key1\":\"value1\",\"key2\":\"value2\"}";

	        // Your secret key
	        String secretKey = "yourSecretKey";
	        
	        try {
	            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
	            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	            sha256Hmac.init(secretKeySpec);

	            byte[] hmacBytes = sha256Hmac.doFinal(jsonData.getBytes(StandardCharsets.UTF_8));
	            String hmacSha256=Base64.getEncoder().encodeToString(hmacBytes);
	            System.out.println("HMACSHA256: " + hmacSha256);
	        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
	            throw new RuntimeException("Error generating HMACSHA256", e);
	        }
	    }

	        // Generate HMACSHA256 code
//	        String hmacSha256 = HmacSha256Util.generateHmacSha256(jsonData, secretKey);
	        
	    }
	



