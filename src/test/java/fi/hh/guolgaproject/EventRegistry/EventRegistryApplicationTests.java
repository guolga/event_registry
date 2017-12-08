package fi.hh.guolgaproject.EventRegistry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.guolgaproject.EventRegistry.web.EventController;

//Testing that the context is creating controller

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventRegistryApplicationTests {

	@Autowired
	private EventController controller;
	
	@Test
	public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	

}
