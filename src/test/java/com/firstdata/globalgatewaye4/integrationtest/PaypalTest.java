package com.firstdata.globalgatewaye4.integrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.globalgatewaye4.EcommerceFlagType;
import com.firstdata.globalgatewaye4.Environment;
import com.firstdata.globalgatewaye4.GlobalGatewayE4;
import com.firstdata.globalgatewaye4.PaypalRequest;
import com.firstdata.globalgatewaye4.Request;
import com.firstdata.globalgatewaye4.TransactionType;
import com.firstdata.globalgatewaye4.DemoValues.CreditCardNumber;
import com.firstdata.globalgatewaye4.DemoValues.TransactionAmount;

public class PaypalTest {

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
			.paypal_transaction_details(new PaypalRequest()
				.authorization("auth")
				.correlation_id("123456789")
				.gross_amount_currency_id("840")
				.message("approved")
				.payer_id("9876")
				.success("successful")
				.timestamp("1111111"));		
		
		return request;
	}

	@Before
	public void createGateway() {
		this.e4 = new GlobalGatewayE4(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
	}

	@Test
	public void testPaypalRequestAuthorization() {
		assertTrue(requestJson.contains("\"authorization\":\"auth\""));
	}
	
	@Test
	public void testPaypalRequestPayerId() {
		assertTrue(requestJson.contains("\"payer_id\":\"9876\""));
	}
	
	@Test
	public void testPaypalRequestCorrelationId() {
		assertTrue(requestJson.contains("\"correlation_id\":\"123456789\""));
	}
	
	@Test
	public void testPaypalRequestGrossAmountCurrencyId() {
		assertTrue(requestJson.contains("\"gross_amount_currency_id\":\"840\""));
	}
	
	@Test
	public void testPaypalRequestMessage() {
		assertTrue(requestJson.contains("\"message\":\"approved\""));
	}
	
	@Test
	public void testPaypalRequestSuccess() {
		assertTrue(requestJson.contains("\"success\":\"successful\""));
	}
	
	@Test
	public void testPaypalRequestTimestamp() {
		assertTrue(requestJson.contains("\"timestamp\":\"1111111\""));
	}
}
