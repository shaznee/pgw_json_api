package com.firstdata.globalgatewaye4.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.firstdata.globalgatewaye4.Environment;
import com.firstdata.globalgatewaye4.GlobalGatewayE4;
import com.firstdata.globalgatewaye4.util.Hmac;

public class HmacTest {
	private GlobalGatewayE4 e4;
	private Hmac hmac;

	@Before
	public void createGateway() {
		this.e4 = new GlobalGatewayE4(Environment.DEMO, "test",
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
