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

import dB.DataS;
import mountain.mountainList.model.MountainBean;
import product.dao.ProductDao;
import product.model.ProductBean;

public class ProductDao_Jdbc implements ProductDao{
	
	
	DataS dataS = new DataS();
//	String tableName = "backpack_class";
	String tableName ;
	private String selected;
	
	@Override
	public List<ProductBean> getProducts() {
		// TODO Auto-generated method stub
		
		List<ProductBean> list01 = new ArrayList<ProductBean>();
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		String sql0 = "select name,type,price,img_url,description,second_class,stock" + 
			"from"+ tableName;
	
	try (
			Connection connection = datasoure.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql0);
		){
		
		
		while (rs.next()) {
			ProductBean pB = new ProductBean();
			pB.setName(rs.getString("name"));
			pB.setType(rs.getString("type"));
			pB.setPrice(rs.getDouble("price"));
			pB.setSecondClass(rs.getString("second_class"));
			pB.setStock(rs.getInt("stock"));
			pB.setImgUrl(rs.getBlob("img_Url"));
			pB.setDescription(rs.getBlob("description"));
		
			list01.add(pB);
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list01;
		
		
	} 
	
	// 修改一筆資料，不改圖片、敘述
		public int updateProduct(ProductBean bean) {
			int n = 0;
			String sql = "UPDATE"+ tableName+  "SET " 
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
		
		// 依name來刪除單筆記錄
		public int deleteProduct(String name) {
			int n = 0;
			String sql = "DELETE FROM"+tableName+" WHERE name = ?";
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

			String sql = "INSERT INTO "+tableName 
					+ " (name,type,price,img_url,description,second_class,stock) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ? )";
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
				pStmt.setString(4, bean.getImgUrl());
				pStmt.setString(5, bean.getDescription());
				pStmt.setString(6, bean.getSecondClass());
				pStmt.setInt(7, bean.getStock());

				n = pStmt.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return n;
		}
		public void setSelected(String selected) {
			this.selected = selected;
		}
	
	//查詢
		public ProductBean getProduct(String name) {
			ProductBean bean = null;
			String sql = "select name,type,price,img_url,description,second_class,stock" + 
						"from" +tableName+" WHERE name = ?";
			dataS.setUsername("hr");
			dataS.setUserPassword("hr");
			DataSource datasoure = dataS.getDatasoure();
			try (
				Connection connection = datasoure.getConnection(); 
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
				ps.setString(1, name);
				try (ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						bean = new ProductBean();
						bean.setName(rs.getString("name"));
						bean.setType(rs.getString(2));
						bean.setPrice(rs.getDouble(3));
						bean.setImgUrl(rs.getBlob(4));
						bean.setDescription(rs.getBlob(5));
						bean.setSecondClass(rs.getString(6));
						bean.setStock(rs.getInt(7)); 
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return bean;
		}
	


		
	
}
}
