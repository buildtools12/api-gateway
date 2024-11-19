package api_gateway_service.model;

import java.util.ArrayList;
import java.util.List;
/*
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/

public class Movie {


	private Long id;
	
	private String name;
	
	private String director;
	
	
	private List<String> actors = new ArrayList<>();
	
	
	public Movie() {
		
		
	}


	public Movie(Long id, String name, String director, List<String> actors) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.actors = actors;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public List<String> getActors() {
		return actors;
	}


	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
	
	
	
}
