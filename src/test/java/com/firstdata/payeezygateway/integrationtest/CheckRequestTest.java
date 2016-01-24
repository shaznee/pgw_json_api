package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.models.CheckRequest;
import com.firstdata.payeezygateway.models.PayeezyGateway;
import com.firstdata.payeezygateway.transactiontypes.CheckType;
import com.firstdata.payeezygateway.transactiontypes.CustomerIdType;
import com.firstdata.payeezygateway.transactiontypes.ReleaseType;

public class CheckRequestTest {
	private PayeezyGateway e4;
	private CheckRequest request;
	private String requestJson;
	
	private CheckRequest populateRequestData(PayeezyGateway e4) {
		CheckRequest request = e4.getCheckRequest();
		request
			.account_number("123456789")
			.amount(new BigDecimal("1.00"))
			.bank_id("12345")
			.cardholder_name("TeleCheck Customer")
			.check_number("1234")
			.check_type(CheckType.PersonalCheck)
			.clerk_id("ACLERK")
			.customer_id_type(CustomerIdType.driversLicense)
			.customer_id_number("123-45-6789")
			.date_of_birth("01012014")
			.device_id("AAAAAAAAAA")
			.gift_card_amount(new BigDecimal("2.00"))
			.micr("NOTAMICRVALUE")
			.registration_date("01012013")
			.registration_no("1234567")
			.release_type(ReleaseType.HomeDelivery)
			.vip(true);
		
		return request;
	}

	@Before
	public void createGateway() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
	}
	
	@Test
	public void testCheckRequestAccountNumber() {
		assertTrue(requestJson.contains("\"account_number\":\"123456789\""));
	}
	
	@Test
	public void testCheckRequestAmount() {
		assertTrue(requestJson.contains("\"amount\":1.00"));
	}
	
	@Test
	public void testCheckRequestBankId() {
		assertTrue(requestJson.contains("\"bank_id\":\"12345\""));
	}
	
	@Test
	public void testCheckRequestCardholderName() {
		assertTrue(requestJson.contains("\"cardholder_name\":\"TeleCheck Customer\""));
	}
	
	@Test
	public void testCheckRequestCheckNumber() {
		assertTrue(requestJson.contains("\"check_number\":\"1234\""));
	}
	
	@Test
	public void testCheckRequestCheckType() {
		assertTrue(requestJson.contains("\"check_type\":\"P\""));
	}
	
	@Test
	public void testCheckRequestClerkId() {
		assertTrue(requestJson.contains("\"clerk_id\":\"ACLERK\""));
	}
	
	@Test
	public void testCheckRequestCustomerIdType() {
		assertTrue(requestJson.contains("\"customer_id_type\":\"0\""));
	}
	
	@Test
	public void testCheckRequestCustomerIdNumber() {
		assertTrue(requestJson.contains("\"customer_id_number\":\"123-45-6789\""));
	}
	
	@Test
	public void testCheckRequestDateOfBirth() {
		assertTrue(requestJson.contains("\"date_of_birth\":\"01012014\""));
	}
	
	@Test
	public void testCheckRequestDeviceId() {
		assertTrue(requestJson.contains("\"device_id\":\"AAAAAAAAAA\""));
	}
	
	@Test
	public void testCheckRequestGiftCardAmount() {
		assertTrue(requestJson.contains("\"gift_card_amount\":2.00"));
	}
	
	@Test
	public void testCheckRequestMicr() {
		assertTrue(requestJson.contains("\"micr\":\"NOTAMICRVALUE\""));
	}
	
	@Test
	public void testCheckRequestRegistrationDate() {
		assertTrue(requestJson.contains("\"registration_date\":\"01012013\""));
	}
	
	@Test
	public void testCheckRequestRegistrationNo() {
		assertTrue(requestJson.contains("\"registration_no\":\"1234567\""));
	}
	
	@Test
	public void testCheckRequestReleaseType() {
		assertTrue(requestJson.contains("\"release_type\":\"D\""));
	}
	
	@Test
	public void testCheckRequestVip() {
		assertTrue(requestJson.contains("\"vip\":true"));
	}	
}
