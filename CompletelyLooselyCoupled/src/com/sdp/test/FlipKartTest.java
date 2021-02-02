package com.sdp.test;

import com.sdp.component.ICourier;
import com.sdp.service.FlipKart;
import com.sdp.util.ObjectFactory;

public class FlipKartTest {

	public static void main(String[] args) {
		ICourier courier = (ICourier )ObjectFactory.getInstance("Dtdc.class");
		//FlipKart flipKart = ObjectFactory.getInstance("")
	}
}
