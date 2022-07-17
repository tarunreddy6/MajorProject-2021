package com.entity;

public class Customer {
	
	private int custid;
	private String name;
	private String pickup;
	private String dropup;
	private float distance;
	private long phoneNum;

	public Customer() {}

	public Customer(int custid, String name, String pickup, String dropup, float distance, long phoneNum) {

		this.custid = custid;
		this.name = name;
		this.pickup = pickup;
		this.dropup = dropup;
		this.distance = distance;
		this.phoneNum = phoneNum;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDropup() {
		return dropup;
	}

	public void setDropup(String dropup) {
		this.dropup = dropup;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", pickup=" + pickup + ", dropup=" + dropup
				+ ", distance=" + distance + ", phoneNum=" + phoneNum + "]";
	}
}
