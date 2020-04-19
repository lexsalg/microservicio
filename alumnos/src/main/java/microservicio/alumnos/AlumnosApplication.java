package microservicio.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "microservicio.commonsalumnos.models.entity" })
public class AlumnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumnosApplication.class, args);
	}

}
