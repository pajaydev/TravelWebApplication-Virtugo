/**
 * 
 */
package com.ssdi.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;



/**
 * @author ajaykumar
 *
 */
@Entity
@Table(name="User_Details")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {
    @Id
	@GeneratedValue
	@Column(name="UserId")
	private Integer userId;
    @NotNull
    @Column(name="User_Name")
    private String userName;
    @NotNull
    @Column(name="Password")
    private String password;
    @NotNull
    @Column(name="Email_Id")
    private String email;
	@Transient
	private String sessionId;
	
	public User(){
		
	}
  public User(Integer id){
		this.userId = id;
	}
    public User(String userName, String password){
	this.userName = userName;
	this.password = password;
}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return userId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.userId = id;
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
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
