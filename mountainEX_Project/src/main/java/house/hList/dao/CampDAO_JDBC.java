package house.hList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dB.DataS;
import house.hList.model.CampBeen;
import house.hList.model.HouseBeen;

public class CampDAO_JDBC {

	DataS dataS = new DataS();
	public List<CampBeen> listCamp(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from camp ");

			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	public List<CampBeen> slesctCity(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from camp where city like ?");
				){
			stmt.setString(1, "%"+abc+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	
	public List<CampBeen> slesctTown(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from camp where camptown like ?");
				){
			stmt.setString(1, "%"+abc+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	
	public List<CampBeen> slesctName(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from camp where campname like ?");
				){
			stmt.setString(1, "%"+abc+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	
		
		
		}
