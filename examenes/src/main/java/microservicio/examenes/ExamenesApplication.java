package microservicio.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "microservicio.commonsexamenes.models.entity" })
public class ExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenesApplication.class, args);
	}

}
