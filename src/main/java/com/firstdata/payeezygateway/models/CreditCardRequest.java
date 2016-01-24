package com.firstdata.payeezygateway.models;

import com.firstdata.payeezygateway.Configuration;

public class CreditCardRequest extends Request<CreditCardRequest> {

	public CreditCardRequest(PayeezyGateway e4, Configuration configuration) {
		super(e4, configuration);
	}
}
