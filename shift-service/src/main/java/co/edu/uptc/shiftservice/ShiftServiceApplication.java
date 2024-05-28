package co.edu.uptc.shiftservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "co.edu.uptc.shiftservice.infrastructure.repository")
public class ShiftServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiftServiceApplication.class, args);
	}

}
