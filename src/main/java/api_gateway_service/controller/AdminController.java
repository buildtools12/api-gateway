package api_gateway_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import api_gateway_service.model.Movie;
import api_gateway_service.model.MovieRating;
import api_gateway_service.model.Rating;



@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	
	//private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	//@Value("${movie-service.url}")
	private String movieServiceUrl = "http://localhost:8381/movies";
	
	
	//@Value("${ratings-service.url}")
	private String ratingsServiceUrl= "http://localhost:8382/ratings";
	
	
	@PostMapping
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
		
		try {
			
			LOGGER.info("Adding movie");
		Movie saveMovie = restTemplate.postForObject(movieServiceUrl, movie, Movie.class);
		
		return ResponseEntity.ok().body(saveMovie);
		
		} catch(HttpStatusCodeException ex) {
			
			LOGGER.error("Error adding movie: {}", ex.getMessage());
			
            return  ResponseEntity.status(ex.getStatusCode())
					  .contentType(MediaType.APPLICATION_JSON)
					  .body(ex.getResponseBodyAsString());
			
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMovie(@PathVariable Long id   ,@RequestBody Movie movie) {
		
		try {
			
			LOGGER.info("Updating movie: {}", id);
		 restTemplate.put(movieServiceUrl + "/"+id, movie);
		
		return ResponseEntity.ok().build();
		
		} catch(HttpStatusCodeException ex) {
			
			LOGGER.error("Error updating movie: {}", ex.getMessage());
			
            return  ResponseEntity.status(ex.getStatusCode())
					  .contentType(MediaType.APPLICATION_JSON)
					  .body(ex.getResponseBodyAsString());
			
		}
	}
	
	
	@GetMapping("/{id}")
	public  ResponseEntity<Object> fetchMovieAndRating(@PathVariable Long id) {
		
		Movie movie;
				
			try {
				
				movie = restTemplate.getForObject(movieServiceUrl+ "/"+id, Movie.class);
			}
			catch(HttpStatusCodeException ex) {
				
				LOGGER.error("Error fetching movie: {}", ex.getMessage());
				
	            return  ResponseEntity.status(ex.getStatusCode())
						  .contentType(MediaType.APPLICATION_JSON)
						  .body(ex.getResponseBodyAsString());
				
			}
			
		Rating rating;
				
		try {
				 	
				
		    rating = restTemplate.getForObject(ratingsServiceUrl+"/"+id, Rating.class);
		}
		 catch(HttpStatusCodeException ex) {
			 
			 if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				 
				 rating = new Rating(null, movie.getName(), 0.0,0);
				 
			 } else {
				 
				 rating = new Rating(null, movie.getName(), -1.0,-1);

			 }
		 }
				
				
        MovieRating movieRating = new MovieRating();
        movieRating.setMovie(movie);
        movieRating.setRating(rating);
        
        return ResponseEntity.ok(movieRating);
        
        
	}
	
}
