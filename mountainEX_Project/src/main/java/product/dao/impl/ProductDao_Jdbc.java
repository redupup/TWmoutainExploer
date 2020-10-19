package product.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.apache.commons.dbcp2.PStmtKey;
import org.omg.CORBA.StringHolder;

import dB.DataS;
import mountain.mountainList.model.MountainBean;
import oracle.net.aso.b;
import product.model.ClassBean;
import product.model.ProductBean;

public class ProductDao_Jdbc {

	DataS dataS = new DataS();
	
	public ProductDao_Jdbc() {
	}

//查詢所有	
	public List<ProductBean> getProducts() {
		List<ProductBean> products = new ArrayList<ProductBean>();
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();

		try (Connection connection = datasoure.getConnection();
				) {
			List<ClassBean> classList = getClassList();
			for (ClassBean classBean : classList) {
				String sql = "select name,type,price,img_url,description,second_class,stock,first_class_name from " +classBean.getTableName();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					ProductBean pB = new ProductBean();
					pB.setName(rs.getString("name"));
					pB.setType(rs.getString("type"));
					pB.setPrice(rs.getInt("price"));
					pB.setSecondClass(rs.getString("second_class"));
					pB.setStock(rs.getInt("stock"));
					pB.setImgUrl(rs.getBlob("img_Url"));
					pB.setDescription(rs.getBlob("description"));
					pB.setFirstClassname(rs.getString("first_class_name"));
					products.add(pB);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;

	}

	// 修改一筆資料，不改圖片、敘述
	public int updateProduct(ProductBean bean) {
		int n = 0;
		String firstClassname = bean.getFirstClassname();
		System.out.println(firstClassname);
		 
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		try (Connection connection = datasoure.getConnection();
				){
			try {

				String sql = "UPDATE " + firstClassname + " SET " + " type=?,  price=?, second_class=?,  stock=? "
						+ " WHERE name = ? ";
				PreparedStatement ps = connection.prepareStatement(sql); 
				connection.setAutoCommit(false);
					ps.setString(1, bean.getType());
					System.out.println(bean.getType());
					ps.setDouble(2, bean.getPrice());
					System.out.println(bean.getPrice());
					ps.setString(3, bean.getSecondClass());
					System.out.println(bean.getSecondClass());
					ps.setInt(4, bean.getStock());
					System.out.println(bean.getStock());
					ps.setString(5, bean.getName());
					System.out.println(bean.getName());
					n = ps.executeUpdate();
					
					connection.commit();
						
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
					}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return n;
	}

	// 依名稱來刪除單筆記錄
	public int deleteProduct(String sql) {
		int n = 0;
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		try (Connection connection = datasoure.getConnection();)
				{
			try {
				connection.setAutoCommit(false);
				Statement stmt = connection.createStatement();
				n = stmt.executeUpdate(sql);
				
				connection.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
			}
		
			} catch (SQLException ex) {
				ex.printStackTrace();
		}
		return n;
	}

	// 新增一筆記錄---
	public int saveProduct(ProductBean bean) {
		int n = 0;
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		
		String tablename = bean.getFirstClassname();
		try (Connection connection = datasoure.getConnection();)
		{
			try {
				String sql = "INSERT INTO " + tablename
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
				PreparedStatement pStmt = connection.prepareStatement(sql);
				pStmt.setString(1, bean.getName());
				pStmt.setString(2, bean.getType());
				pStmt.setDouble(3, bean.getPrice());
				pStmt.setBlob(4, bean.getImgUrl());
				pStmt.setBlob(5, bean.getDescription());
				pStmt.setString(6, bean.getSecondClass());
				pStmt.setInt(7, bean.getStock());
				pStmt.setInt(8, bean.getFirstClassid());
				pStmt.setString(9, bean.getFirstClassname());
				connection.setAutoCommit(false);
				n =pStmt.executeUpdate();
			
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return n;
	}

	// 查詢
	public ProductBean getProduct(String name) {
		ProductBean bean = null;
		String sql = "select name,type,price,img_url,description,second_class,stock,first_class_name" + " from"
				+ " backpack_class" + " WHERE name = ?";
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		try (Connection connection = datasoure.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new ProductBean();
					bean.setName(rs.getString("name"));
					bean.setType(rs.getString(2));
					bean.setPrice(rs.getInt(3));
					bean.setImgUrl(rs.getBlob(4));
					bean.setDescription(rs.getBlob(5));
					bean.setSecondClass(rs.getString(6));
					bean.setStock(rs.getInt(7));
					bean.setFirstClassname(rs.getString(8));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	public List<ClassBean> getClassList() {
		List<ClassBean> classBeans = new ArrayList<ClassBean>();
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		String sql = "select * " + "from" + " first_class";

		try (Connection connection = datasoure.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				ClassBean cB = new ClassBean();
				cB.setTableID(rs.getInt("id"));
				cB.setTableName(rs.getString("name"));
				cB.setTableTitle(rs.getString("title"));

				classBeans.add(cB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classBeans;
	}
}
