package gudiSpring.place.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import gudiSpring.place.dao.PlaceDao;
import gudiSpring.place.dao.cafe.CafeDao;
import gudiSpring.place.dto.PlaceDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/area/place/cafe")
public class RandomPlaceController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 카페 리스트 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		
		Random random = new Random(System.currentTimeMillis());
		
		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			int placeNo = 1;
			
			PlaceDao placeDao = new PlaceDao();
			placeDao.setConnection(conn);

			ArrayList<PlaceDto> randomPlaceList = (ArrayList<PlaceDto>) placeDao.getRandomPlace(placeNo);

			req.setAttribute("randomPlaceList", randomPlaceList);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
