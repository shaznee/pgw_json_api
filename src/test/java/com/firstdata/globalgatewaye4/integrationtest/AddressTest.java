package com.firstdata.globalgatewaye4.integrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.globalgatewaye4.Address;
import com.firstdata.globalgatewaye4.Environment;
import com.firstdata.globalgatewaye4.GlobalGatewayE4;
import com.firstdata.globalgatewaye4.PhoneType;
import com.firstdata.globalgatewaye4.Request;
import com.firstdata.globalgatewaye4.TransactionType;
import com.firstdata.globalgatewaye4.DemoValues.CreditCardNumber;
import com.firstdata.globalgatewaye4.DemoValues.TransactionAmount;

public class AddressTest {

	private GlobalGatewayE4 e4;
	private Request request;
	private String requestJson;
	
	private Request populateRequestData(GlobalGatewayE4 e4) {
		Request request = e4.getRequest();
		request.amount(TransactionAmount.APPROVAL.amount)
			.cardholder_name("Java TestLibrary")
			.cc_expiry("0420")
			.cc_number(CreditCardNumber.VISA.number)
			.transaction_type(TransactionType.Purchase)
			.address(new Address()
				.address1("123 Main")
				.address2("Apt 9")
				.city("Cityville")
				.state("CA")
				.zip("90210")
				.country_code("US")
				.phone_number("5558675309")
				.phone_type(PhoneType.Home));
		
		return request;
	}
	
	@Before
	public void setupAddress() {
		this.e4 = new GlobalGatewayE4(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
	}
	
	@Test
	public void testAddressContainer() {
		assertTrue(requestJson.contains("\"address\":{"));
	}
	
	@Test
	public void testAddressAddress1() {	
		assertTrue(requestJson.contains("\"address1\":\"123 Main\","));
	}
	
	@Test
	public void testAddressAddress2() {	
		assertTrue(requestJson.contains("\"address2\":\"Apt 9\""));
	}
	
	@Test
	public void testAddressCity() {
		assertTrue(requestJson.contains("\"city\":\"Cityville\","));
	}

	@Test
	public void testAddressState() {
		assertTrue(requestJson.contains("\"state\":\"CA\","));
	}
	
	@Test
	public void testAddressZip() {
		assertTrue(requestJson.contains("\"zip\":\"90210\","));
	}
	
	@Test
	public void testAddressCountryCode() {
		assertTrue(requestJson.contains("\"country_code\":\"US\","));
	}
	
	@Test
	public void testAddressPhoneNumber() {
		assertTrue(requestJson.contains("\"phone_number\":\"5558675309\","));
	}
	
	@Test
	public void testAddressPhoneType() {
		assertTrue(requestJson.contains("\"phone_type\":\"H\""));
	}
}
