package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.Complex_RTTC_071_Bean;
import com.training.dao.Complex_RTTC_071_DAO;

public class Complex_RTTC_071_DataProviders {
	
	@DataProvider(name = "RTTC_071-db-inputs")
	public Object [][] getDBData() {

		List<Complex_RTTC_071_Bean> list = new Complex_RTTC_071_DAO().getRTTD_009_data(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(Complex_RTTC_071_Bean temp : list){
			Object[]  obj = new Object[10]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getProductName(); 
			obj[3] = temp.getMetaTitle(); 
			obj[4] = temp.getModel();
			obj[5] = temp.getPrice();
			obj[6] = temp.getCategory();
			obj[7] = temp.getQuantity();
			obj[8] = temp.getDiscountPrice();
			obj[9] = temp.getPoints();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}

}
