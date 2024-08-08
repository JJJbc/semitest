package gudiSpring.place.dto;

public class CafeDto {
	
	private String placeName;	

	public CafeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CafeDto(String placeName) {
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
