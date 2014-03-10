package com.org.adviceSeeker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import productSearch.ProductCharData;
import productSearch.ProductCharHeader;

public class Characterestics {

	public static void main(String args[]) throws IOException, ParseException, java.text.ParseException {
		FileInputStream fstream = new FileInputStream(
				"C:\\file\\ProductDetails.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine, str = "";
		while ((strLine = br.readLine()) != null) {
			str += strLine;
		}
		
		JSONObject obj = (JSONObject) new JSONParser().parse(str);
		
		JSONArray charArray = (JSONArray) obj.get("Characteristics");
		ProductCharData productCharData = new ProductCharData();
		productCharData.setCharData(charArray.toString());
		System.out.println(charArray.toString());
		JSONObject headerJson = (JSONObject) obj.get("Header");
		ProductCharHeader productCharHeader = new ProductCharHeader();
		productCharHeader.setApiName((String) headerJson.get("API_Name"));
		productCharHeader.setApiVersion(Float.parseFloat((String) headerJson
				.get("API_Version")));
		productCharHeader.setContentType((String) headerJson
				.get("Content_Type"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
	    String dateValue = (String)headerJson.get("Date");
	    Date actualDate = sf.parse(dateValue);
	    productCharHeader.setDate(actualDate);
	    productCharHeader.setMessageID(Integer.parseInt((String) headerJson
				.get("Message_ID")));
	    
	    JSONObject characteristics = (JSONObject) obj.get("Characteristics");
	    System.out.println((String)obj.get("Characteristics"));
		in.close();
	}
	
	
}
