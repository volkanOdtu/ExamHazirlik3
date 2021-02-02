package com.sdp.util;

import java.util.Properties;


public class ObjectFactory {

	private static Properties props;
	
	static {
		props = new Properties();
		
		try {
			props.load(ObjectFactory.class.getClassLoader().getResourceAsStream("com//sdp//common//app.properties"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
	
	
	
		//reflection ile class instance  olusturuyoruz
	  public static Object getInstance(String logicalClassName) {
		  Object obj = null;
		  String originalClassName = props.getProperty(logicalClassName);
		  
		  try {
			  obj=Class.forName(originalClassName).newInstance();
			}catch (InstantiationException e) {		        
		        e.printStackTrace();
		    } catch (IllegalAccessException e) {		         
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {		         
		        e.printStackTrace();
		    }

		  return obj;
	  }
	  
	}

