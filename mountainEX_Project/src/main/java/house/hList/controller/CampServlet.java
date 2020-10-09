package house.hList.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import house.hList.dao.CampDAO_JDBC;
import house.hList.dao.MountainHouseDAO_JDBC;
import house.hList.model.CampBeen;
import house.hList.model.HouseBeen;

@WebServlet("/house/hList/CampServlet")
public class CampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("44");
		
		String a = request.getParameter("see");
//		String b = request.getParameter("sc");
//		String c = request.getParameter("st");
//		String d = request.getParameter("sn");
		CampDAO_JDBC DAO = new CampDAO_JDBC();
		try {
			ArrayList<CampBeen> campsee =(ArrayList<CampBeen>) DAO.listCamp(a);
//			ArrayList<CampBeen> campcity =(ArrayList<CampBeen>) DAO.slesctCity(b);
//			ArrayList<CampBeen> camptown =(ArrayList<CampBeen>) DAO.slesctTown(c);
//			ArrayList<CampBeen> campname =(ArrayList<CampBeen>) DAO.slesctName(d);
			
			
			request.setAttribute("camp_all", campsee);
//			request.setAttribute("camp_city", campcity);
//			request.setAttribute("camp_town", camptown);
//			request.setAttribute("camp_name", campname);
		request.getRequestDispatcher("camp.jsp").forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
