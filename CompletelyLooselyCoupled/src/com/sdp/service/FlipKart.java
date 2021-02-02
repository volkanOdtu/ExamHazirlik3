package com.sdp.service;

import com.sdp.component.ICourier;

//Component class
public class FlipKart {

	private ICourier courier;
	public void setCourier(ICourier courier) {
		this.courier = courier;
	}
	public void shopping(String items ,String address) {
		String status = courier.deliver(items, address);
		System.out.println(status);
	}
}
