package com.ssdi.entity;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "MyPlans")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Plan {
	@Id
	@GeneratedValue
	@Column(name="place_Id")
	private Integer placeId;
	@NotNull
	@Column(name="Place")
	private String place;
	@NotNull
	@Column(name="Address")
	private String address;
	@NotNull
	@Column(name="Hotel")
	private String hotel;
	@NotNull
	@Column(name="Dateoftravel")
	private Date dateTravel;
	@NotNull
	@Column(name="DateAdded")
	private Date dateAdded;

	@Column(name="Climate")
	private String climate;
	
	@ManyToOne
	@JoinColumn(name="userId", insertable=false, updatable=false)
	  private User user;
	
	private Integer userId;
	
	@Transient
	private String emailId;
	
	public Plan(){
	}

	/**
	 * @return the placeId
	 */
	public Integer getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the dateTravel
	 */
	public Date getDateTravel() {
		return dateTravel;
	}

	/**
	 * @param dateTravel the dateTravel to set
	 */
	public void setDateTravel(Date dateTravel) {
		this.dateTravel = dateTravel;
	}

	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the climate
	 */
	public String getClimate() {
		return climate;
	}

	/**
	 * @param climate the climate to set
	 */
	public void setClimate(String climate) {
		this.climate = climate;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

		
	
}
