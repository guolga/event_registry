package fi.hh.guolgaproject.EventRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import fi.hh.guolgaproject.EventRegistry.domain.Event;
import fi.hh.guolgaproject.EventRegistry.domain.EventRepository;
import fi.hh.guolgaproject.EventRegistry.domain.Type;
import fi.hh.guolgaproject.EventRegistry.domain.TypeRepository;
import fi.hh.guolgaproject.EventRegistry.domain.User;
import fi.hh.guolgaproject.EventRegistry.domain.UserRepository;

@SpringBootApplication
public class EventRegistryApplication {

	private static final Logger log = LoggerFactory.getLogger(EventRegistryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EventRegistryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner eventDemo(EventRepository repository, TypeRepository drepository, UserRepository urepository){
		return (args) -> {
			log.info("save new events");
			
			//create event types and save them to TypeRepository
			drepository.save(new Type("Music"));
			drepository.save(new Type("Dance"));
			drepository.save(new Type("Theatre"));
			drepository.save(new Type("Exhibition"));
			drepository.save(new Type("Seminar"));
			drepository.save(new Type("Concert"));
			drepository.save(new Type("Other"));
			
			//create events and save them to EventRepository
			repository.save(new Event("Female Choir Philomela", "05.02.2018", "18:00", "Suomenlinna Church",10.00, "Orthodox Metropolitanate choir", drepository.findByType("Concert").get(0)));
			repository.save(new Event("Carpe Diem", "07.03.2018", "20:00", "The Finnish National Theatre", 55.90, "Dignity show troup", drepository.findByType("Theatre").get(0)));
			repository.save(new Event("Tango!", "29.04.2018", "17:30", "Helsinki Latin Club", 12.99, "Carla Buono, Andra Anza, Emilia Pucci", drepository.findByType("Dance").get(0)));
			repository.save(new Event("Into the woods", "19.05.2018", "15:00", "Ateneum", 15.99, "Toshio Sone", drepository.findByType("Exhibition").get(0)));
			repository.save(new Event("The rising Star", "21.05.2018", "12:00", "Elisa Hall", 25.00, "Kindergarter pupils", drepository.findByType("Music").get(0)));
			repository.save(new Event("Acheving Maximum", "02.06.2018", "11:00", "Sokos Hotel Presidentti", 129.99, "Brian Tracey", drepository.findByType("Seminar").get(0)));
			repository.save(new Event("Remember me", "07.05.2018", "19:00", "City Hall", 25.00, "Linda Leen, Antony Gracham", drepository.findByType("Music").get(0)));
			repository.save(new Event("X Factor Suomi", "06.06.2018", "19:00", "Finlandia Hall", 49.99, "Final contestants", drepository.findByType("Concert").get(0)));
			repository.save(new Event("My life, my achievements", "10.06.2018", "10:00", "Clarion Helsinki", 99.99, "Richard Gore", drepository.findByType("Seminar").get(0)));

			//create users
			User user1 = new User("admin", "Anna",  "Laima", "$2a$06$agdWTMxFom/Fj0o5sRAbOu5w57OjSRRNT9KnG.D.jnDG4yhs3A8PO", "admin@events.fi", "ADMIN");
			User user2 = new User("user", "Linda", "Rast", "$2a$10$9cwBr0ww4FbBJW9ac7aiHO80GRstjGCKCb36gqa0KJrQpVHLsmze.", "linda@gmail.com", "USER");
			User user3 = new User("guolga", "Olga", "Guscina", "$2a$04$kgCA2PeL2vf1L5sFhqnqHO4xemV/vPVYlED1oSZtAEfnhcZkP9XCW", "olga@gmail.com", "USER");
			User user4 = new User("haukka", "Linda", "Rast", "$2a$10$.QN/uGAJaKiSFDDWTvECs.By4eNLC6CYGafCjz1haRVOYAvyCQQMG", "haukka@gmail.com", "USER");
			User user5 = new User("marla", "Marla", "Lest", "$2a$04$70vnJ5QBQT92Dk9GV2UkV.LcfQE0I61OM/2sPhg/OA55rVKrOZuvC", "marla@gmail.com", "USER");

			//save users to UserRepository
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			urepository.save(user5);
			
			//showing all events
			log.info("fetch all events");
			for (Event event: repository.findAll()){
				log.info(event.toString());
			}
			
			//showing all users
			log.info("fetch all users");
			for (User user: urepository.findAll()){
				log.info(user.toString());
			}
			
		};
	}
	
}
