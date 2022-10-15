package com.example.orderfood;

import com.example.orderfood.service.InputService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderfoodApplicationTests {

	@Autowired
	private InputService inputService;

	@Test
	void contextLoads() {
		assertThat(inputService).isNotNull();
	}

}
