package api_gateway_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import api_gateway_service.model.Rating;
import api_gateway_service.model.RatingRequest;

@RestController
@RequestMapping("/api/public")
public class PublicController {

	//private final RestTemplate restTemplate = new RestTemplate();
	
	
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(PublicController.class);

	//@Value("${ratings-service.url}")
	private String ratingsServiceUrl = "http://localhost:8382/ratings";
	

	@PostMapping
	public ResponseEntity<Object> addRating(@RequestBody RatingRequest request) {
		
		Rating rating;
		
		try {
			
			rating = restTemplate.postForObject(ratingsServiceUrl,request, Rating.class);
			
			return ResponseEntity.ok(rating);
			
		}
		
		 catch(HttpStatusCodeException ex) {
				
				LOGGER.error("Error adding movie: {}", ex.getMessage());
				
	            return  ResponseEntity.status(ex.getStatusCode())
						  .contentType(MediaType.APPLICATION_JSON)
						  .body(ex.getResponseBodyAsString());
				
			}
	}
	
	
}
