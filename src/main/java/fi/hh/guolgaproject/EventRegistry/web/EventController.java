package fi.hh.guolgaproject.EventRegistry.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.guolgaproject.EventRegistry.domain.EventRepository;
import fi.hh.guolgaproject.EventRegistry.domain.TypeRepository;
import fi.hh.guolgaproject.EventRegistry.domain.Event;


@Controller
public class EventController {
	@Autowired
	private EventRepository repository;
	
	@Autowired
	private TypeRepository drepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
      
}
	
	@RequestMapping(value="/eventlist")
    public String eventList(Model model) {	
        model.addAttribute("event", repository.findAll());
        return "eventlist";
    }
	
	@RequestMapping(value = "/add")
	    public String addEvent(Model model){
	    	model.addAttribute("event", new Event());
	    	model.addAttribute("type", drepository.findAll());
	        return "addevent";
	    }     
	    
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Event event){
	        repository.save(event);
	        return "redirect:eventlist";
	    }    

	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteEvent(@PathVariable("id") Long id, Model model) {
	    	repository.delete(id);
	        return "redirect:../eventlist";
	    } 
	    
	 @RequestMapping(value="/edit/{id}")
	    public String addEvent(@PathVariable("id") Long id, Model model){
	    	model.addAttribute("event", repository.findOne(id));
	    	model.addAttribute("type", drepository.findAll());

	        return "editevent"; 
	    }   
	 
	 @RequestMapping(value="/book/{id}")
	 	public String bookEvent(@PathVariable("id") Long id, Model model){
		 model.addAttribute("event", repository.findOne(id));
		 
		 return "bookevent";
	 }
	    
	// RESTful service to get all events
	 @RequestMapping(value="/events", method = RequestMethod.GET)
	 public @ResponseBody List<Event> eventListRest() {	
        return (List<Event>) repository.findAll();
    }    
    
	// RESTful service to get event by id
	 @RequestMapping(value="/events/{id}", method = RequestMethod.GET)
	 public @ResponseBody Event findEventRest(@PathVariable("id") Long eventId) {	
    	return repository.findOne(eventId);
    }       
        
      
	}	
	

