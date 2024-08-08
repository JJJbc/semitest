package gudiSpring.place.dto;

public class RestaurantDto {
	
	private String placeName;	

	public RestaurantDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantDto(String placeName) {
		super();
		this.placeName = placeName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "CafeDto [placeName=" + placeName + "]";
	}
	
	
	
	

}
