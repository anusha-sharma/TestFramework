package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.Complex_RTTC_071_Bean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class Complex_RTTC_071_DAO {
Properties properties; 
	
	public Complex_RTTC_071_DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Complex_RTTC_071_Bean> getRTTD_009_data(){
		String sql = properties.getProperty("get.RTTD_009_data"); 
		
		GetConnection gc  = new GetConnection(); 
		List<Complex_RTTC_071_Bean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<Complex_RTTC_071_Bean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				Complex_RTTC_071_Bean temp = new Complex_RTTC_071_Bean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));
				temp.setProductName(gc.rs1.getString(3));
				temp.setMetaTitle(gc.rs1.getString(4));
				temp.setModel(gc.rs1.getString(5));
				temp.setPrice(gc.rs1.getString(6));
				temp.setCategory(gc.rs1.getString(7));
				temp.setQuantity(gc.rs1.getString(8));
				temp.setDiscountPrice(gc.rs1.getString(9));
				temp.setPoints(gc.rs1.getString(10));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new Complex_RTTC_071_DAO().getRTTD_009_data().forEach(System.out :: println);
	}

}
