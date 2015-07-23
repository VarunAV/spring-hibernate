/**
* The Country class sets and gets the country data from the database  
* 
* @author  Varun A V
* @version 1.0
* @since   15-07-2015
*/

package com.lumiplan.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {
	@Id @GeneratedValue
	@Column(name = "Country_id")
	private int countryId;
	@Column(name = "Country_name")
	private String country;
	@OneToMany (mappedBy = "stateId")
	private List<State> State = new ArrayList<State>();
	
	public Country(){}
	
    /**
     * This method is used to set the country name.
     * @param countryName This is the first parameter to setCountry method
     */
	public void setCountry(String countryName){
		country = countryName;
	}
	
    /**
     * This method is used to set the country ID.
     * @param countryID This is the first parameter to setCountryID method
     */
	public void setCountryID(int countryID){
		countryId = countryID;
	}
	
    /**
     * This method is used to get the country ID.
     * @return int This returns the countryID
     */
	public int getCountryID(){
		return countryId;
	}
	
    /**
     * This method is used to get the country name.
     * @return String This returns the country name
     */
	public String getCountry(){
		return country;
	}
	
    /**
     * This method is used to get the states present in a particular country.
     * @return String This returns the states
     */
	public List<State> getState(){
		return State;
	}
	
    /**
     * This method is used to set the states in a particular country .
     * @param state This is the first parameter to setState method
     */
	public void setState(List<State> state){
		State = state;
	}
}
