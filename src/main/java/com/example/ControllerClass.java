package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TeamDao;
import com.example.team.Team;

@RestController 
public class ControllerClass {

	/**
	 * @Autowired private Environment environment;
	 *            System.out.println(environment.getProperty(DemoConstants.HELLO_WORLD));
	 *            System.out.println(environment.getProperty("hello.world"));
	 */

	/**
	 * Normal spring boot.
	 * 
	 * @RequestMapping("/hi/{name}") public @ResponseBody String helloWorld() {
	 * return "Hello world!"; }
	 */

	/**
	 * Spring boot with Thymeleaf templating.
	 * 
	 * @RequestMapping("/hi/{name}") public String helloWorld(Map<String, String>
	 * model, @PathVariable String name) { model.put("name", name); return "hello";
	 * //HTML page name. }
	 * 
	 */

	/**
	 * Spring boot with JSP. @RequestMapping("/hi/{name}") public String
	 * helloWorld(Map<String, String> model, @PathVariable String name) {
	 * model.put("name", name); return "hello"; // HTML page name. }
	 */
	@Autowired
	TeamDao teamDao;
	
	
	@RequestMapping("/company/name/{name}")
	public @ResponseBody Team getTeamsByName(@PathVariable String name) {
		return teamDao.findByName(name);
	}
	
	@RequestMapping("/company")
	public @ResponseBody List<Team> getTeams() {
		return teamDao.findAll();
	}
	
	@RequestMapping("/company/{id}")
	public @ResponseBody Optional<Team> getTeamsById(@PathVariable Long id) {
		return teamDao.findById(id);
	}
	
	
	@PostMapping("/company/save")
	public @ResponseBody Team postTeamDetails(@RequestBody Team teams) {
		return teamDao.save(teams);
	}
}
