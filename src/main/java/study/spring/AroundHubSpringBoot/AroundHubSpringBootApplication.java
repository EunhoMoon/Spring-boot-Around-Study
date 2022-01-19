package study.spring.AroundHubSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing	// JpaAuditing 관련 Bean들이 올라올 수 있게 세팅
public class AroundHubSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AroundHubSpringBootApplication.class, args);
	}

}
