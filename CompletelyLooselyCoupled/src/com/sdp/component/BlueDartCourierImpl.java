package com.sdp.component;

public class BlueDartCourierImpl implements ICourier {

	@Override
	public String deliver(String items, String address) {
		// TODO Auto-generated method stub
		return  items + " shipped to address " + address + " through blue dart";
	}

	

}
