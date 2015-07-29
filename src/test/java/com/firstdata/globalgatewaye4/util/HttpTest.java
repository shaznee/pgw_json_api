package com.firstdata.globalgatewaye4.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.globalgatewaye4.Environment;
import com.firstdata.globalgatewaye4.GlobalGatewayE4;
import com.firstdata.globalgatewaye4.util.Http;

public class HttpTest {
	private GlobalGatewayE4 e4;

	@Before
	public void createGateway() {
		this.e4 = new GlobalGatewayE4(Environment.DEMO, "",
				"", "", "");
	}
}
