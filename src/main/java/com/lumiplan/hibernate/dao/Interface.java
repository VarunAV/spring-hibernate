/**
 * 
 */
package com.lumiplan.hibernate.dao;

import java.util.List;

import com.lumiplan.hibernate.entity.Country;

/**
 * @author Varun
 *
 */
public interface Interface {
	List<Country> getCountryData();
	void getStateData(int disp);
	void getCityData(int disp);
	void insertCountryData(String countryName);
	void insertStateData(String stateName, String countryName);
	void insertCityData(String cityName, String stateName);
	void updateCountryData(String oldCountry1, String newCountry1);
	void updateStateData(String oldState, String newState);
	void updateCityData(String oldCity, String newCity);
	void deleteCountryData(String country);
	void deleteStateData(String state);
	void deleteCityData(String city);
}
