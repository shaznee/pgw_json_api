package com.firstdata.payeezygateway.integrationtest;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.models.PayeezyGateway;
import com.firstdata.payeezygateway.models.Response;
import com.google.gson.Gson;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ResponseTest {
	
	private PayeezyGateway e4;
	private Gson gson;
	private Response response;
	private Response teleCheckResponse;

	@Before
	public void createGateway() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "gatewayid", "password", "keyid", "hmackey");
		this.gson = e4.getGson();
		this.response = gson.fromJson(responseString, Response.class);
		this.teleCheckResponse = gson.fromJson(telecheckResponseString, Response.class);		
	}
	
	private final String responseString = "{" +
			"\"merchant_city\":\"SampleCity\"," +
			"\"merchant_name\":\"IT DEMOXXXX\"," +
			"\"client_ip\":\"127.0.0.1\"," +
			"\"sequence_no\":\"000160\"," +
			"\"currency_code\":\"USD\"," +
			"\"retrieval_ref_no\":\"5762723\"," +
			"\"transaction_approved\":true," +
			"\"merchant_country\":\"United States\"," +
			"\"bank_message\":\"Approved\"," +
			"\"credit_card_type\":\"Visa\"," +
			"\"cvv2\":\"I\"," +
			"\"user_name\":\"SteveTestUser\"," +
			"\"amount\":5000.0," +
			"\"bank_resp_code\":\"100\"," +
			"\"transaction_error\":false," +
			"\"cvd_presence_ind\":\"0\"," +
			"\"transarmor_token\":\"9847992778771111\"," +
			"\"partial_redemption\":\"0\"," +
			"\"merchant_address\":\"123 Main Street\"," +
			"\"gateway_id\":\"AD1111-00\"," +
			"\"ctr\":\"\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d TRANSACTION RECORD \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\nL2PES FD DEMO0563\n7000 Goodlett Farms Pkwy\nCordova, TN 38016\nUnited States\n\n\nTYPE: Auth Only\n\nACCT: Visa  $ 5,000.00 USD\n\nCARDHOLDER NAME : Java Json Tester\nCARD NUMBER     : ############1111\nDATE/TIME       : 23 Jan 14 10:59:33\nREFERENCE #     :  000160 T\nAUTHOR. #       : ET183693\nTRANS. REF.     : \n\n    Approved - Thank You 100\n\n\nPlease retain this copy for your records.\n\nCardholder will pay above amount to card\nissuer pursuant to cardholder agreement.\n\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\"," +
			"\"cardholder_name\":\"Java Json Tester\"," +
			"\"exact_message\":\"Transaction Normal\"," +
			"\"transaction_type\":\"05\"," +
			"\"merchant_province\":\"California\"," +
			"\"cc_expiry\":\"0420\"," +
			"\"exact_resp_code\":\"00\"," +
			"\"merchant_postal\":\"90210\"," +
			"\"transaction_tag\":\"16414046\"," +
			"\"authorization_num\":\"ET183693\"}";
	
	@Test
	public void testCreditCardResponseNotNull() {
		assertNotNull(response);
	}
	
	@Test
	public void testCheckResponseNotNull() {
		assertNotNull(teleCheckResponse);
	}

	@Test
	public void testCreditCardResponseMerchantCity() {
		assertEquals(response.merchant_city(),"SampleCity");
	}
	
	@Test
	public void testCreditCardResponseMerchantName() {
		assertEquals(response.merchant_name(),"IT DEMOXXXX");
	}
	
	@Test
	public void testCreditCardResponseClientIP() {
		assertEquals(response.client_ip(),"127.0.0.1");
	}
	
	@Test
	public void testCreditCardResponseSequenceNo() {
		assertEquals(response.sequence_no(),"000160");
	}
	
	@Test
	public void testCreditCardResponseCurrencyCode() {
		assertEquals(response.currency_code(),"USD");
	}
	
	@Test
	public void testCreditCardResponseRetrievalRefNo() {
		assertEquals(response.retrieval_ref_no(),"5762723");
	}
	
	@Test
	public void testCreditCardResponseTransactionApproved() {
		assertEquals(response.transaction_approved(),true);
	}
	
	@Test
	public void testCreditCardResponseMerchantCountry() {
		assertEquals(response.merchant_country(),"United States");
	}
	
	@Test
	public void testCreditCardResponseBankMessage() {
		assertEquals(response.bank_message(),"Approved");
	}
	
	@Test
	public void testCreditCardResponseTransactionError() {
		assertEquals(response.transaction_error(),false);
	}
	
	@Test
	public void testCreditCardResponseCvdPresenceInd() {
		assertEquals(response.cvd_presence_ind(),"0");
	}
	
	@Test
	public void testCreditCardResponseTransarmorToken() {
		assertEquals(response.transarmor_token(),"9847992778771111");
	}
	
	@Test
	public void testCreditCardResponsePartialRedemption() {
		assertEquals(response.partial_redemption(),"0");
	}
	
	@Test
	public void testCreditCardResponseMerchantAddress() {
		assertEquals(response.merchant_address(),"123 Main Street");
	}
	
	@Test
	public void testCreditCardResponseGatewayID() {
		assertEquals(response.gateway_id(),"AD1111-00");
	}
	
	@Test
	public void testCreditCardResponseCTR() {
		assertTrue(response.ctr().contains("TRANSACTION RECORD"));
	}
	
	@Test
	public void testCreditCardResponseCardholderName() {
		assertEquals(response.cardholder_name(),"Java Json Tester");
	}

	@Test
	public void testCreditCardResponseExactMessage() {
		assertEquals(response.exact_message(),"Transaction Normal");
	}
	
	@Test
	public void testCreditCardResponseTransactionType() {
		assertEquals(response.transaction_type(),"05");
	}
	
	@Test
	public void testCreditCardResponseMerchantProvince() {
		assertEquals(response.merchant_province(),"California");
	}

	@Test
	public void testCreditCardResponseCCExpiry() {
		assertEquals(response.cc_expiry(),"0420");
	}

	@Test
	public void testCreditCardResponseExactRespCode() {
		assertEquals(response.exact_resp_code(),"00");
	}
	
	@Test
	public void testCreditCardResponseMerchantPostal() {
		assertEquals(response.merchant_postal(),"90210");
	}
	
	@Test
	public void testCreditCardResponseTransactionTag() {
		assertEquals(response.transaction_tag(),"16414046");
	}
	
	@Test
	public void testCreditCardResponseAuthorizationNum() {
		assertEquals(response.authorization_num(),"ET183693");
	}
	
	private final String telecheckResponseString = "{" +
			"\"check_number\":\"123\"," +
			"\"check_type\":\"P\"," +
			"\"bank_id\":\"11111\"}";
	
	@Test
	public void testCheckResponseCheckNumber() {
		assertEquals(teleCheckResponse.check_number(),"123");
	}
	
	@Test
	public void testCheckResponseCheckType() {
		assertEquals(teleCheckResponse.check_type(), "P");
	}
	
	@Test
	public void testCheckResponseBankId() {
		assertEquals(teleCheckResponse.bank_id(),"11111");
	}	
	


}
