package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class Complex_RTTC_072_DataProviders {
	
	@DataProvider(name = "RTTC_072_excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\AnushaSharma\\Documents\\selenium\\ExcelDemo\\RTTD_010.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}

}
