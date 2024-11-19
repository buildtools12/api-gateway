package api_gateway_service.model;



public class RatingRequest {

	private String name;
	
	private double stars;
	
	public RatingRequest() {
		
		
	}

	public RatingRequest(String name, double stars) {
		super();
		this.name = name;
		this.stars = stars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}
	
	
	
}
