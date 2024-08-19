package gudiSpring.place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.PlaceDto;

public class PlaceDao  {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<PlaceDto> getRandomPlace(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceDto> randomPlaceList = new ArrayList<>();
		
		try {
			String sql = "";
			sql += "SELECT PLACE_NO, CATEGORY, PLACE_IMG_PATH";
			sql += " FROM( ";
			sql += " 	SELECT PLACE_NO, CATEGORY, PLACE_IMG_PATH";
			sql += " 	FROM PLACE ";		
			sql += " 	ORDER BY DBMS_RANDOM.RANDOM ";
			sql += ")";
			sql += " WHERE ROWNUM <= 5";
			
			pstmt = connection.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			PlaceDto placeDto = null;
			
			while (rs.next()) {
				placeDto = new PlaceDto(
				rs.getInt("PLACE_NO"),
				rs.getString("CATEGORY"),
				rs.getString("PLACE_IMG_PATH")
				);
				randomPlaceList.add(placeDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally 종료

		return null;
	}
		
}	


