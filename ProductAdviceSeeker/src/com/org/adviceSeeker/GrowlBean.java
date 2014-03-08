package com.org.adviceSeeker;



import java.awt.event.ActionEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;
@ManagedBean
@SessionScoped
public class GrowlBean{

    private String product;
    
    private String comment;
    
    
   

	public GrowlBean() {
		super();
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void save(ActionEvent actionEvent) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		//context.addMessage(null, new FacesMessage("Successful", "Hello " + text));
		context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));
	}
    
    public void send() {
    	System.out.println("trying to send");
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        System.out.println(pushContext);
        System.out.println(product+comment);
        pushContext.push("/notifications", new FacesMessage(product, comment));
    }
}
                    
