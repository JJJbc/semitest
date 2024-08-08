package gudiSpring.place.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import gudiSpring.place.dao.PensionDao;
import gudiSpring.place.dto.PensionDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/place/pensionList")
public class PensionListController extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	
	// 펜션 리스트 받아와서 jsp에게 출력하라고 넘김
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection)sc.getAttribute("conn");
			
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
			
			PensionDao pensionDao = new PensionDao();
			pensionDao.setConnection(conn);
			
			ArrayList<PensionDto> pensionList = (ArrayList<PensionDto>) pensionDao.selectList(areaNo);
			req.setAttribute("pensionList", pensionList);
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/place/pensionList.jsp");
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
