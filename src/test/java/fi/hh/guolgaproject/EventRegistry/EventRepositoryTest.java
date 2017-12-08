package fi.hh.guolgaproject.EventRegistry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.guolgaproject.EventRegistry.domain.EventRepository;
import fi.hh.guolgaproject.EventRegistry.domain.Event;
import fi.hh.guolgaproject.EventRegistry.domain.Type;

//Testing the JPA repository

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {

	@Autowired
	private EventRepository repository;

	@Test
	public void findByTitleShouldReturnEvent() {
		List<Event> events = repository.findByTitle("Remember me");

		assertThat(events).hasSize(1);
		assertThat(events.get(0).getLocation()).isEqualTo("City Hall");
	}

	@Test
	public void createNewEvent() {
		Event event = new Event("Test Event 4", "29.01.2018", "20:30", "Opera", 25.99,
				"Performance by National opera singers", new Type("Music"));
		repository.save(event);
		assertThat(event.getId()).isNotNull();
	}

	@Test
	public void deleteEvent() {
		List<Event> events = repository.findByTitle("X Factor Suomi");

		assertThat(events).hasSize(1);
		repository.delete(events.get(0));

		List<Event> deletedevent = repository.findByTitle("X Factor Suomi");

		assertThat(deletedevent).hasSize(0);

	}
}
