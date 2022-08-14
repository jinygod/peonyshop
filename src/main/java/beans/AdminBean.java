package beans;

public class AdminBean {
	
	private String admin_code;
	private String admin_name;
	private boolean adminLogin;
	
	public AdminBean() {
		this.adminLogin = false;
	}

	public String getAdmin_code() {
		return admin_code;
	}

	public void setAdmin_code(String admin_code) {
		this.admin_code = admin_code;
	}

	public boolean isAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(boolean adminLogin) {
		this.adminLogin = adminLogin;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	
}
