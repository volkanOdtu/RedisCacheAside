package com.vinsguru.cacheaside.dto;

import java.io.Serializable;

public class ProductDto implements Serializable{

	private long id;
	private String description;
	private double price;
	private long qtyavailable;

	 public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public long getQtyavailable() {
	        return qtyavailable;
	    }

	    public void setQtyavailable(long qtyavailable) {
	        this.qtyavailable = qtyavailable;
	    }
}
