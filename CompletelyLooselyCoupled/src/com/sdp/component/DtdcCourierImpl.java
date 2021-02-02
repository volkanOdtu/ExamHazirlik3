package com.sdp.component;

public class DtdcCourierImpl implements ICourier {

	@Override
	public String deliver(String items, String address) {
		// TODO Auto-generated method stub
		return  items + " shipped to address " + address + " through Dtdc";
	}

}
