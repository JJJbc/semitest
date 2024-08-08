package gudiSpring.place.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import gudiSpring.place.dao.CafeDao;
import gudiSpring.place.dto.CafeDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/place/cafeList")
public class CafeListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 카페 리스트 받아와서 jsp에게 출력하라고 넘김
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			String areaNoParam = req.getParameter("areaNo");
			int areaNo = 1;

			if (areaNoParam != null && !areaNoParam.isEmpty()) {
				try {
					areaNo = Integer.parseInt(areaNoParam);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					areaNo = 1;
				}
			}
			CafeDao cafeDao = new CafeDao();
			cafeDao.setConnection(conn);

			ArrayList<CafeDto> cafeList = (ArrayList<CafeDto>) cafeDao.selectList(areaNo);			
		
			
			req.setAttribute("cafeList", cafeList);
//			System.out.println("areaNo: " + areaNo);
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/place/cafeList.jsp");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, res);
	}

}
