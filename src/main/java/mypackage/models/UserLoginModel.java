package mypackage.models;

public class UserLoginModel {
	
	private String uUsername;
	private String uPassword;
	
	public UserLoginModel() {
	}

	public UserLoginModel(String uUsername, String uPassword) {
		super();
		this.uUsername = uUsername;
		this.uPassword = uPassword;
	}

	public String getuUsername() {
		return uUsername;
	}

	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
}
