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

import com.org.productavailability.CallSummaryHeader;
import com.org.productavailability.ProductAvailabilityResponse;
import com.org.productavailability.Products;
import com.org.productavailability.ResultSummary;
import com.org.productavailability.Retailers;

public class WebSocketTest {

	@SuppressWarnings("unchecked")
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
		CallSummaryHeader callSummaryHeader = new CallSummaryHeader();
		JSONObject headerJson = (JSONObject) obj.get("Header");
		callSummaryHeader.setApiName((String) headerJson.get("API_Name"));
		callSummaryHeader.setApiVersion(Float.parseFloat((String) headerJson
				.get("API_Version")));
		callSummaryHeader.setContentType((String) headerJson
				.get("Content_Type"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
	    String dateValue = (String)headerJson.get("Date");
	    Date actualDate = sf.parse(dateValue);
		callSummaryHeader.setDate(actualDate);
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
				Retailers retailers = new Retailers();
				retailers.setPhoneContact((String)object.get("StoreId"));
				retailers.setAddressLine1((String)((JSONObject)object.get("Locations")).get("Phone"));
				retailers.setCity((String)((JSONObject)object.get("Locations")).get("City"));
				retailers.setCountry((String)((JSONObject)object.get("Locations")).get("Country"));
				retailers.setDistance(Float.parseFloat((String)object.get("Distance")));
				retailers.setLatitude(Float.parseFloat((String)((JSONObject)object.get("Locations")).get("Latitude")));
				retailers.setLongitude(Float.parseFloat((String)((JSONObject)object.get("Locations")).get("Longitude")));
				retailers.setRetailerName((String)object.get("RetailerName"));
				retailers.setState((String)((JSONObject)object.get("Locations")).get("State"));
				retailers.setStoreName((String)object.get("StoreName"));
				retailers.setStoreNumber((String)object.get("StoreNumber"));
				retailers.setZip((String)((JSONObject)object.get("Locations")).get("ZipCode"));
				ProductAvailabilityResponse response = new ProductAvailabilityResponse();
				response.getRetailerList().add(retailers);
				JSONObject summaryJson = (JSONObject) obj.get("Summary");
				ResultSummary summary = new ResultSummary();
				summary.setFarthestResult(Float.parseFloat((String)summaryJson.get("FarthestResult")));
				summary.setNearestResult(Float.parseFloat((String)summaryJson.get("NearestResult")));
				summary.setPageNumber(Integer.parseInt((String)summaryJson.get("PageNo")));
				summary.setPageSize(Integer.parseInt((String)summaryJson.get("PageSize")));
				summary.setTotalPages(Integer.parseInt((String)summaryJson.get("TotalPages")));
				summary.setTotalRetailers(Integer.parseInt((String)summaryJson.get("TotalRetailers")));
				summary.setTotalStores(Integer.parseInt((String)summaryJson.get("TotalStores")));
				
			}
		}
		in.close();
	}

}