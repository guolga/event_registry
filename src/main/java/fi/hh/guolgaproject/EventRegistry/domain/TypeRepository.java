package fi.hh.guolgaproject.EventRegistry.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//TypeRepository inherits methods for saving, deleting and finding Type entities
public interface TypeRepository extends CrudRepository<Type, Long>{

	//find by type
	List<Type> findByType(String type);
}
