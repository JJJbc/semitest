package gudiSpring.place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gudiSpring.place.dto.PensionDto;

public class PensionDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<PensionDto> selectList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";

			sql += "SELECT PLACE_NAME";
			sql += " FROM AREA A, PLACE P";
			sql += " WHERE A.AREA_NO = P.AREA_NO" + " AND P.CATEGORY = '펜션'" + " AND A.AREA_NO = 1";

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			String placeName = "";

			ArrayList<PensionDto> pensionList = new ArrayList<PensionDto>();

			PensionDto PensionDto = null;
			while (rs.next()) {
				placeName = rs.getString("PLACE_NAME");

				PensionDto = new PensionDto(placeName);

				pensionList.add(PensionDto);
			}
			return pensionList;
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