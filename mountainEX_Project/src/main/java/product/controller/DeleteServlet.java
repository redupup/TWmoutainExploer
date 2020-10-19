package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.dao.impl.ProductDao_Jdbc;
import product.model.ProductBean;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/shopping/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ProductDao_Jdbc productDao_Jdbc = new ProductDao_Jdbc();
		String name = request.getParameter("name");

		ProductBean bean = null;
		List<ProductBean> products = (List<ProductBean>) session.getAttribute("products_DPP");
		for (ProductBean product : products) {
			String listName = product.getName();
			if (listName.equals(name)) {
				bean = product;
				
			}
			System.out.println(bean);
		}

		String name2 = bean.getName();
		String firstClassname = bean.getFirstClassname();

		String sql = "delete from " + firstClassname + " where name='" + name2 + "'";

		int torf = productDao_Jdbc.deleteProduct(sql);
		if (torf == 1) {
			System.out.println("刪除成功");
			RequestDispatcher rd = request.getRequestDispatcher("shoppingIndex.jsp");
			rd.forward(request, response);

		} else {
			System.out.println("刪除失敗");

		}
       response.sendRedirect("shoppingIndex.jsp");

	}

}
