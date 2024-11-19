package api_gateway_service.model;

/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
*/
//@Entity
public class Rating {

	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double avgRating;
	
	private int count;
	
	
	public Rating() {
		
		
	}


	public Rating(Long id, String name, double avgRating, int count) {
		super();
		this.id = id;
		this.name = name;
		this.avgRating = avgRating;
		this.count = count;
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


	public double getAvgRating() {
		return avgRating;
	}


	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
