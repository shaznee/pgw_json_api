package com.firstdata.globalgatewaye4.integrationtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.firstdata.globalgatewaye4.Environment;
import com.firstdata.globalgatewaye4.GlobalGatewayE4;

public class GlobalGatewayE4Test {
	GlobalGatewayE4 e4;
	
	// Move to GlobalGatewayE4
	@Test
	public void demoEnvironment() {
		this.e4 = new GlobalGatewayE4(Environment.DEMO, "gateway", "pass",
				"key", "hmac");
		assertTrue(e4.getUrl().contains(
				"api.demo.globalgatewaye4.firstdata.com"));
	}
}
