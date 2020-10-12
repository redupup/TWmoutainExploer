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

import product.model.ProductBean;
import product.service.ProductService;
import product.service.ProductServiceImpl;

@WebServlet("/shopping/ProductServlet")
public class ProductServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    public ProductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ProductService service = new ProductServiceImpl();
//		request.setAttribute("baBean", service);
		List<ProductBean> coll = service.getProducts();
		System.out.println(coll);
		request.setAttribute("products_DPP", coll);
		
		RequestDispatcher rd = request.getRequestDispatcher("ProductMaintainList2.jsp");
		rd.forward(request, response);
		
		return;
	
	
	
	}

}
