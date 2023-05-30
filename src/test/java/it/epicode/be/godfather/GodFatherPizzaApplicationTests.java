package it.epicode.be.godfather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class GodFatherPizzaApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Value("${application.costoCoperto}")
	double costoCoperto;

	@Test
	void testCoversPrice() {
		log.info("test costo coperti");
		
		assertEquals(6.0, (costoCoperto * 3));
	}

	private void assertEquals(double d, double e) {
		// TODO Auto-generated method stub
	}
}
