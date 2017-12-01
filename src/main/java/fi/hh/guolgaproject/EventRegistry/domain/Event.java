package fi.hh.guolgaproject.EventRegistry.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String date;
	private String time;
	private String location;
	private double price;
	private String details;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "typeid")
    private Type type;	
	
	public Event() {}
	
	public Event(String title, String date, String time, String location, double price, String details, Type type){
		super();
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.price = price;
		this.details = details;
		this.type = type;		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		if (this.type != null)
		return "Event [id=" + id + ", title=" + title + ", date=" + date + ", time=" + time + ", location=" + location
				+ ", price=" + price + ", details=" + details + ", type=" + this.getType() + "]";
		else 
			return  "Event [id=" + id + ", title=" + title + ", date=" + date + ", time=" + time + ", location=" + location
					+ ", price=" + price + ", details=" + details + "]";
	
	}
		
		
		
		
	}
	
	
	
