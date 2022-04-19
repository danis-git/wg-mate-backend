package at.jku.wgmatebackend;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class WgMateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WgMateBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	@Entity
	@Table(appliesTo = "name")
	public class UserEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String firstName;
		private String lastName;
		@Column(unique = true)
		private String email;
		private String password;

		public void setId(Long id) {
			this.id = id;
		}

		@Id
		public Long getId() {
			return id;
		}

		//getter setters
	}
}
