package com.example;

import com.example.entities.Team;
import com.example.entities.Property;
import com.example.entities.User;
import com.example.repositories.TeamRepositoryInterface;
import com.example.repositories.PropertyRepositoryInterface;
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
    private final PropertyRepositoryInterface propertyRepository;
    private final TeamRepositoryInterface teamRepository;

    @Autowired
    public DummyCLR(UserRepositoryInterface userRepository, PropertyRepositoryInterface propertyRepository, TeamRepositoryInterface teamRepository) {
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        userRepository.save( new User("BULME", "Kevin", "09060591901", "kevin.bulme@gmail.com", "kbulme", "mdpkbulme"));
        userRepository.save( new User("MAS", "Kevin", "08097503223", "maskevin74@gmail.com","kmas", "mdpkmas"));

        userRepository.findAll().forEach(System.out::println);


        propertyRepository.save( new Property("Permis de conduire", "Possession du permis de conduire"));
        propertyRepository.save( new Property("Force physique", "Porter des trucs lourds"));
        propertyRepository.save( new Property("Anglais", "Parle mieux anglais que Keke"));

        propertyRepository.findAll().forEach(System.out::println);


        teamRepository.save( new Team("patissier"));
        teamRepository.save( new Team("cuisinier"));
        teamRepository.save( new Team("serveur"));
        teamRepository.save( new Team("caissier"));


        teamRepository.findAll().forEach(System.out::println);


    }
}
