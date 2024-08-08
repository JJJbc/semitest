package gudiSpring.place.dto;

public class CafeDto {
	
	private String placeName;
	
	public CafeDto() {}

    
    public CafeDto(String placeName) {
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
