package mountain.mountainList.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mountain.mountainList.model.MountainBean;


@WebServlet("/mountain/SheipaServlet")
public class SheipaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SheipaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<MountainBean> mBeanList = (List<MountainBean>)session.getAttribute("origin_mBLiest");
		List<MountainBean> newList = new ArrayList<MountainBean>();
		for (MountainBean mountainBean : mBeanList) {
			if(mountainBean.getNpName().equals("雪霸國家公園")) {
				newList.add(mountainBean);
			}
		}
//		session.removeAttribute("mountainBean");
		
		session.setAttribute("mountainBean", newList);
		response.sendRedirect("mountainIndex.jsp");
		return;
		
	}

}
