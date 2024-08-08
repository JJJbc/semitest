package gudiSpring.place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.CafeDto;

public class CafeDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<CafeDto> selectList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";

			sql += "SELECT PLACE_NAME";
			sql += " FROM AREA A, PLACE P";
			sql += " WHERE A.AREA_NO = P.AREA_NO"
				+  " AND P.CATEGORY = '카페'"
				+  " AND A.AREA_NO = ?";

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			String placeName = "";

			ArrayList<CafeDto> cafeList = new ArrayList<CafeDto>();

			CafeDto CafeDto = null;
			while (rs.next()) {
				placeName = rs.getString("PLACE_NAME");

				CafeDto = new CafeDto(placeName);

				cafeList.add(CafeDto);
			}
			return cafeList;
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
