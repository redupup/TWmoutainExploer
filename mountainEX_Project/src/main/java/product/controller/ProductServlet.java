package product.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.ProductBean;
import product.service.ProductService;
import product.service.ProductServiceImpl;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession(false);
		
		ProductService service = new ProductServiceImpl();
		request.setAttribute("baBean", service);
		//
//		service.setPageNo(pageNo);
//		service.setRecordsPerPage(GlobalService.RECORDS_PER_PAGE);
		Collection<ProductBean> coll = service.getProducts();
//		request.setAttribute("pageNo", pageNo);
//		request.setAttribute("totalPages", service.getTotalPages());
		request.setAttribute("products_DPP", coll);
		// 交由listBooks.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
		// 『前一頁』、『下一頁』、『最末頁』等資料
		RequestDispatcher rd = request.getRequestDispatcher("ProductMaintainList.jsp");
		rd.forward(request, response);
		return;
	
	
	
	}

}
