package Bean;

public class SignUpBO {

	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	private String city;
	private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @param name
	 * @param email
	 * @param phone
	 * @param password
	 * @param city
	 * @param country
	 */
	public SignUpBO(String name, String email, String phone, String password, String city, String country) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.city = city;
		this.country = country;
	}
	/**
	 * 
	 */
	public SignUpBO() {
		
	}
	
	
}
