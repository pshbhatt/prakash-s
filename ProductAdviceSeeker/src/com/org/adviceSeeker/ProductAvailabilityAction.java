package com.org.adviceSeeker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import productSearch.ProductData;
import productSearch.ProductSearchHeader;
import productSearch.ProductSummary;

public class ProductAvailabilityAction {

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
		ProductSearchHeader productSearchHeader = new ProductSearchHeader();
		JSONObject headerJson = (JSONObject) obj.get("Header");
		productSearchHeader.setApiName((String) headerJson.get("API_Name"));
		productSearchHeader.setApiVersion(Float.parseFloat((String) headerJson
				.get("API_Version")));
		productSearchHeader.setContentType((String) headerJson
				.get("Content_Type"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
	    String dateValue = (String)headerJson.get("Date");
	    Date actualDate = sf.parse(dateValue);
	    productSearchHeader.setDate(actualDate);
	    productSearchHeader.setMessageID(Integer.parseInt((String) headerJson
				.get("Message_ID")));
	    
		/*JSONObject productJson = (JSONObject) obj.get("ProductDetails");
		ProductData productData = new ProductData();
		products.setBarCode((String) productJson.get("BarCode"));
		products.setBrand((String) productJson.get("Brand"));
		products.setCategory((String) productJson.get("Category"));
		products.setManufacturerName((String) productJson.get("Manufacturer"));
		products.setProductName((String) productJson.get("ProductName"));
		products.setProductSize((String) productJson.get("Size"));
		JSONArray availabilityJson = (JSONArray) productJson
				.get("Availability");

		for (Iterator iterator = availabilityJson.iterator(); iterator.hasNext();) {
			JSONObject availabilityJ = (JSONObject) iterator.next();*/
			
			JSONArray ProductDetailsArray = (JSONArray) obj.get("ProductDetails");
			for (Iterator iterator2 = ProductDetailsArray.iterator(); iterator2
					.hasNext();) {
				JSONObject object = (JSONObject) iterator2.next();
				ProductData productData = new ProductData();
				productData.setBarCode((String)object.get("UPC"));
				productData.setDescription((String)object.get("Description"));
				productData.setItemCode(Integer.parseInt((String)object.get("Item_Code")));
				productData.setModule((String)object.get("Module"));
				productData.setRank(Integer.parseInt((String)object.get("Rank")));
				
			}
			ProductSummary productSummary = new ProductSummary();
			JSONObject summaryJson = (JSONObject) obj.get("Summary");
			productSummary.setPageNumber(Integer.parseInt((String)summaryJson.get("PageNO")));
			productSummary.setPageSize(Integer.parseInt((String)summaryJson.get("PageSize")));
			productSummary.setTotalPages(Integer.parseInt((String)summaryJson.get("TotalPages")));
			productSummary.setTotalRecords(Integer.parseInt((String)summaryJson.get("TotalRecords")));
		in.close();
	}

}