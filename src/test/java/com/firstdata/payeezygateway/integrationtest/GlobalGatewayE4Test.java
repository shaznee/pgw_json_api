package com.firstdata.payeezygateway.integrationtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.PayeezyGateway;

public class GlobalGatewayE4Test {
	PayeezyGateway e4;
	
	// Move to GlobalGatewayE4
	@Test
	public void demoEnvironment() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "gateway", "pass",
				"key", "hmac");
		assertTrue(e4.getUrl().contains(
				"api.demo.globalgatewaye4.firstdata.com"));
	}
}
