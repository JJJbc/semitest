package gudiSpring.place.dao.cafe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.cafe.CafeDto;

public class CafeDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	// cafe list
	public List<CafeDto> selectCafeList(int areaNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PLACE_NAME, PLACE_NO, PLACE_IMG_PATH";
		sql += " FROM PLACE P, AREA A";
		sql += " WHERE P.AREA_NO = A.AREA_NO";
		sql += " AND P.CATEGORY = '카페'";
		sql += " AND A.AREA_NO = ?";

		ArrayList<CafeDto> cafeList = new ArrayList<>();

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, areaNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String placeName = rs.getString("PLACE_NAME");
				int placeNo = rs.getInt("PLACE_NO");
				String plImgPath = rs.getString("PLACE_IMG_PATH");
				CafeDto cafeDto = new CafeDto(placeName, placeNo, plImgPath);

				cafeList.add(cafeDto);
			}
			return cafeList;
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
		return cafeList;
	}

	// 카페 정보
	public CafeDto selectCafeInfomation(int placeNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PLACE_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE, PLACE_IMG_PATH";
		sql += " FROM PLACE";
		sql += " WHERE CATEGORY = '카페'";
		sql += " AND PLACE_NO = ?";

		CafeDto cafeDto = null;
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

				cafeDto = new CafeDto(placeName, plAddress, plPhone, plWebsite, plImgPath);
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
		return cafeDto;
	}
}
