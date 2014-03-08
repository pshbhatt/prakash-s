package com.org.adviceSeeker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductAction {

	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
	try {
		
		FileInputStream fstream = new FileInputStream("C:\\file\\ProductDetails.txt");
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  while ((strLine = br.readLine()) != null)   {
		  System.out.println (strLine);
		  }
			in.close(); 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


}
