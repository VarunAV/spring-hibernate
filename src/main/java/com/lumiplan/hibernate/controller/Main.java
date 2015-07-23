/**  
* 
* @author  Varun A V
* @version 1.0
* @since   15-07-2015
*/

package com.lumiplan.hibernate.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lumiplan.hibernate.dao.Controller;
import com.lumiplan.hibernate.entity.Country;

public class Main{
	
	/**
	* This is the main method which makes use of addNum method.
	* @param args Unused.
	* @return Nothing.
	*/
	public static void main(String[] args){
		
	        
	        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
	       	Controller countryService = (Controller) applicationContext.getBean("load");

	   	countryService.getCountryData();
		//System.out.println(c.size());
		

	  //  Controller.getStateData(1);
		System.out.println();

	//	Controller.getCityData(1);
		System.out.println();

	}
}