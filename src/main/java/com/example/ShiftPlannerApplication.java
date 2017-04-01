package com.example;

import com.example.entities.User;
import com.example.repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class ShiftPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiftPlannerApplication.class, args);
	}
}


@Component
class DummyCLR implements CommandLineRunner {

    private final UserRepositoryInterface userRepository;

    @Autowired
    public DummyCLR(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        userRepository.save( new User("BULME", "Kevin", "09060591901", "kevin.bulme@gmail.com", "kbulme", "mdpkbulme"));
        userRepository.save( new User("MAS", "Kevin", "08097503223", "maskevin74@gmail.com","kmas", "mdpkmas"));

        userRepository.findAll().forEach(System.out::println);
    }
}
