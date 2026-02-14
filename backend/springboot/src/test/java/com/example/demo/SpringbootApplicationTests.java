package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled("Skipping during build as local MySQL might not be accessible")
@SpringBootTest
class SpringbootApplicationTests {

	@Test
	void contextLoads() {
	}

}
