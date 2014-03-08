package com.org.productavailability;

public class ProductAvailabilityRequest {
	private String apiKey;
	private String barCode;
	private float latitude;
	private float longitude;
	private int distance;
	private int pageSize;
	private int pageNumber;
	private String responseDataFormat;
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getResponseDataFormat() {
		return responseDataFormat;
	}
	public void setResponseDataFormat(String responseDataFormat) {
		this.responseDataFormat = responseDataFormat;
	}
	
	

}
