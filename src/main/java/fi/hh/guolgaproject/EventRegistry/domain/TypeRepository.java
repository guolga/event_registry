package fi.hh.guolgaproject.EventRegistry.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long>{

	List<Type> findByType(String type);
}
