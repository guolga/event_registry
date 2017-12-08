package fi.hh.guolgaproject.EventRegistry.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fi.hh.guolgaproject.EventRegistry.domain.Event;

//EventRepository inherits methods for saving, deleting and finding Event entities
public interface EventRepository extends CrudRepository <Event, Long> {

	//find by title
	List<Event> findByTitle(String title);

	
	}
