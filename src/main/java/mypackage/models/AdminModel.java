package mypackage.models;

public class AdminModel {
	
	private String ausername;
	private String apassword;
	
	public AdminModel() {
	}

	public AdminModel(String ausername, String apassword) {
		super();
		this.ausername = ausername;
		this.apassword = apassword;
	}
	
	// Getters and Setters
	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
}
