package com.example.price_service;

import com.example.price_service.dto.PriceData;
import com.example.price_service.service.PriceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class PriceServiceApplication implements ApplicationRunner {

	@Autowired
	private PriceDataService service;

	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		int count = 10000;
		while(count > 0) {
			String payload = "{\n" +
					"              \"tt\":\"1727395200\",\n" +
					"              \"symbol\":\"NSE:TCS-EQ\",\n" +
					"              \"lp\":4312.4,\n" +
					"              \"ch\":19.9,\n" +
					"              \"high_price\":4378,\n" +
					"              \"description\":\"NSE:TCS-EQ\",\n" +
					"              \"chp\":0.46,\n" +
					"              \"fyToken\":\"101000000011536\",\n" +
					"              \"spread\":0.6,\n" +
					"              \"volume\":1963609,\n" +
					"              \"original_name\":\"NSE:TCS-EQ\",\n" +
					"              \"ask\":4313,\n" +
					"              \"exchange\":\"NSE\",\n" +
					"              \"short_name\":\"TCS-EQ\",\n" +
					"              \"bid\":4312.4,\n" +
					"              \"low_price\":4303,\n" +
					"              \"open_price\":4335,\n" +
					"              \"prev_close_price\":4292.5,\n" +
					"              \"atp\": 4315.6\n" +
					"          }";
			service.sendMessage(new PriceData("TCS", LocalDateTime.now(), payload));
			count--;
		}
	}
}
