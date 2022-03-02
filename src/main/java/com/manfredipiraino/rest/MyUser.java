package com.manfredipiraino.rest;

import java.io.Serializable;

//import javax.xml.bind.annotation.XmlRootElement;

// @XmlRootElement
public class MyUser implements Serializable {
	private static final long serialVersionUID = 2063812721913057470L;
	
	public String myUserName;
	public String myUserSurname;
	public int myUserAge;
	
	public MyUser() {
		
	}
	
	public MyUser(String myUserName, String myUserSurname, int myUserAge) {
		this.myUserName = myUserName;
		this.myUserSurname = myUserSurname;
		this.myUserAge = myUserAge;
	}

}
