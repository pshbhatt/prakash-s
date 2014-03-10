package productSearch;

public class ProductRequestByScan {

	private String apiKey;
	private String searchByScan;
	private int pageSize;
	private int pageNumber;
	private String responseDataFormat;
	
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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
	public String getSearchByScan() {
		return searchByScan;
	}
	public void setSearchByScan(String searchByScan) {
		this.searchByScan = searchByScan;
	}
	
	

}
