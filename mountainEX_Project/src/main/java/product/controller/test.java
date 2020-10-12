package product.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import product.model.ProductBean;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ProductBean> list01 = new ArrayList<ProductBean>();

		String sql0 = "select name,type,price,img_url,description,second_class,stock" + 
			"from"+ "cloth_class";
		try (Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xepdb1", "hr", "hr");
			Statement stmt =connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql0);
			
			) {
	
		
		
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
			System.out.println(list01);
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		
//		return list01;

}
}
