package customer.service.crm.io;


public class ProfileResponse {

	
	private String userId;
	
	public ProfileResponse(String userId, String name, String email, boolean isAccountVerified) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.isAccountVerified = isAccountVerified;
	}

	public ProfileResponse() {
		
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAccountVerified() {
		return isAccountVerified;
	}

	public void setAccountVerified(boolean isAccountVerified) {
		this.isAccountVerified = isAccountVerified;
	}

	private String name;
	
	private String email;
	
	private boolean isAccountVerified;
}
