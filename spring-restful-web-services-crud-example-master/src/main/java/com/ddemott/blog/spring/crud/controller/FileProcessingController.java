package com.ddemott.blog.spring.crud.controller;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddemott.blog.spring.beans.CSVBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@RestController
public class FileProcessingController {

	@RequestMapping(value = "/readCSV")
	public List<CSVBean> readDataLineByLine(){
		String strCell="Empty";
		List<CSVBean> csvBeanList = new ArrayList<CSVBean>();
	    try { 
	    	System.out.println("inside String readDataLineByLine");
	        // Create an object of filereader 
	        // class with CSV file as a parameter. 
	    	File file = new File("D:\\proj\\indusind\\VDCustomers.csv");
	    	System.out.println("file extension ::"+FilenameUtils.getExtension("D:\\proj\\indusind\\VDCustomers.csv"));
	    	if(file.exists()){
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object passing 
	        // file reader as a parameter 
	        CSVReader csvReader = new CSVReader(filereader);
	        Reader reader = Files.newBufferedReader(Paths.get("D:\\proj\\indusind\\VDCustomers.csv"));
	        
	        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(CSVBean.class);
            //String[] memberFieldsToBindTo = {"Banking CIF ID", "Account Number", "Last 4 digits of debit card", "Mobile Number","Email id"};
            //strategy.setColumnMapping(memberFieldsToBindTo);

				CsvToBean<CSVBean> csvToBean = new CsvToBeanBuilder(reader).withType(CSVBean.class)
						.withMappingStrategy(strategy).build();
                    

            Iterator<CSVBean> mycsvBeanIterator = csvToBean.iterator();
            
            while(mycsvBeanIterator.hasNext()){
            	//CSVBean csvBean = mycsvBeanIterator.next();
            	//System.out.println("cif:"+csvBean.getAccountNum());
            	csvBeanList.add(mycsvBeanIterator.next());
            }
            
	        String headerData[] = {"Banking CIF ID","Account Number","Last 4 digits of debit card","Mobile Number","Email id"};
	        String[] nextRecord = csvReader.readNext();
	        System.out.println("length::"+nextRecord.length);
	        
	        
	        System.out.println(Arrays.deepEquals(nextRecord, headerData));
	        int i =0;
	        for(String s:nextRecord){
	        	 
          		 System.out.println(s);
          		 System.out.println(s.equals(nextRecord[i++]));
          	 }
	      
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) {
	           	 for(String s:nextRecord){
	           		 System.out.println(s);
	           		 System.out.println("".equals(s));
	           	 }
	        }
	      }
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	    return csvBeanList;
	}
}
