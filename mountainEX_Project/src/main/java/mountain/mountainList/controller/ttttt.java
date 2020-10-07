package mountain.mountainList.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mountain.mountainList.dao.MountainDAO;
import mountain.mountainList.model.MountainBean;

/**
 * Servlet implementation class ttttt
 */
@WebServlet("/ttttt")
public class ttttt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ttttt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MountainDAO mountainDAO = new MountainDAO();
		List<MountainBean> routeSummary = null;
		try {
			routeSummary = mountainDAO.routeSummary();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("tttBean", routeSummary);
		
		response.sendRedirect(request.getContextPath()+"/house/hList/house.jsp");
		return;
	}

}
