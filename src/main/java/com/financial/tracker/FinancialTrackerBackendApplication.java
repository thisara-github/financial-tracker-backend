package com.financial.tracker;

import com.financial.tracker.entity.User;
import com.financial.tracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FinancialTrackerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialTrackerBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return args -> {
			if(!userRepository.existsByUsername("testUser")) {
				User user = new User();
				user.setUsername("testUser");
				user.setPassword("Password@123");
				user.setRole("testRole");
				user.setActive(true);
				userRepository.save(user);
				System.out.println("User Created!");
			}
		};
	}

}
