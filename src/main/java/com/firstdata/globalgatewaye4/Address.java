package com.firstdata.globalgatewaye4;

import com.google.gson.annotations.*;

/**
 * @author Steve Copous <steve.copous@firstdata.com>
 *
 */
public class Address {
	
	@Expose private String address1;
	@Expose private String address2;
	@Expose private String city;
	@Expose private String state;
	@Expose private String zip;
	@Expose private String country_code;
	@Expose private String phone_number;
	@Expose private PhoneType phone_type;
	
	/**
	 * @param address1 {@link #String[30]}
	 * @return {@link #Address}
	 */
	public Address address1(String address1) {
		this.address1 = address1;
		return this;
	}
	
	/**
	 * @param address2 {@link #String[28]}
	 * @return {@link #Address}
	 */
	public Address address2(String address2) {
		this.address2 = address2;
		return this;
	}
	
	/**
	 * @param city {@link #String[20]}
	 * @return {@link #Address}
	 */
	public Address city(String city) {
		this.city = city;
		return this;
	}
	
	/**
	 * @param state {@link #String[2]}
	 * @return {@link #Address}
	 */
	public Address state(String state) {
		this.state = state;
		return this;
	}
	
	/**
	 * @param zip {@link #String[10]}
	 * @return {@link #Address}
	 */
	public Address zip(String zip) {
		this.zip = zip;
		return this;
	}
	
	/**
	 * @param country_code {@link #String[2]}
	 * @return {@link #Address}
	 */
	public Address country_code(String country_code) {
		this.country_code = country_code;
		return this;
	}
	
	/**
	 * @param phone_number {@link #String[14]}
	 * @return {@link #Address}
	 */
	public Address phone_number(String phone_number) {
		this.phone_number = phone_number;
		return this;
	}
	
	/**
	 * @param phone_type {@link #PhoneType}
	 * @return {@link #Address}
	 */
	public Address phone_type(PhoneType phone_type) {
		this.phone_type = phone_type;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public PhoneType getPhone_type() {
		return phone_type;
	}
}
