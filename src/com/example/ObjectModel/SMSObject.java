package com.example.ObjectModel;

public class SMSObject {
	
	private int id;
	private String sms;
	
	public SMSObject(int id, String sms)
	{
		this.id = id;
		this.sms = sms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}
	

}
