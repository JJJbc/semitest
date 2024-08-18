package gudiSpring.place.dao.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.cafe.CafeDto;
import gudiSpring.place.dto.restaurant.RestaurantDto;

public class RestaurantDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	// 식당 리스트
	public List<RestaurantDto> selectRestaurantList(int areaNo, int startRow, int endRow) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT rnum, PLACE_NAME, PLACE_NO, PLACE_IMG_PATH FROM ( ";
		sql += "   SELECT ROWNUM AS rnum, P.PLACE_NAME, P.PLACE_NO, P.PLACE_IMG_PATH ";
		sql += "   FROM PLACE P, AREA A ";
		sql += "   WHERE P.AREA_NO = A.AREA_NO ";
		sql += "   AND P.CATEGORY = '식당' ";
		sql += "   AND A.AREA_NO = ? ";
		sql += "   ORDER BY P.PLACE_NO ";
		sql += ") ";
		sql += "WHERE rnum BETWEEN ? AND ?";

		ArrayList<RestaurantDto> restaurantList = new ArrayList<RestaurantDto>();

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, areaNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			pstmt.setInt(1, areaNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String placeName = rs.getString("PLACE_NAME");
				int placeNo = rs.getInt("PLACE_NO");
				String plImgPath = rs.getString("PLACE_IMG_PATH");
				RestaurantDto restaurantDto = new RestaurantDto(placeName, placeNo, plImgPath);

				restaurantList.add(restaurantDto);
			}
			return restaurantList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return restaurantList;
	}

	// 식당 총 개수 조회
	public int getTotalCount(int areaNo) throws SQLException {
		String sql = "";

		sql += "SELECT COUNT(PLACE_NO)";
		sql += " FROM PLACE P, AREA A";
		sql += " WHERE P.AREA_NO = A.AREA_NO";
		sql += " AND P.CATEGORY = '식당' AND A.AREA_NO = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, areaNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
				return 0;
			}
		}
	}

	// 식당 정보
	public RestaurantDto selectRestaurantInfomation(int placeNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PLACE_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE, PLACE_IMG_PATH, GEN_RESERVATION, RECO_RESERVATION";
		sql += " FROM PLACE";
		sql += " WHERE CATEGORY = '식당'";
		sql += " AND PLACE_NO = ?";

		RestaurantDto restaurantDto = null;
		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, placeNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String placeName = rs.getString("PLACE_NAME");
				String plAddress = rs.getString("PL_ADDRESS");
				String plPhone = rs.getString("PL_PHONE");
				String plWebsite = rs.getString("PL_WEBSITE");
				String plImgPath = rs.getString("PLACE_IMG_PATH");
				int genReservation = rs.getInt("GEN_RESERVATION");

				restaurantDto = new RestaurantDto(placeName, plAddress, plPhone, plWebsite, plImgPath, genReservation);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return restaurantDto;
	}

	// GEN_RESERVATION 값을 증가시키는 메서드
	public void incrementReservation(int placeNo) throws SQLException {
		String sql = "";

		sql += "UPDATE PLACE SET GEN_RESERVATION = GEN_RESERVATION + 1 WHERE PLACE_NO = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, placeNo);
			pstmt.executeUpdate();

		}

	}

	// 랜덤 카페 추천
	public RestaurantDto getRandomRestaurant() throws SQLException {

		String sql = "";

		sql += "SELECT PLACE_NO, PLACE_NAME, CATEGORY, PL_ADDRESS, PL_PHONE, PL_WEBSITE, PLACE_IMG_PATH, RECO_RESERVATION";
		sql += " FROM( ";
		sql += " 	SELECT PLACE_NO, PLACE_NAME, CATEGORY, PL_ADDRESS, PL_PHONE, PL_WEBSITE, PLACE_IMG_PATH, RECO_RESERVATION";
		sql += " 	FROM PLACE ";
		sql += " 	ORDER BY DBMS_RANDOM.RANDOM ";
		sql += ")";
		sql += " WHERE ROWNUM = 1";
		sql += " AND CATEGORY = '식당'";

		try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				int placeNo = rs.getInt("PLACE_NO");
				String placeName = rs.getString("PLACE_NAME");
				String category = rs.getString("CATEGORY");
				String plAddress = rs.getString("PL_ADDRESS");
				String plPhone = rs.getString("PL_PHONE");
				String plWebsite = rs.getString("PL_WEBSITE");
				String plImgPath = rs.getString("PLACE_IMG_PATH");
				int recoReservation = rs.getInt("RECO_RESERVATION");

				return new RestaurantDto(placeNo, placeName, category, plAddress, plPhone, plWebsite, plImgPath,
						recoReservation);
			}
			return null; // No cafe found
		}

	}

	// RECO_RESERVATION 값을 증가시키는 메서드
	public void incrementRecoReservation(int placeNo) throws SQLException {
		String sql = "UPDATE PLACE SET RECO_RESERVATION = RECO_RESERVATION + 1 WHERE PLACE_NO = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, placeNo);
			pstmt.executeUpdate();
		}
	}
}
