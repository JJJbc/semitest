package gudiSpring.place.dao.pension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.cafe.CafeDto;
import gudiSpring.place.dto.pension.PensionDto;

public class PensionDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	// 펜션 리스트
	public List<PensionDto> selectPensionList(int areaNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PLACE_NAME, PLACE_NO";
		sql += " FROM PLACE P, AREA A";
		sql += " WHERE P.AREA_NO = A.AREA_NO";
		sql += " AND P.CATEGORY = '펜션'";
		sql += " AND A.AREA_NO = ?";

		ArrayList<PensionDto> pensionList = new ArrayList<PensionDto>();

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, areaNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String placeName = rs.getString("PLACE_NAME");
				int placeNo = rs.getInt("PLACE_NO");
				PensionDto pensionDto = new PensionDto(placeName, placeNo);

				pensionList.add(pensionDto);
			}
			return pensionList;
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
		return pensionList;
	}

	// 펜션 정보
	public PensionDto selectPensionInfomation(int placeNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PLACE_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE";
		sql += " FROM PLACE";
		sql += " WHERE CATEGORY = '펜션'";
		sql += " AND PLACE_NO = ?";

		PensionDto pensionDto = null;
		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, placeNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String placeName = rs.getString("PLACE_NAME");
				String plAddress = rs.getString("PL_ADDRESS");
				String plPhone = rs.getString("PL_PHONE");
				String plWebsite = rs.getString("PL_WEBSITE");

				pensionDto = new PensionDto(placeName, plAddress, plPhone, plWebsite);
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
		return pensionDto;
	}
}