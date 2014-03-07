package com.org.adviceSeeker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserPageBean {

	private String productBarCode="abcd";
	

	public String getProductBarCode() {
		return productBarCode;
	}

	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
	
}
