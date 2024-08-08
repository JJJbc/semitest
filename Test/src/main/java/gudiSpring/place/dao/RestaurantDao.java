package gudiSpring.place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.RestaurantDto;

public class RestaurantDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<RestaurantDto> selectList(int areaNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";

			sql += "SELECT PLACE_NAME";
			sql += " FROM AREA A, PLACE P";
			sql += " WHERE A.AREA_NO = P.AREA_NO"
				+  " AND P.CATEGORY = '식당'"
				+  " AND A.AREA_NO = ?";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, areaNo);

			rs = pstmt.executeQuery();
			

			ArrayList<RestaurantDto> restaurantList = new ArrayList<RestaurantDto>();

			RestaurantDto RestaurantDto = null;
			while (rs.next()) {
				String placeName = rs.getString("PLACE_NAME");

				RestaurantDto = new RestaurantDto(placeName);

				restaurantList.add(RestaurantDto);
			}
			return restaurantList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
