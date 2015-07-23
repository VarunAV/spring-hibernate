/**
* The controller class implements the CRUD operations on the database 
* 
* @author  Varun A V
* @version 1.0
* @since   15-07-2015
*/

package com.lumiplan.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lumiplan.hibernate.entity.City;
import com.lumiplan.hibernate.entity.Country;
import com.lumiplan.hibernate.entity.State;


public class Controller implements Interface{

    static List<Country> cList = new ArrayList<Country>();
    static List<State> sList = new ArrayList<State>();
    static List<City> ctList = new ArrayList<City>();
	
	   private SessionFactory sessionFactory ;

	   public SessionFactory getSessionFactory()
	   {
	      return sessionFactory;
	   }

	   public void setSessionFactory(SessionFactory x)
	   {
	      this.sessionFactory= x;
	   }
    /**
     * This method is used to read the Country data from the database.
     * @param disp This is the first parameter to getCountryData method
     * @return Nothing.
     */
	public List<Country> getCountryData(){
        /*Session session = HibernateClass.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("rawtypes")
		List l = session.createCriteria(Country.class,"country").list();
        @SuppressWarnings("rawtypes")
		Iterator i = l.iterator();
        while(i.hasNext()){
        	Country countrythis = (Country) i.next();
        	if(disp == 1)
        	System.out.println(countrythis.getCountryID()+"  "+countrythis.getCountry()+" "+countrythis.getState().get(0).getState());
        	cList.add(countrythis);
        }
        session.close();
    	transaction.commit();*/
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Country.class);
		@SuppressWarnings("unchecked")
		List<Country> countries = criteria.list();
		for(int i=0;i<countries.size();i++){
			System.out.println(countries.get(i).getCountry());
		}
		session.close();
		return countries;
		}

    /**
     * This method is used to read the State data from the database.
     * @param disp This is the first parameter to getStateData method
     * @return Nothing.
     */
	public  void getStateData(int disp){
		Session session = sessionFactory.openSession();
        @SuppressWarnings("rawtypes")
		List l = session.createCriteria(State.class,"city").list();
        @SuppressWarnings("rawtypes")
		Iterator i = l.iterator();
        while(i.hasNext()){
        	State sta = (State) i.next();
        	int j=0;
        	if(disp==1){
        	while(j<sta.getCity().size()){
        	System.out.println(sta.getStateID()+" "+sta.getState()+" "+sta.getCity().get(j).getCity());
        	j++;}
        	}
        	sList.add(sta);
        }
        session.close();
	}

    /**
     * This method is used to read the City data from the database.
     * @param disp This is the first parameter to getCityData method
     * @return Nothing.
     */        
    public void getCityData(int disp){
		Session session = sessionFactory.openSession();
		Criteria ct = session.createCriteria(City.class);
        /*Criteria ct = session.createCriteria(Country.class, "country");
        ct.createAlias("country.state", "state");
        ct.createAlias("state.city", "city");*/
        @SuppressWarnings("rawtypes")
		List l = ct.list();
		//List l = session.createCriteria(City.class,"state").createAlias("state.stateId", "join2", JoinType.INNER_JOIN).list();
        @SuppressWarnings("rawtypes")
		Iterator j = l.iterator();
        while(j.hasNext()){
        	City cty = (City) j.next();
        	if(disp==1)
        	System.out.println(cty.getCityID()+"  "+cty.getCity()+"  "+cty.getState().getState()+" "+cty.getState().getCountry().getCountry());
        	ctList.add(cty);
        }
        session.close();
    }
    

    /**
     * This method is used to insert data into the Country database.
     * @param countryName This is the first parameter to insertCountryData method
     * @return Nothing.
     */
    public void insertCountryData(String countryName){
		Session session = sessionFactory.openSession();
    	Country country = new Country();
    	country.setCountry(countryName);
    	session.save(country);
    	cList.add(country);
    	session.flush();
    	session.close();
    }

    /**
     * This method is used to update the data in the Country database.
     * @param oldCountry This is the first parameter to updateCountryData method
     * @param newCountry This is the second parameter to updateCountryData method
     * @return Nothing.
     */
    public void updateCountryData(String oldCountry, String newCountry){
    	cList = this.getCountryData();
		Session session = sessionFactory.openSession();
    	int i = 0;
    	while(i<cList.size()){
    		if(cList.get(i).getCountry().equals(oldCountry)){
    			cList.get(i).setCountry(newCountry);
    			session.update(cList.get(i));
    			break;
    		}
    		i++;
    	}
    	session.flush();
    	session.close();
    }

    /**
     * This method is used to delete data from the Country database.
     * @param deleteCountry This is the first parameter to insertCountryData method
     * @return Nothing.
     */
    public void deleteCountryData(String countryName){
    	cList = this.getCountryData();
    	this.getStateData(0);
    	this.getCityData(0);
		Session session = sessionFactory.openSession();
    	int i=0;
    	while(i<cList.size()){
    		if(cList.get(i).getCountry().equals(countryName)){
    			session.delete(cList.get(i));
    			break;
    		}
    		i++;
    	}
    	i=0;
    	while(i<sList.size()){
    		if(sList.get(i).getCountry().equals(countryName)){
    			session.delete(sList.get(i));
    			break;
    		}
    		i++;
    	}
    	i=0;
    	while(i<ctList.size()){
    		if(ctList.get(i).getState().equals(countryName)){
    			session.delete(ctList.get(i));
    			break;
    		}
    		i++;
    	}
    	session.flush();
    	session.close();
    }

    /**
     * This method is used to insert data into the State database.
     * @param state This is the first parameter to insertStateData method
     * @param country This is the second parameter to insertStateData method
     * @return Nothing.
     */
    public void insertStateData(String state, String country){
    	this.getCountryData();
    	this.getStateData(0);
		Session session = sessionFactory.openSession();
    	int i=0;
    	Country cntry = new Country();
    	State st = new State();
    	while(i<cList.size()){
    		if(cList.get(i).getCountry().equals(country)){
    			cntry = cList.get(i);
    		break;}
    		i++;
    	}
    	st.setState(state);
    	st.setCountry(cntry);
    	session.save(st);
    	session.flush();
    	session.close();
    }
    
    /**
     * This method is used to update the data in the State database.
     * @param oldState This is the first parameter to updateStateData method
     * @param nreState This is the second parameter to updateStateData method
     * @return Nothing.
     */   
    public void updateStateData(String oldState, String newState){
    	this.getStateData(0);
		Session session = sessionFactory.openSession();
    	int i=0;
    	while(i<sList.size()){
    		if(sList.get(i).getState().equals(oldState)){
    			sList.get(i).setState(newState);
    	    	session.update(sList.get(i));
    	    	break;
    		}
    		i++;
    	}
    	session.flush();
    	session.close();
    }
    
    /**
     * This method is used to delete data from the State database.
     * @param stateName This is the first parameter to deleteStateData method
     * @return Nothing.
     */
    public void deleteStateData(String stateName){
    	this.getCountryData();
    	this.getStateData(0);
    	this.getCityData(0);
		Session session = sessionFactory.openSession();
    	int i=0;
    	while(i<sList.size()){
    		if(sList.get(i).getState().equals(stateName)){
    			session.delete(sList.get(i));
    			break;
    		}
    		i++;
    	}
    	i=0;
    	while(i<ctList.size()){
    		if(ctList.get(i).getState().getState().equals(stateName)){
    			session.delete(ctList.get(i));
    			break;
    		}
    		i++;
    	}
    	session.flush();
    	session.close();
    }
    
    /**
     * This method is used to insert data into the City database.
     * @param city This is the first parameter to insertCityData method
     * @param state This is the second parameter to insertCityData method
     * @return Nothing.
     */
    public void insertCityData(String city, String state){
    	this.getCityData(0);
    	this.getStateData(0);
		Session session = sessionFactory.openSession();
		City cty = new City();
    	State st = new State();
    	cty.setCity(city);
    	int i=0;
    	while(i<sList.size()){
    		if(sList.get(i).getState().equals(state)){
    			st = sList.get(i);
    		break;}
    		i++;
    	}
    	cty.setState(st);
    	session.save(cty);
    	session.flush();
    	session.close();
    }
    
    /**
     * This method is used to update the data in the City database.
     * @param oldCity This is the first parameter to updateCityData method
     * @param newCity This is the second parameter to updateCityData method
     * @return Nothing.
     */
    public void updateCityData(String oldCity, String newCity){
    	this.getCityData(0);
		Session session = sessionFactory.openSession();
    	int i=0;
    	while(i<ctList.size()){
    		if(ctList.get(i).getCity().equals(oldCity)){
    			ctList.get(i).setCity(newCity);
    			session.update(ctList.get(i));
    			break;
    		}
    		i++;
    	}
    	session.flush();
    	session.close();
    }
    
    /**
     * This method is used to delete data from the City database.
     * @param cityName This is the first parameter to deleteCityData method
     * @return Nothing.
     */
    public void deleteCityData(String cityName){
    	this.getCityData(0);
    	this.getStateData(0);
		Session session = sessionFactory.openSession();
    	int i=0;
    	while(i<ctList.size()){
    		if(ctList.get(i).getCity().equals(cityName)){
    			session.delete(ctList.get(i));
    			break;
    		}
    		i++;
    	}
    	session.flush();
    	session.close();
    }
}