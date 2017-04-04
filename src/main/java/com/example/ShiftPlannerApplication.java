package com.example;

import com.example.entities.Task;
import com.example.entities.Slot;
import com.example.entities.Team;
import com.example.entities.Property;
import com.example.entities.User;
import com.example.repositories.TaskRepositoryInterface;
import com.example.repositories.SlotRepositoryInterface;
import com.example.repositories.TeamRepositoryInterface;
import com.example.repositories.PropertyRepositoryInterface;
import com.example.repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Date;


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
    private final TaskRepositoryInterface taskRepository;
    private final SlotRepositoryInterface slotRepository;

    @Autowired
    public DummyCLR(UserRepositoryInterface userRepository, PropertyRepositoryInterface propertyRepository, TeamRepositoryInterface teamRepository, TaskRepositoryInterface taskRepository, SlotRepositoryInterface slotRepository) {
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
        this.teamRepository = teamRepository;
        this.taskRepository = taskRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        User user1 = new User("BULME", "Kevin", "09060591901", "kevin.bulme@gmail.com", "kbulme", "mdpkbulme");
        User user2 = new User("MAS", "Kevin", "08097503223", "maskevin74@gmail.com","kmas", "mdpkmas");
        userRepository.save(user1);
        userRepository.save(user2);




        Property property1 = new Property("Permis de conduire", "Possession du permis de conduire");
        Property property2 = new Property("Force physique", "Porter des trucs lourds");
        Property property3 = new Property("Anglais", "Parle mieux anglais que Keke");
        propertyRepository.save(property1);
        propertyRepository.save(property2);
        propertyRepository.save(property3);

        //ManyToMany test
        propertyRepository.flush();
        userRepository.flush();

        user1.getProperties().add(property3);
        user2.getProperties().add(property2);
        userRepository.saveAndFlush(user1);
        userRepository.saveAndFlush(user2);


        teamRepository.save( new Team("patissier"));
        teamRepository.save( new Team("cuisinier"));
        teamRepository.save( new Team("serveur"));
        teamRepository.save( new Team("caissier"));




        slotRepository.save( new Slot( new Date() , new Date()));
        slotRepository.save( new Slot(new Date() , new Date()));



        taskRepository.save( new Task("Service en salle", "servir les clients"));
        taskRepository.save( new Task("préparer les plats", "préparer en cuisine les plats"));




        propertyRepository.findAll().forEach(System.out::println);
        userRepository.findAll().forEach(System.out::println);
        taskRepository.findAll().forEach(System.out::println);
        teamRepository.findAll().forEach(System.out::println);
        slotRepository.findAll().forEach(System.out::println);


    }
}
