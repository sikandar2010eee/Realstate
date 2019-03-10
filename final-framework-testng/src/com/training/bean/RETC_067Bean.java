package com.training.bean;

public class RETC_067Bean {
	private String username;
	private String email;
	private String subject;
	private String text;

	public RETC_067Bean() {
	}

	public RETC_067Bean(String username, String email,String subject, String text) {
		super();
		this.username = username;
		this.email = email;
		this.subject=subject;
		this.text=text;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getsubject() {
		return subject;
	}

	public void setsubject(String subject) {
		this.subject = subject;
	}
	
	public String gettext() {
		return text;
	}

	public void settext(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "RETC_067Bean [username=" + username + ", email=" + email + ",subject="+subject+",text="+text+"]";
	}

}
