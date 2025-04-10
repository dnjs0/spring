package com.test.java.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public int work(String word) {
		
		return word.length();
		
	}
	
	
}
