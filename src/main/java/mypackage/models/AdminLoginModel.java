package mypackage.models;

public class AdminLoginModel {
	
	private String aUsername;
	private String aPassword;
	
	public AdminLoginModel() {
	}

	public AdminLoginModel(String aUsername, String aPassword) {
		super();
		this.aUsername = aUsername;
		this.aPassword = aPassword;
	}

	public String getaUsername() {
		return aUsername;
	}

	public void setaUsername(String aUsername) {
		this.aUsername = aUsername;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
}
