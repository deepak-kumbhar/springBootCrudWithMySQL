package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.dao.TeamDao;

@SpringBootApplication
public class MicroservicesBootApplication extends SpringBootServletInitializer{


	
	@Autowired
	TeamDao teamDao;
	/**
	 * Used when run as JAR.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootApplication.class, args);
	}
	
	
	/**
	 * Used when run as WAR.
	 * Need to extends SpringBootServletInitializer class.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroservicesBootApplication.class);
	}
	
	/**@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("Deepak Kumbhar", "Batsman"));
		players.add(new Player("Rohit Kumbhar", "Bowler"));
		Team team = new Team("India", "Benz", players);
		teamDao.save(team);
	}
	*/
	
}
