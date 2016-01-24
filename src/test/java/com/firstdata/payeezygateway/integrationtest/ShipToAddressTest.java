package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.models.CreditCardRequest;
import com.firstdata.payeezygateway.models.LevelThree;
import com.firstdata.payeezygateway.models.PayeezyGateway;
import com.firstdata.payeezygateway.models.Request;
import com.firstdata.payeezygateway.models.Response;
import com.firstdata.payeezygateway.models.ShipToAddress;
import com.google.gson.Gson;

public class ShipToAddressTest {
	private PayeezyGateway e4;
	private Gson gson;
	private CreditCardRequest request;
	private ShipToAddress shipToAddressResponse;
	private String requestJson;
	
	private CreditCardRequest populateRequestData(PayeezyGateway e4) {
		CreditCardRequest request = e4.getCreditCardRequest();
		LevelThree levelThree = new LevelThree();
		
		levelThree
			.ship_to_address(new ShipToAddress()
				.address_1("123 Main")
				.city("Lackland")
				.country("USA")
				.customer_number("98765")
				.email("test.customer@test.com")
				.name("Test Customer")
				.phone("123-456-7890")
				.state("GA")
				.zip("61135"));
		
		request.level3(levelThree);
		
		return request;
	}

	@Before
	public void createGateway() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.gson = e4.getGson();
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
		Response response = gson.fromJson(shipToAddressResponseString, Response.class);
		this.shipToAddressResponse = response.level3().getShip_to_address();
	}
	
	@Test
	public void testRequestShipToAddressAddress1() {
		assertTrue(requestJson.contains("\"address_1\":\"123 Main\""));
	}
	
	@Test
	public void testRequestShipToAddressCity() {
		assertTrue(requestJson.contains("\"city\":\"Lackland\""));
	}
	
	@Test
	public void testRequestShipToAddressState() {
		assertTrue(requestJson.contains("\"state\":\"GA\""));
	}
	
	@Test
	public void testRequestShipToAddressZip() {
		assertTrue(requestJson.contains("\"zip\":\"61135\""));
	}
	
	@Test
	public void testRequestShipToAddressCountry() {
		assertTrue(requestJson.contains("\"country\":\"USA\""));
	}
	
	@Test
	public void testRequestShipToAddressCustomerNumber() {
		assertTrue(requestJson.contains("\"customer_number\":\"98765\""));
	}
	
	@Test
	public void testRequestShipToAddressEmail() {
		assertTrue(requestJson.contains("\"email\":\"test.customer@test.com\""));
	}
	
	@Test
	public void testRequestShipToAddressName() {
		assertTrue(requestJson.contains("\"name\":\"Test Customer\""));
	}
	
	@Test
	public void testRequestShipToAddressPhone() {
		assertTrue(requestJson.contains("\"phone\":\"123-456-7890\""));
	}	

	private final String shipToAddressResponseString = "{" + 
			"\"level3\":{" + 
				"\"ship_to_address\":" + 
					"{\"name\":\"Test Customer\"," +  
					"\"address_1\":\"123 Main\"," + 
					"\"city\":\"Lackland\"," + 
					"\"state\":\"GA\"," + 
					"\"zip\":\"61135\"," + 
					"\"country\":\"USA\"," + 
					"\"phone\":\"123-456-7890\"," + 
					"\"email\":\"test.customer@test.com\"," + 
					"\"customer_number\":\"98765\"}" + 
				"}}";

	@Test
	public void testResponseShipToAddressName() {
		assertEquals(shipToAddressResponse.getName(),"Test Customer");
	}
	
	@Test
	public void testResponseShipToAddressAddress1() {
		assertEquals(shipToAddressResponse.getAddress_1(),"123 Main");
	}
	
	@Test
	public void testResponseShipToAddressCity() {
		assertEquals(shipToAddressResponse.getCity(),"Lackland");
	}
	
	@Test
	public void testResponseShipToAddressState() {
		assertEquals(shipToAddressResponse.getState(),"GA");
	}
	
	@Test
	public void testResponseShipToAddressZip() {
		assertEquals(shipToAddressResponse.getZip(),"61135");
	}
	
	@Test
	public void testResponseShipToAddressCountry() {
		assertEquals(shipToAddressResponse.getCountry(),"USA");
	}
	
	@Test
	public void testResponseShipToAddressPhone() {
		assertEquals(shipToAddressResponse.getPhone(),"123-456-7890");
	}
	
	@Test
	public void testResponseShipToAddressEmail() {
		assertEquals(shipToAddressResponse.getEmail(),"test.customer@test.com");
	}
	
	@Test
	public void testResponseShipToAddressCustomerNumber() {
		assertEquals(shipToAddressResponse.getCustomer_number(),"98765");
	}
}
	
