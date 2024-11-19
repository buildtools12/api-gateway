package api_gateway_service.model;

public class MovieRating {

	
	private Movie movie;
	
	private Rating rating;
	
	
	public MovieRating() {
		
		
	}


	public MovieRating(Movie movie, Rating rating) {
		super();
		this.movie = movie;
		this.rating = rating;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	
	
	
}
