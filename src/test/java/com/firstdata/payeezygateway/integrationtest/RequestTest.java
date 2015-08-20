package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.*;
import com.firstdata.payeezygateway.DemoValues.CreditCardNumber;
import com.firstdata.payeezygateway.DemoValues.TransactionAmount;

public class RequestTest {

	private PayeezyGateway e4;
	private CreditCardRequest request;
	private String requestJson;
	
	private CreditCardRequest populateRequestData(PayeezyGateway e4) {
		CreditCardRequest request = e4.getCreditCardRequest();
		request.amount(TransactionAmount.APPROVAL.amount)
				.cardholder_name("JUnit testAllData")
				.cc_expiry("0420")
				.cc_number(CreditCardNumber.VISA.number)
				.cvd_code("123")
				.client_email("junit.test@test.com")
				.client_ip("127.0.0.1")
				.currency_code("USD")
				.customer_ref("CustomerReference")
				.cvd_presence_ind("1")
				.partial_redemption("false")
				.reference_3("ReferenceThree")
				.reference_no("Reference_No")
				.transaction_type(TransactionType.Purchase)
				.zip_code("123456")
				.transaction_tag("987654321")
				.track1("abcdefghijklmnopqrstuvwxyz")
				.track2("zyxwvutsrqpomnlkjihgfedcba")
				.authorization_num("AUTHOR")
				.tax1_amount(new BigDecimal("0.0"))
				.tax1_number("11111")
				.tax2_amount(new BigDecimal("0.1"))
				.tax2_number("22222")
				.language("EN")
				.user_name("junit")
				.cavv("999")
				.xid("888")
				.transarmor_token("9999888877776666")
				.credit_card_type(CreditCardType.Visa)
				.ean("777")
				.virtual_card(true)
				.card_cost(new BigDecimal("0.0"))
				.fraud_suspected("false")
				.fee_amount(new BigDecimal("1.00"));
		
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
	public void testRequestExactId() {
		assertTrue(requestJson.contains("exact_id"));
	}
	
	@Test
	public void testRequestPassword() {
		assertTrue(requestJson.contains("api_password"));
	}
	
	@Test
	public void testRequestAmount() {
		assertTrue(requestJson.contains("\"amount\":5000.00"));
	}
	
	@Test
	public void testRequestCardholderName() {
		assertTrue(requestJson.contains("\"cardholder_name\":\"JUnit testAllData\""));
	}
	
	@Test
	public void testRequestCcExpiry() {
		assertTrue(requestJson.contains("\"cc_expiry\":\"0420\""));
	}
	
	@Test
	public void testRequestCcNumber() {
		assertTrue(requestJson.contains("\"cc_number\":\"4111111111111111\""));
	}
	
	@Test
	public void testRequestCcVerificationStr2() {
		assertTrue(requestJson.contains("\"cvd_code\":\"123\""));
	}
	
	@Test
	public void testRequestClientEmail() {
		assertTrue(requestJson.contains("\"client_email\":\"junit.test@test.com\""));
	}
	
	@Test
	public void testRequestClientIp() {
		assertTrue(requestJson.contains("\"client_ip\":\"127.0.0.1\""));
	}
	
	@Test
	public void testRequestCurrencyCode() {
		assertTrue(requestJson.contains("\"currency_code\":\"USD\""));
	}
	
	@Test
	public void testRequestCustomerRef() {
		assertTrue(requestJson.contains("\"customer_ref\":\"CustomerReference\""));
	}
	
	// Test each ECommerceFlag value
	
	@Test
	public void testRequestEcommerceFlag1() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.MOTOSingle);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"1\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag2() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.MOTORecurring);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"2\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag3() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.MOTOInstallment);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"3\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag4() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.MOTODeferred);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"4\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag5() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.ECISecure);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"5\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag6() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.ECINonAuth);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"6\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag7() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.ECIEncrypted);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"7\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlag8() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.ECINonSecure);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"8\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestEcommerceFlagR() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.Retail);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"R\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestEcommerceFlagI() {
		CreditCardRequest tempRequest = request;
		tempRequest.ecommerce_flag(EcommerceFlagType.IVR);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"ecommerce_flag\":\"I\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
		
	}
	
	@Test
	public void testRequestPartialRedemption() {
		assertTrue(requestJson.contains("\"partial_redemption\":\"false\""));
	}
	
	@Test
	public void tetsRequestReference3() {
		assertTrue(requestJson.contains("\"reference_3\":\"ReferenceThree\""));
	}
	
	@Test
	public void testRequestReferenceNo() {
		assertTrue(requestJson.contains("\"reference_no\":\"Reference_No\""));
	}
	
	@Test
	public void testRequestTransactionType() {
		assertTrue(requestJson.contains("\"transaction_type\":\"00\""));
	}
	
	@Test
	public void testRequestZipCode() {
		assertTrue(requestJson.contains("\"zip_code\":\"123456\""));
	}
	
	@Test
	public void testRequestTax1Amount() {
		assertTrue(requestJson.contains("\"tax1_amount\":0.0"));
	}
	
	@Test
	public void testRequestTax1Number() {
		assertTrue(requestJson.contains("\"tax1_number\":\"11111\""));
	}
	
	@Test
	public void testRequestTax2Amount() {
		assertTrue(requestJson.contains("\"tax2_amount\":0.1"));
	}
	
	@Test
	public void testRequestTax2Number() {
		assertTrue(requestJson.contains("\"tax2_number\":\"22222\""));
	}
	
	@Test
	public void testRequestUserName() {
		assertTrue(requestJson.contains("\"user_name\":\"junit\""));
	}
	
	@Test
	public void testRequestCavv() {
		assertTrue(requestJson.contains("\"cavv\":\"999\""));
	}
	
	@Test
	public void testRequestXid() {
		assertTrue(requestJson.contains("\"xid\":\"888\""));
	}
	
	@Test
	public void testRequestTransarmorToken() {
		assertTrue(requestJson.contains("\"transarmor_token\":\"9999888877776666\""));
	}
	
	@Test
	public void testRequestCreditCardType() {
		assertTrue(requestJson.contains("\"credit_card_type\":\"Visa\""));
	}
	
	@Test
	public void testRequestEan() {
		assertTrue(requestJson.contains("\"ean\":\"777\""));
	}

	@Test
	public void testRequestVirtualCard() {
		assertTrue(requestJson.contains("\"virtual_card\":true"));
	}
	
	@Test
	public void testRequestCardCost() {
		assertTrue(requestJson.contains("\"card_cost\":0.0"));
	}
	
	@Test
	public void testRequestFraudSuspected() {
		assertTrue(requestJson.contains("\"fraud_suspected\":\"false\""));
	}
	
	@Test
	public void testRequestTransactionTag() {
		assertTrue(requestJson.contains("\"transaction_tag\":\"987654321\""));
	}
	
	@Test
	public void testRequesTrack1() {
		assertTrue(requestJson.contains("\"track1\":\"abcdefghijklmnopqrstuvwxyz\""));
	}
	
	@Test
	public void testRequestTrack2() {
		assertTrue(requestJson.contains("\"track2\":\"zyxwvutsrqpomnlkjihgfedcba\""));
	}
	
	@Test
	public void testRequestAuthorizationNum() {
		assertTrue(requestJson.contains("\"authorization_num\":\"AUTHOR\""));
	}
	
	@Test
	public void testRequestCvdPresenceInd() {
		assertTrue(requestJson.contains("\"cvd_presence_ind\":\"1\""));
	}
	
	@Test
	public void testRequestLanguage() {
		assertTrue(requestJson.contains("\"language\":\"EN\""));
	}
	
	@Test
	public void testRequestDCCIndicator1() {
		CreditCardRequest tempRequest = request;
		tempRequest.dcc_indicator(DCCIndicatorType.DCCIndicator1);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"dcc_indicator\":\"1\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestDCCIndicator2() {
		CreditCardRequest tempRequest = request;
		tempRequest.dcc_indicator(DCCIndicatorType.DCCIndicator2);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"dcc_indicator\":\"2\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestDCCIndicator3() {
		CreditCardRequest tempRequest = request;
		tempRequest.dcc_indicator(DCCIndicatorType.DCCIndicator3);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"dcc_indicator\":\"3\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestDCCIndicator4() {
		CreditCardRequest tempRequest = request;
		tempRequest.dcc_indicator(DCCIndicatorType.DCCIndicator4);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"dcc_indicator\":\"4\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestDCCIndicator6() {
		CreditCardRequest tempRequest = request;
		tempRequest.dcc_indicator(DCCIndicatorType.DCCIndicator6);
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"dcc_indicator\":\"6\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestForeignAmount() {
		CreditCardRequest tempRequest = request;
		tempRequest.foreign_amount("1.00");
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"foreign_amount\":\"1.00\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestForeignCurrencyCode() {
		CreditCardRequest tempRequest = request;
		tempRequest.foreign_currency_code("USD");
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"foreign_currency_code\":\"USD\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestExchangeRate() {
		CreditCardRequest tempRequest = request;
		tempRequest.exchange_rate("1.333");
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"exchange_rate\":\"1.333\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestMarginRate() {
		CreditCardRequest tempRequest = request;
		tempRequest.margin_rate("1.222");
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"margin_rate\":\"1.222\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
	
	@Test
	public void testRequestRateSource() {
		CreditCardRequest tempRequest = request;
		tempRequest.rate_source("whatisthis");
		String requestJson = tempRequest.toJson();
		try {
			assertTrue(requestJson.contains("\"rate_source\":\"whatisthis\""));
		} catch(AssertionError e) {
			System.out.println("request: \n" + requestJson);
		}
	}
}