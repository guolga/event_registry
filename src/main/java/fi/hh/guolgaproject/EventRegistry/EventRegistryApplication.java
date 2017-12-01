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
			
			drepository.save(new Type("Music"));
			drepository.save(new Type("Dance"));
			drepository.save(new Type("Theatre"));
			drepository.save(new Type("Exhibition"));
			drepository.save(new Type("Sport"));
			drepository.save(new Type("Concert"));
			drepository.save(new Type("Other"));
			
			repository.save(new Event("Test Event 1", "05.02.2018", "19:00", "National Opera Hall", 75.99, "Performance by Olga", drepository.findByType("Music").get(0)));
			repository.save(new Event("Test Event 2", "07.03.2018", "18:00", "Somewhere", 11.50, "Performance by Dignity", drepository.findByType("Theatre").get(0)));
			repository.save(new Event("Test Event 3", "25.01.2018", "20:30", "Haaga-Helia", 25.99, "Performance by Anastasia", drepository.findByType("Dance").get(0)));
			
			
			User user1 = new User("admin", "Admin",  "Adminovich", "$2a$06$agdWTMxFom/Fj0o5sRAbOu5w57OjSRRNT9KnG.D.jnDG4yhs3A8PO", "admin@events.fi", "ADMIN");
			User user2 = new User("user", "Olga", "Guscina", "$2a$10$9cwBr0ww4FbBJW9ac7aiHO80GRstjGCKCb36gqa0KJrQpVHLsmze.", "user@gmail.com", "USER");

			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all events");
			for (Event event: repository.findAll()){
				log.info(event.toString());
			}
		};
	}
	
}
