package com.orgy.ApiCall;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.properties.APIProperties;

public class APICall {
	private final String USER_AGENT = "Mozilla/5.0";
	 
	public static void main(String[] args) throws Exception {
 
		APICall http = new APICall();
 
		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
	}
 
	// HTTP GET request
	private void sendGet() throws Exception {
 
		String url = "https://nielsen.api.tibco.com/Products/v1/?search=CHEESE&pgSize=5&pgNo=4&apikey=2208-5e2c0b82-fb8c-4c25-a1ab-7f10457a39ef";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
	
	}

