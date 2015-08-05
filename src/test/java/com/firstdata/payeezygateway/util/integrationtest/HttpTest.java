package com.firstdata.payeezygateway.util.integrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.PayeezyGateway;
import com.firstdata.payeezygateway.util.Http;

public class HttpTest {
	private PayeezyGateway e4;

	@Before
	public void createGateway() {
		this.e4 = new PayeezyGateway(Environment.DEMO, "",
				"", "", "");
	}
}
