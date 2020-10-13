package product.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import product.dao.impl.ProductDao_Jdbc;
import product.model.ClassBean;
import product.model.ProductBean;
import product.service.ProductService;
import product.service.ProductServiceImpl;
/**
 * Servlet implementation class MaintainServlet
 */
@WebServlet("/shopping/MaintainServlet")
public class MaintainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ProductDao_Jdbc productDao_Jdbc = new ProductDao_Jdbc();

		String name= request.getParameter("name");
		String tableName = request.getParameter("firstClassname");
		
		
//		ProductBean aBean=new ProductBean();
//		aBean.setName(request.getParameter("name"));
//		aBean.setType(request.getParameter("type"));
//		Double doublePrice = 0.0;
//		doublePrice= Double.parseDouble(request.getParameter("price"));
//		aBean.setPrice(doublePrice);
//		Blob imgUrlBlob = null;
//		try {
//			imgUrlBlob = new SerialBlob(request.getParameter("imgUrl").getBytes("GBK"));
//		} catch (SerialException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		aBean.setImgUrl(imgUrlBlob);
//		Blob descriptionBlob = null;
//		try {
//			descriptionBlob = new SerialBlob(request.getParameter("description").getBytes("GBK"));
//		} catch (SerialException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		aBean.setDescription(descriptionBlob);
//		aBean.setSecondClass(request.getParameter("secondClass"));
//		int intStock = Integer.valueOf(request.getParameter("stock"));
//		aBean.setStock(intStock);
		
		
		
		ProductBean bean = null;
		List<ProductBean> products = (List<ProductBean>) session.getAttribute("products_DPP");
		for (ProductBean product : products) {
			String listName = product.getName();
			if (listName.equals(name)) {
				bean = product;
			}
		}
//		if(bean == null) {
//			response.sendRedirect("ProductServlet");
//		}
		
		
		//刪除
		if (request.getParameter("DELETE") != null) {
		String name2 = bean.getName();
		String firstClassname = bean.getFirstClassname();
		String sql = "delete from " + firstClassname + " where name='"+ name2 +"'";
		
				
		
		int torf = productDao_Jdbc.deleteProduct(sql);
	       if (torf == 1) {
	    	   System.out.println("刪除成功");
			} else {
				System.out.println("刪除失敗");
				
			}
//	       response.sendRedirect("shoppingIndex.jsp");
	       
	       } 
		//新增
		if (request.getParameter("INSERT") != null) {
//		String sql2 = "INSERT INTO " + tableName
//					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";

			ProductBean aBean=new ProductBean();
			aBean.setName(request.getParameter("name"));
			aBean.setType(request.getParameter("type"));
			Double doublePrice = 0.0;
			doublePrice= Double.parseDouble(request.getParameter("price"));
			aBean.setPrice(doublePrice);
			Blob imgUrlBlob = null;
			try {
				imgUrlBlob = new SerialBlob(request.getParameter("imgUrl").getBytes("GBK"));
			} catch (SerialException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			aBean.setImgUrl(imgUrlBlob);
			Blob descriptionBlob = null;
			try {
				descriptionBlob = new SerialBlob(request.getParameter("description").getBytes("GBK"));
			} catch (SerialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aBean.setDescription(descriptionBlob);
			aBean.setSecondClass(request.getParameter("secondClass"));
			int intStock = Integer.valueOf(request.getParameter("stock"));
			aBean.setStock(intStock);
			
			
			
			
	     int torf = productDao_Jdbc.saveProduct( aBean , tableName);
	     	if (torf == 1) {
	    	   System.out.println("新增成功");
			} else {
				System.out.println("新增失敗");
			}
	      } 
		
		//修改
	    if (request.getParameter("UPDATE") != null) {
	    		    	
	    	ProductBean aBean=new ProductBean();
//			aBean.setName(request.getParameter("name"));
			aBean.setType(request.getParameter("type"));
			Double doublePrice= Double.parseDouble(request.getParameter("price"));
			aBean.setPrice(doublePrice);
			Blob imgUrlBlob = null;
			try {
				imgUrlBlob = new SerialBlob(request.getParameter("imgUrl").getBytes("GBK"));
			} catch (SerialException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			aBean.setImgUrl(imgUrlBlob);
			Blob descriptionBlob = null;
			try {
				descriptionBlob = new SerialBlob(request.getParameter("description").getBytes("GBK"));
			} catch (SerialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aBean.setDescription(descriptionBlob);
			aBean.setSecondClass(request.getParameter("secondClass"));
			int intStock = Integer.valueOf(request.getParameter("stock"));
			aBean.setStock(intStock);		
	    			
	    	
	        int torf =productDao_Jdbc.updateProduct(aBean , name);
	        if (torf == 1) {
		    	   System.out.println("修改成功");
				} else {
					System.out.println("修改失敗");
				}
	      } 
		
	}
}
	