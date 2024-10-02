package mcic.tendencias.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "mcic.entities")
@ComponentScan(basePackages = {"mcic.services", "mcic.mappers", "mcic.tendencias.parcial.controller"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = "mcic.repositories")
public class ParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcialApplication.class, args);
	}
}
