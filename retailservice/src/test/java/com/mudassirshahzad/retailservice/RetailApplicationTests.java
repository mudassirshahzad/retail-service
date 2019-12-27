package com.mudassirshahzad.retailservice;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
class RetailApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull("must not be null", mockMvc);
	}

}
