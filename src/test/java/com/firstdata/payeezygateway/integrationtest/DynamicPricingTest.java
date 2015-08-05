package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.CreditCardRequest;
import com.firstdata.payeezygateway.DynamicCurrency;
import com.firstdata.payeezygateway.DynamicPricing;
import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.PayeezyGateway;
import com.firstdata.payeezygateway.TransactionType;
import com.firstdata.payeezygateway.DemoValues.CreditCardNumber;
import com.firstdata.payeezygateway.DemoValues.TransactionAmount;

public class DynamicPricingTest {
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
			.dynamic_pricing(new DynamicPricing()
					.opted_in(true)
					.rate_response_signature("123-1604561b0528eb909bcc38bb146f166ec6540ab3b7b326d6e5b990ec73c030f8"));
		
		return request;
	}
	
	@Before
	public void setupDynamicPricing() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "exact_id",
				"api_password", "key_id", "hmac_key");
		this.request = populateRequestData(e4);
		this.requestJson = request.toJson();
	}
	
	@Test
	public void testDynamicPricingContainer() {
		assertTrue(requestJson.contains("\"dynamic_pricing\":{"));
	}
	
	@Test
	public void testDynamicPricingOptedIn() {
		assertTrue(requestJson.contains("\"opted_in\":true"));
	}
	
	@Test
	public void testDynamicPricingRateReseponseSignature() {
		assertTrue(requestJson.contains("\"rate_response_signature\":\"123-1604561b0528eb909bcc38bb146f166ec6540ab3b7b326d6e5b990ec73c030f8\""));
	}
}
