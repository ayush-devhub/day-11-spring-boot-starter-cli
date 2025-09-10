package dev.ayush.springBootStarterCli;

import dev.ayush.springBootStarterCli.controller.UserController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootStarterCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterCliApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserController controller){
		return args -> controller.runCli();
	}
}
