package model;

import java.io.Serializable;

public class Billboard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int high;
	public boolean inUse;
	private String Brand;
	
	
	
	public Billboard(int width, int high, boolean inUse, String brand) {
		super();
		this.width = width;
		this.high = high;
		this.inUse = inUse;
		Brand = brand;
	}



	public Billboard() {
		// TODO Auto-generated constructor stub
	}



	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public boolean isInUse() {
		return inUse;
	}
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
}
