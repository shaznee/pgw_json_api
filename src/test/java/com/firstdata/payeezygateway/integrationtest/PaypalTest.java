package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.DemoValues.CreditCardNumber;
import com.firstdata.payeezygateway.DemoValues.TransactionAmount;
import com.firstdata.payeezygateway.models.CreditCardRequest;
import com.firstdata.payeezygateway.models.PayeezyGateway;
import com.firstdata.payeezygateway.models.PaypalRequest;
import com.firstdata.payeezygateway.models.Request;
import com.firstdata.payeezygateway.models.TransactionType;
import com.firstdata.payeezygateway.transactiontypes.EcommerceFlagType;

public class PaypalTest {

	private PayeezyGateway e4;
	private CreditCardRequest request;
	private String requestJson;
	
	private CreditCardRequest populateRequestData(PayeezyGateway e4) {
		CreditCardRequest request = e4.getCreditCardRequest();
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
		this.e4 = new PayeezyGateway(Environment.DEMO, "exact_id",
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
