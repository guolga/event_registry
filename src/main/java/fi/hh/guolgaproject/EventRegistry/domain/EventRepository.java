package fi.hh.guolgaproject.EventRegistry.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fi.hh.guolgaproject.EventRegistry.domain.Event;

public interface EventRepository extends CrudRepository <Event, Long> {

	List<Event> findByTitle(String title);
}
