/**
 * 
 */
package com.ssdi.entity;
import javax.persistence.*;

/**
 * @author ajaykumar
 *
 */
@Entity
@Table(name="User_Details")
public class UserDetails {
    @Id
	@GeneratedValue
	public Integer id;
	public String userName;
	public String password;
	public String email;
	public String city;
	
	public UserDetails(){
		
	}
  public UserDetails(Integer id){
		this.id = id;
	}
    public UserDetails(String userName, String password){
	this.userName = userName;
	this.password = password;
}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
