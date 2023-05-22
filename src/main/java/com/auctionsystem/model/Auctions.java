package com.auctionsystem.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Auctions {
	
	private int id;
    private int pid;
    private int uid;
    private float minimumPrice;
    private Timestamp closingTime;
    private int bidType;
    private Float upperLimit;
    private Float bidIncrement;
    private int category;
    
    
    
    
	public Auctions() {
	}




	public Auctions(int id, int pid, int uid, float minimumPrice, Timestamp closingTime, int bidType, Float upperLimit,
			Float bidIncrement, int category) {
	
		this.id = id;
		this.pid = pid;
		this.uid = uid;
		this.minimumPrice = minimumPrice;
		this.closingTime = closingTime;
		this.bidType = bidType;
		this.upperLimit = upperLimit;
		this.bidIncrement = bidIncrement;
		this.category = category;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getPid() {
		return pid;
	}




	public void setPid(int pid) {
		this.pid = pid;
	}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public float getMinimumPrice() {
		return minimumPrice;
	}




	public void setMinimumPrice(float minimumPrice) {
		this.minimumPrice = minimumPrice;
	}




	public Timestamp getClosingTime() {
		return closingTime;
	}




	public void setClosingTime(Timestamp ClosingTime) {
		this.closingTime = ClosingTime;
	}




	public int getBidType() {
		return bidType;
	}




	public void setBidType(int bidType) {
		this.bidType = bidType;
	}




	public Float getUpperLimit() {
		return upperLimit;
	}




	public void setUpperLimit(Float upperLimit) {
		this.upperLimit = upperLimit;
	}




	public Float getBidIncrement() {
		return bidIncrement;
	}




	public void setBidIncrement(Float bidIncrement) {
		this.bidIncrement = bidIncrement;
	}




	public int getCategory() {
		return category;
	}




	public void setCategory(int category) {
		this.category = category;
	}




	@Override
	public String toString() {
		return "Auctions [id=" + id + ", pid=" + pid + ", uid=" + uid + ", minimumPrice=" + minimumPrice
				+ ", closingTime=" + closingTime + ", bidType=" + bidType + ", upperLimit=" + upperLimit
				+ ", bidIncrement=" + bidIncrement + ", category=" + category + "]";
	}
    
    

}
