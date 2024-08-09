package gudiSpring.place.dto.pension;

public class PensionDto {
	
	private int placeNo;
	private String placeName;
	private String plAddress;
	private String plPhone;
	private String plWebsite;
	
	
	public PensionDto() {}

    
    public PensionDto(String placeName, int placeNo) {
        this.placeName = placeName;
        this.placeNo = placeNo;
    } 
    
    public PensionDto(String placeName, String plAddress, String plPhone, String plWebsite) {
		super();
		this.placeName = placeName;
		this.plAddress = plAddress;
		this.plPhone = plPhone;
		this.plWebsite = plWebsite;
		
	}

        
	public int getPlaceNo() {
		return placeNo;
	}

	
	public void setPlaceNo(int placeNo) {
		this.placeNo = placeNo;
	}


	public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    

    public String getplAddress() {
		return plAddress;
	}


	public void setplAddress(String plAddress) {
		this.plAddress = plAddress;
	}


	public String getPlPhone() {
		return plPhone;
	}


	public void setPlPhone(String plPhone) {
		this.plPhone = plPhone;
	}


	public String getPlWebsite() {
		return plWebsite;
	}


	public void setPlWebsite(String plWebsite) {
		this.plWebsite = plWebsite;
	}


	@Override
	public String toString() {
		return "PensionDto [placeName=" + placeName + ", plAddress=" + plAddress + ", plPhone=" + plPhone + ", plWebsite="
				+ plWebsite + ", placeNo=" + placeNo + "]";
	}

}
