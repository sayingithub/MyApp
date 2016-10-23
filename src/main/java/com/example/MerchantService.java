package com.example;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Service
public class MerchantService {
	/*private final RestTemplate restTemplate;

	public MerchantService(RestTemplate rest) {
		this.restTemplate = rest;
	}*/
	@RequestMapping("/merchant")
	public String MerchantInquiry(){
		return "Qantas Airlines";
	}
}
