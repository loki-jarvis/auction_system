package com.auctionsystem.model;

public class Product_bids {
	
	private int id;
	private int uid;
	private int pid;
	private int aid;
	private float current_price;
	
	
	
	public Product_bids() {
	}



	public Product_bids( int uid, int pid, float current_price, int aid) {
//		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.aid = aid;
		this.current_price = current_price;
	}




	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	public int getAid() {
		return aid;
	}



	public void setAid(int aid) {
		this.aid = aid;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public float getCurrent_price() {
		return current_price;
	}



	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}



	@Override
	public String toString() {
		return "Product_bids [id=" + id + ", uid=" + uid + ", pid=" + pid + ", current_price=" + current_price + "]";
	}
	
	
	
	
	
	

}
