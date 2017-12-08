package fi.hh.guolgaproject.EventRegistry.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	
	//create id column of the table
	@Id
	//generate unique primary key for entity
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeid;
	private String type;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List <Event> event;
	
	//constructor
	public Type() {}
	
	public Type(String type) {
		super();
		this.type = type;
	}

	//getters and setters
	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	//toString method
	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", type=" + type + "]";
	}	
	
	
}
