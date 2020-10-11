package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _03_listBooks.service.BookService;
import _03_listBooks.service.impl.BookServiceImpl;
import product.service.ProductService;
import product.service.ProductServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
//		int bookId = Integer.parseInt(bId);
		ProductService service = new ProductServiceImpl();
		int n = service.deleteProduct(name);
		if (n == 1) {
			session.setAttribute("DeleteMsg", "刪除成功");
		} else {
			session.setAttribute("DeleteMsg", "刪除失敗");
		}
		response.sendRedirect("DisplayPageProducts");
		return;
	
	}

}
