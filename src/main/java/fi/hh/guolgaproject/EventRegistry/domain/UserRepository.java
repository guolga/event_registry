package fi.hh.guolgaproject.EventRegistry.domain;



import org.springframework.data.repository.CrudRepository;

//UserRepository inherits methods for saving, deleting and finding User entities
public interface UserRepository  extends CrudRepository<User, Long> {
	
	//find by username
	User findByUsername(String username);
	
}
