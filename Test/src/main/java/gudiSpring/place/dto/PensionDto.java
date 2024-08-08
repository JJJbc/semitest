package gudiSpring.place.dto;

public class PensionDto {
	
	private String placeName;	

	public PensionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PensionDto(String placeName) {
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


