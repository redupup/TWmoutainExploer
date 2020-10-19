package product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.dao.impl.ProductDao_Jdbc;
import product.model.ClassBean;
import product.model.ProductBean;

@WebServlet("/shopping/ProductServlet")
public class ProductServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		ProductDao_Jdbc productDao_Jdbc = new ProductDao_Jdbc();
		List<ClassBean> classList = productDao_Jdbc.getClassList();
		session.setAttribute("ClassName", classList);
		List<ProductBean> products = productDao_Jdbc.getProducts();
//		System.out.println(products);
		session.setAttribute("products_DPP", products);
		
		RequestDispatcher rd = request.getRequestDispatcher("shoppingIndex.jsp");
		rd.forward(request, response);
		
		return;
	
	}

}
