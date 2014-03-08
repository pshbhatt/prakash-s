package com.org.productavailability;

public class ResultSummary {

	private int totalRetailers;
	private int totalStores;
	private int pageNumber;
	private int totalPages;
	private int pageSize;
	private float nearestResult;
	private float farthestResult;
	public int getTotalRetailers() {
		return totalRetailers;
	}
	public void setTotalRetailers(int totalRetailers) {
		this.totalRetailers = totalRetailers;
	}
	public int getTotalStores() {
		return totalStores;
	}
	public void setTotalStores(int totalStores) {
		this.totalStores = totalStores;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public float getNearestResult() {
		return nearestResult;
	}
	public void setNearestResult(float nearestResult) {
		this.nearestResult = nearestResult;
	}
	public float getFarthestResult() {
		return farthestResult;
	}
	public void setFarthestResult(float farthestResult) {
		this.farthestResult = farthestResult;
	}
	
	

	
}
