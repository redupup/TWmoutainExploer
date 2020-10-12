package product.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import product.model.ProductBean;
import product.service.ProductService;
import product.service.ProductServiceImpl;
/**
 * Servlet implementation class MaintainServlet
 */
@WebServlet("/MaintainServlet")
public class MaintainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name= request.getParameter("name");
		ProductBean bean = new ProductBean();
		String type= request.getParameter("type");
		String price= request.getParameter("price");
		String imgUrl= request.getParameter("imgUrl");
		String description= request.getParameter("description");
		String secondClass= request.getParameter("secondClass");
		String stock= request.getParameter("stock");
		String firstClassname= request.getParameter("firstClassname");
		
//		ProductService service = new ProductServiceImpl();
		if (request.getParameter("DELETE") != null) {
	       deleteProduct(name);
	      } 
		if (request.getParameter("INSERT") != null) {
	        saveProduct(bean);
	      } 
	    if (request.getParameter("UPDATE") != null) {
	        updateProduct(bean);
	      } 
		
	}
	// 依name來刪除單筆記錄
			public int deleteProduct(String name) {
				int n = 0;
				String sql = "DELETE FROM"+" backpack"+" WHERE name = ?";
				dataS.setUsername("hr");
				dataS.setUserPassword("hr");
				DataSource datasoure = dataS.getDatasoure();
				try (
					Connection connection = datasoure.getConnection(); 
					PreparedStatement pStmt = connection.prepareStatement(sql);
				) {
					pStmt.setString(1, name);
					n = pStmt.executeUpdate();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				return n;
			}
		
			// 新增一筆記錄---
			public int saveProduct(ProductBean bean) {
				int n = 0;

				String sql = "INSERT INTO "+" backpack" 
						+ " (name,type,price,img_url,description,second_class,stock,first_class_name) "
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
				dataS.setUsername("hr");
				dataS.setUserPassword("hr");
				DataSource datasoure = dataS.getDatasoure();
				try (
					Connection connection = datasoure.getConnection();
					PreparedStatement pStmt = connection.prepareStatement(sql);
				) {
					pStmt.setString(1, bean.getName());
					pStmt.setString(2, bean.getType());
					pStmt.setDouble(3, bean.getPrice());
					pStmt.setBlob(4, bean.getImgUrl());
					pStmt.setBlob(5, bean.getDescription());
					pStmt.setString(6, bean.getSecondClass());
					pStmt.setInt(7, bean.getStock());
					pStmt.setString(8, bean.getFirstClassname());

					n = pStmt.executeUpdate();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				return n;
			}
			
			// 修改一筆資料
			public int updateProduct(ProductBean bean) {
				int n = 0;
				String sql = "UPDATE"+ "backpack"+  "SET " 
						+ " type=?,  price=?, second_class=?,  stock=? "
						+ " WHERE name = ?";
				dataS.setUsername("hr");
				dataS.setUserPassword("hr");
				DataSource datasoure = dataS.getDatasoure();
				try (
						Connection connection = datasoure.getConnection();
						PreparedStatement ps = connection.prepareStatement(sql);
				) {
					ps.clearParameters();
					ps.setString(1, bean.getType());
					ps.setDouble(2, bean.getPrice());
					ps.setString(3, bean.getSecondClass());
					ps.setInt(4, bean.getStock());
					ps.setString(5, bean.getName());

					n = ps.executeUpdate();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				return n;
			}


}
