package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.DemoValues.CreditCardNumber;
import com.firstdata.payeezygateway.DemoValues.TransactionAmount;
import com.firstdata.payeezygateway.models.CreditCardRequest;
import com.firstdata.payeezygateway.models.PayeezyGateway;
import com.firstdata.payeezygateway.models.Request;
import com.firstdata.payeezygateway.models.Response;
import com.firstdata.payeezygateway.models.SoftDescriptor;
import com.firstdata.payeezygateway.models.TransactionType;
import com.firstdata.payeezygateway.transactiontypes.EcommerceFlagType;
import com.google.gson.Gson;

public class SoftDescriptorTest {
	
	private PayeezyGateway e4;
	private CreditCardRequest request;
	private Response softDescriptorResponse;
	private Gson gson;
	private String requestJson;
	
	private CreditCardRequest populateRequestData(PayeezyGateway e4) {
		CreditCardRequest request = e4.getCreditCardRequest();

		request.amount(TransactionAmount.APPROVAL.amount)
			.cardholder_name("Java TestLibrary")
			.cc_expiry("0420")
			.cc_number(CreditCardNumber.VISA.number)
			.transaction_type(TransactionType.Purchase)
			.soft_descriptor(new SoftDescriptor()
				.city("Cordova")
				.country_code("USA")
				.dba_name("Test SoftMerchant")
				.mcc("1234")
				.merchant_contact_info("123-4567890")
				.mid("12345")
				.postal_code("90210")
				.region("US")
				.street("123 Main"));
		
		return request;
	}

	@Before
	public void createGateway() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.gson = e4.getGson();
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
		this.softDescriptorResponse = gson.fromJson(softDescriptorResponseString, Response.class);
	}
	
	@Test
	public void testRequestSoftDescriptorCity() {
		assertTrue(requestJson.contains("\"city\":\"Cordova\""));
	}
	
	@Test
	public void testRequestSoftDescriptorCountryCode() {
		assertTrue(requestJson.contains("\"country_code\":\"USA\""));
	}
	
	@Test
	public void testRequestSoftDescriptorDbaName() {
		assertTrue(requestJson.contains("\"dba_name\":\"Test SoftMerchant\""));
	}
	
	@Test
	public void testRequestSoftDescriptorMcc() {
		assertTrue(requestJson.contains("\"mcc\":\"1234\""));
	}
	
	@Test
	public void testRequestSoftDescriptorMerchantContactInfo() {
		assertTrue(requestJson.contains("\"merchant_contact_info\":\"123-4567890\""));
	}
	
	@Test
	public void testRequestSoftDescriptorMid() {
		assertTrue(requestJson.contains("\"mid\":\"12345\""));
	}
	
	@Test
	public void testRequestSoftDescriptorPostalCode() {
		assertTrue(requestJson.contains("\"postal_code\":\"90210\""));
	}
	
	@Test
	public void testRequestSoftDescriptorRegion() {
		assertTrue(requestJson.contains("\"region\":\"US\""));
	}
	
	@Test
	public void testRequestSoftDescriptorStreet() {	
		assertTrue(requestJson.contains("\"street\":\"123 Main\""));
	}
	
	private final String softDescriptorResponseString = "{" + 
			"\"transaction_tag\":\"123456789\"," + 
			"\"soft_descriptor\":" + 
				"{\"dba_name\":\"Test SoftMerchant\"," + 
				"\"street\":\"123 Main\"," + 
				"\"city\":\"Beverly Hills\"," + 
				"\"region\":\"US\"," +
				"\"postal_code\":\"90210\"," +
				"\"country_code\":\"USA\"," +
				"\"mid\":\"12345\"," + 
				"\"mcc\":\"67890\"," +
				"\"merchant_contact_info\":\"123-4567890\"}}";
	
	@Test 
	public void testSoftDescriptorResponseNotNull() {
		assertNotNull(softDescriptorResponse);
	}
	
	@Test
	public void testResponseSoftDescriptorClass() {
		assertEquals(softDescriptorResponse.soft_descriptor().getClass(), SoftDescriptor.class);
	}
	
	@Test
	public void testResponseSoftDescriptorDbaName() {
		assertEquals(softDescriptorResponse.soft_descriptor().getDba_name(),"Test SoftMerchant");
	}
	
	@Test
	public void testResponseSoftDescriptorStreet() {
		assertEquals(softDescriptorResponse.soft_descriptor().getStreet(),"123 Main");
	}
	
	@Test
	public void testResponseSoftDescriptorCity() {
		assertEquals(softDescriptorResponse.soft_descriptor().getCity(),"Beverly Hills");
	}
	
	@Test
	public void testResponseSoftDescriptorRegion() {
		assertEquals(softDescriptorResponse.soft_descriptor().getRegion(),"US");
	}
	
	@Test
	public void testResponseSoftDescriptorPostalCode() {
		assertEquals(softDescriptorResponse.soft_descriptor().getPostal_code(),"90210");
	}
	
	@Test
	public void testResponseSoftDescriptorCountryCode() {
		assertEquals(softDescriptorResponse.soft_descriptor().getCountry_code(),"USA");
	}
	
	@Test
	public void testResponseSoftDescriptorMid() {
		assertEquals(softDescriptorResponse.soft_descriptor().getMid(),"12345");
	}
	
	@Test
	public void testResponseSoftDescriptorMcc() {
		assertEquals(softDescriptorResponse.soft_descriptor().getMcc(),"67890");
	}
	
	@Test
	public void testResponseSoftDescriptorMerchantContactInfo() {
		assertEquals(softDescriptorResponse.soft_descriptor().getMerchant_contact_info(),"123-4567890");
	}
}
