package com.codeandpepper.task;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.models.Episode;
import com.codeandpepper.task.repositories.CharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CharacterRepository repository) {
		return (args) -> {
			for (Character character : repository.findAll()) {
				System.out.println(character.toString());
			}
		};
	}
}
