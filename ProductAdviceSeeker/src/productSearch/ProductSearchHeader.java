package productSearch;

import java.util.Date;

public class ProductSearchHeader {

	
	private float apiVersion; 
	private  String apiName;
	private Date date;
	private int messageID;
	private String contentType;
	public float getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(float apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	

}
