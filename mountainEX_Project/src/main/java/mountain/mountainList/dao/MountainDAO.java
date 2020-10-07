package mountain.mountainList.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dB.DataS;
import mountain.mountainList.model.MountainBean;

public class MountainDAO {
	
	DataS dataS = new DataS();
	
	public List<MountainBean> routeSummary() throws SQLException {
		
		dataS.setUsername("demo");
		dataS.setUserPassword("demo");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				){
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from route_summary");
			
			List<MountainBean> mBList = new ArrayList<MountainBean>(); 
			
			while (rs.next()) {
				MountainBean mB = new MountainBean();
				
				//1
				mB.setName(rs.getString("name"));
				
				//2
				Blob description = rs.getBlob("description");
				if (description != null) {
					
					try(
							InputStream bS = description.getBinaryStream();
							InputStreamReader isr = new InputStreamReader(bS);
							) {
						char[] chars = new char[1024];
						int buffer ;
						StringBuffer result = new StringBuffer();
						while ( (buffer = isr.read(chars)) != -1) {
							result.append(chars, 0, buffer);
							
						}
						mB.setDescription(result.toString());
						
					} catch (IOException e) {
						System.out.println("獲取route_summary:description時，出現 : " + e.getMessage());
					}
				}else {
					mB.setDescription(null);
				}
				
				//3
				Blob advice = rs.getBlob("advice");
				if (advice != null) {
					
					try(
							InputStream bS = advice.getBinaryStream();
							InputStreamReader isr = new InputStreamReader(bS);
							) {
						char[] chars = new char[1024];
						int buffer ;
						StringBuffer result = new StringBuffer();
						while ( (buffer = isr.read(chars)) != -1) {
							result.append(chars, 0, buffer);
						}
						mB.setAdvice(result.toString());
						
					} catch (IOException e) {
						System.out.println("獲取route_summary:advice 時，出現 : " + e.getMessage());
					}
				}else {
					mB.setAdvice(null);
				}
				
				//4
				Blob traffic = rs.getBlob("traffic");
				if (traffic != null) {
					
					try(
							InputStream bS = traffic.getBinaryStream();
							InputStreamReader isr = new InputStreamReader(bS);
							) {
						char[] chars = new char[1024];
						int buffer ;
						StringBuffer result = new StringBuffer();
						while ( (buffer = isr.read(chars)) != -1) {
							result.append(chars, 0, buffer);
						}
						mB.setTraffic(result.toString());
						
					} catch (IOException e) {
						System.out.println("獲取route_summary:advice 時，出現 : " + e.getMessage());
					}
				}else {
					mB.setTraffic(null);
				}
				
				//5
				mB.setNpName(rs.getString("NATIONAL_PARK_NAME"));
				
				//6
				Blob img_url = rs.getBlob("img_url");
				if (img_url != null) {
					
					try(
							InputStream bS = img_url.getBinaryStream();
							InputStreamReader isr = new InputStreamReader(bS);
							) {
						char[] chars = new char[1024];
						int buffer ;
						StringBuffer result = new StringBuffer();
						while ( (buffer = isr.read(chars)) != -1) {
							result.append(chars, 0, buffer);
						}
						mB.setImgUrl(result.toString());
						
					} catch (IOException e) {
						System.out.println("獲取route_summary:img_url 時，出現 : " + e.getMessage());
					}
				}else {
					mB.setTraffic(null);
				}
				
				mBList.add(mB);
				
				
			}
			
			return mBList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} throw new SQLException("SQLException");
		
	}

}
