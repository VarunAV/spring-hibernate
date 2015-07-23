/**
* The City class sets and gets the city data from the database  
* 
* @author  Varun A V
* @version 1.0
* @since   15-07-2015
*/

package com.lumiplan.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {
	@Id @GeneratedValue
	@Column(name = "City_id")
	int cityId;
	@Column(name = "City_name")
	private  String city;
	@ManyToOne
	@JoinColumn(name="State_id")	
	private State stateId;
	
	public City(){}
	
    /**
     * This method is used to set the city name.
     * @param cityName This is the first parameter to setCity method
     */
	public void setCity(String cityName){
		city = cityName;
	}
	
    /**
     * This method is used to set the city ID.
     * @param cityID This is the first parameter to setCityID method
     */
	public void setCityID(int cityID){
	cityId = cityID;
	}
	
    /**
     * This method is used to get the city ID.
     * @return int This returns the city ID
     */
	public int getCityID(){
		return cityId;
	}

	/**
     * This method is used to get the city name.
     * @return String This returns the city name
     */
	public String getCity(){
		return city;
	}
	
    /**
     * This method is used to set the state associated with a particular city.
     * @param state This is the first parameter to setState method
     */
	public void setState(State state){
		stateId = state;
	}
	
	/**
     * This method is used to get the state associated with a particular city.
     * @return State This returns the state
     */
	public State getState(){
		return stateId;
	}
}
