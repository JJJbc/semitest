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
	public List<CafeDto> selectCafeList(int areaNo, int startRow, int endRow) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT rnum, PLACE_NAME, PLACE_NO, PLACE_IMG_PATH FROM ( ";
        sql += "   SELECT ROWNUM AS rnum, P.PLACE_NAME, P.PLACE_NO, P.PLACE_IMG_PATH ";
        sql += "   FROM PLACE P, AREA A ";
        sql += "   WHERE P.AREA_NO = A.AREA_NO ";
        sql += "   AND P.CATEGORY = '카페' ";
        sql += "   AND A.AREA_NO = ? ";
        sql += "   ORDER BY P.PLACE_NO ";
        sql += ") ";
        sql += "WHERE rnum BETWEEN ? AND ?";

		ArrayList<CafeDto> cafeList = new ArrayList<>();

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
	// 카페 총 개수 조회
    public int getTotalCount(int areaNo) throws SQLException {
    	String sql = "";
    	
         sql += "SELECT COUNT(PLACE_NO)"; 
         sql += " FROM PLACE P, AREA A"; 
         sql += " WHERE P.AREA_NO = A.AREA_NO";
         sql += " AND P.CATEGORY = '카페' AND A.AREA_NO = ?";
         
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

	// 카페 정보
	public CafeDto selectCafeInfomation(int placeNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PLACE_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE, PLACE_IMG_PATH, GEN_RESERVATION, RECO_RESERVATION";
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
	
		

    // GEN_RESERVATION 값을 증가시키는 메서드
    public void incrementReservation(int placeNo) throws SQLException {
    	String sql = "";
    	
    	sql += "UPDATE PLACE SET GEN_RESERVATION = GEN_RESERVATION + 1 WHERE PLACE_NO = ?";
    	
    	try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, placeNo);
            pstmt.executeUpdate();
        }
    	
    }
}
