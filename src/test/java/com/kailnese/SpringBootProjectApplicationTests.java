package com.kailnese;

import com.kailnese.bean.Client;
import com.kailnese.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringBootProjectApplicationTests {
	@Autowired
	ClientRepository testRepository;

	@Test
	public void testDB(){
		Client client = new Client();
		client.setUsername("emliy");
		client.setPassword("123");
		client.setAge(21);
		client.setBirthday(new Date());
		client.setEmail("ddd@gmail.com");
		client.setGender("female");
		testRepository.save(client);
	}
	@Test
	void contextLoads() {

	}

}
