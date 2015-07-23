/**
* The State class sets and gets the state data from the database  
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "State")
public class State {
	@Id @GeneratedValue
	@Column(name = "State_id")
	private int stateId;
	@Column(name = "State_name")
	private String state;

	@ManyToOne
	@JoinColumn(name="Country_id")	
	private Country countryId;
	
	@OneToMany (mappedBy = "cityId")
	private List<City> city = new ArrayList<City>();
	
	public State(){}
	
    /**
     * This method is used to set the state name.
     * @param stateName This is the first parameter to setState method
     */
	public void setState(String stateName){
		state = stateName;
	}
	
    /**
     * This method is used to set the state ID.
     * @param stateID This is the first parameter to setStateID method
     */
	public void setStateID(int stateID){
		stateId = stateID;
	}
	
    /**
     * This method is used to get the state ID.
     * @return int This returns the stateID
     */
	public int getStateID(){
		return stateId;
	}
	
    /**
     * This method is used to get the state name.
     * @return String This returns the state name
     */
	public String getState(){
		return state;
	}
	
    /**
     * This method is used to set the country associated with a particular state.
     * @param country This is the first parameter to setCountry method
     */
	public void setCountry(Country country){
		countryId = country;
	}
	
    /**
     * This method is used to set the country ID.
     * @return Country This returns the Country object associated with a particular state
     */
	public Country getCountry(){
		return countryId;
	}
	
    /**
     * This method is used to get the cities present in a particular state.
     * @return List<City> This returns the lists of cities
     */
	public List<City> getCity(){
		return city;
	}
	
    /**
     * This method is used to set the cities present in a particular state.
     * @param cityL This is the first parameter to setCity method
     */
	public void setCity(List<City> cityL){
		city = cityL;
	}
}
