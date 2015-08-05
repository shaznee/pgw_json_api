package com.firstdata.payeezygateway.util.integrationtest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.PayeezyGateway;
import com.firstdata.payeezygateway.util.Hmac;

public class HmacTest {
	private PayeezyGateway e4;
	private Hmac hmac;

	@Before
	public void createGateway() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "test",
				"test", "8198", "nD9bv4aEDMFtLeW7_8FQpuz5Ty6CVmie");
		try {
			this.hmac = new Hmac(e4, "hello world");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testContentSha1() {
		String contentSha = hmac.getContentSha1();
		assertEquals("2aae6c35c94fcfb415dbe95f408b9ce91ee846ed", contentSha);
	}
}
