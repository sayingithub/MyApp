package com.example;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CardService {
	private final RestTemplate restTemplate;

	public CardService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "fallbackCardValidation")
	//commandProperties = {	@HystrixProperty(name="execution.timeoutInMilliseconds", value="4000")}
	
	  public String callCardValidation(String cardNo) {
		  System.out.println("cardNo in callCardValidation"+cardNo);
		  

		  String uriValue = null;
		  URI uri = URI.create("http://localhost:8600/validateCard?cardNo="+cardNo);
		  uriValue = this.restTemplate.getForObject(uri, String.class);
	      
		  //to open the circuit
		  //String temp = null;
		  //temp.trim();
		  		  
		  
		  
		  return "<html><body>"
		    		+ "<form>Card Number: <input type='text' name='cardno' value="+cardNo+" readOnly/><br> "
		    				+ "Card Type: <input type='text' name='cardType' value="+uriValue+" readOnly/><br>"
		    				+ "</form></body</html>";
	  }

	public String fallbackCardValidation(String cardNo) {
		
		
		return "<html><body>" + "<form>Card Number: <input type='text' name='cardno' value=" + cardNo
				+ " readOnly/><br> "
				+ "Please select Card Type: <select name='cardType'><option name='Master'/>Master</option><option name='Visa'>Visa</option></option name='Diners'></option><option name='Discover'></option></select> "
				+ "</form></body</html>";
	}
	
	@HystrixCommand(fallbackMethod = "fallbackCardValidation1")
	  public String callCardValidation1(String cardNo) {
		  System.out.println("cardNo in callCardValidation"+cardNo);
		  
		  String uriValue = null;
		  URI uri = URI.create("http://localhost:8600/validateCard?cardNo="+cardNo);
		  uriValue = this.restTemplate.getForObject(uri, String.class);
	      
		  return "<html><body>"
		    		+ "<form>Card Number: <input type='text' name='cardno' value="+cardNo+" readOnly/><br> "
		    				+ "Card Type: <input type='text' name='cardType' value="+uriValue+" readOnly/><br>"
		    				+ "</form></body</html>";
	  }

	public String fallbackCardValidation1(String cardNo) {
		return "<html><body>" + "<form>Card Number: <input type='text' name='cardno' value=" + cardNo
				+ " readOnly/><br> "
				+ "Please select Card Type: <select name='cardType'><option name='Master'/>Master</option><option name='Visa'>Visa</option></option name='Diners'></option><option name='Discover'></option></select> "
				+ "</form></body</html>";
	}
	
}
