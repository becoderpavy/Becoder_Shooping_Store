package com.ecom.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom.repository.ProductRepository;

@SpringBootTest
public class EcomServiceTest {

	@Autowired
	private ProductRepository productRepo;
	
	@Test
	public void productSave()
	{
		//productRepo.deleteById(1);
		
	}
	
}
