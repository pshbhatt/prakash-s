package com.org.adviceSeeker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.org.productavailability.CallSummaryHeader;
import com.org.productavailability.Products;

public class WebSocketTest {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException, ParseException {
		FileInputStream fstream = new FileInputStream(
				"C:\\file\\ProductDetails.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine, str = "";
		while ((strLine = br.readLine()) != null) {
			str += strLine;
		}
		JSONObject obj = (JSONObject) new JSONParser().parse(str);
		CallSummaryHeader callSummaryHeader = new CallSummaryHeader();
		JSONObject headerJson = (JSONObject) obj.get("Header");
		callSummaryHeader.setApiName((String) headerJson.get("API_Name"));
		callSummaryHeader.setApiVersion(Float.parseFloat((String) headerJson
				.get("API_Version")));
		callSummaryHeader.setContentType((String) headerJson
				.get("Content_Type"));
		// callSummaryHeader.setDate(Date.valueOf((String)headerJson.get("Date")));
		callSummaryHeader.setMessageID(Integer.parseInt((String) headerJson
				.get("MessageID")));
		JSONObject productJson = (JSONObject) obj.get("Product");
		Products products = new Products();
		products.setBarCode((String) productJson.get("BarCode"));
		products.setBrand((String) productJson.get("Brand"));
		products.setCategory((String) productJson.get("Category"));
		products.setManufacturerName((String) productJson.get("Manufacturer"));
		products.setProductName((String) productJson.get("ProductName"));
		products.setProductSize((String) productJson.get("Size"));
		JSONArray availabilityJson = (JSONArray) productJson
				.get("Availability");

		for (Iterator iterator = availabilityJson.iterator(); iterator.hasNext();) {
			JSONObject availabilityJ = (JSONObject) iterator.next();
			
			JSONArray RetailerArray = (JSONArray) availabilityJ.get("Retailer");
			for (Iterator iterator2 = RetailerArray.iterator(); iterator2
					.hasNext();) {
				JSONObject object = (JSONObject) iterator2.next();
				
				System.out.println("StoreId: "+ object.get("StoreId"));
				System.out.println("Phone: "+ ((JSONObject)object.get("Locations")).get("Phone"));
				
			}
		}
		in.close();
	}

}