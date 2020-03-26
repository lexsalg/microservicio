package microservicio.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenesApplication.class, args);
	}

}
