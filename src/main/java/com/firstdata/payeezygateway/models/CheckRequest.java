package com.firstdata.payeezygateway.models;

import java.math.BigDecimal;

import com.firstdata.payeezygateway.Configuration;
import com.firstdata.payeezygateway.transactiontypes.CheckType;
import com.firstdata.payeezygateway.transactiontypes.CustomerIdType;
import com.firstdata.payeezygateway.transactiontypes.ReleaseType;
import com.firstdata.payeezygateway.util.Hmac;
import com.firstdata.payeezygateway.util.Http;
import com.google.gson.*;
import com.google.gson.annotations.*;

import javax.validation.constraints.*;

import org.apache.commons.lang.Validate;

/**
 * @author Steve Copous <steve.copous@firstdata.com>
 * <p>INTENDED FOR DEMONSTRATION PURPOSES ONLY.  NOT FOR PRODUCTION USE.</p>
 */
public class CheckRequest extends Request<CheckRequest> {
	@Expose private String check_number;
	@Expose	private CheckType check_type;
	@Expose	private String account_number;
	@Expose	private String bank_id;
	@Expose	private CustomerIdType customer_id_type;
	@Expose	private String customer_id_number;
	@Expose	private ReleaseType release_type;
	@Expose	private BigDecimal gift_card_amount;
	@Expose	private String date_of_birth;
	@Expose	private Boolean vip;
	@Expose	private String registration_no;
	@Expose	private String registration_date;
	@Expose	private String clerk_id;
	@Expose	private String device_id;
	@Expose	private String micr;

	/**
	 * Constructor for a new GGe4 transaction request.
	 * 
	 * @param e4
	 *            GlobalGatewayE4 object to be used for the request
	 * @param configuration
	 *            Configuration ojbect to be used for the request
	 */
	public CheckRequest(PayeezyGateway e4, Configuration configuration) {
		super(e4, configuration);
	}

	/**
	 * @return the check_number
	 */
	public CheckRequest check_number(String check_number) {
		this.check_number = check_number;
		return this;
	}

	/**
	 * @return the check_type
	 */
	public CheckRequest check_type(CheckType check_type) {
		this.check_type = check_type;
		return this;
	}

	/**
	 * @return the account_number
	 */
	public CheckRequest account_number(String account_number) {
		this.account_number = account_number;
		return this;
	}

	/**
	 * @return the bank_id
	 */
	public CheckRequest bank_id(String bank_id) {
		this.bank_id = bank_id;
		return this;
	}

	/**
	 * @return the customer_id_type
	 */
	public CheckRequest customer_id_type(CustomerIdType customer_id_type) {
		this.customer_id_type = customer_id_type;
		return this;
	}

	/**
	 * @return the customer_id_number
	 */
	public CheckRequest customer_id_number(String customer_id_number) {
		this.customer_id_number = customer_id_number;
		return this;
	}

	/**
	 * @return the release_type
	 */
	public CheckRequest release_type(ReleaseType release_type) {
		this.release_type = release_type;
		return this;
	}

	/**
	 * @return the gift_card_amount
	 */
	public CheckRequest gift_card_amount(BigDecimal gift_card_amount) {
		this.gift_card_amount = gift_card_amount;
		return this;
	}

	/**
	 * @return the date_of_birth
	 */
	public CheckRequest date_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
		return this;
	}

	/**
	 * @return the vip
	 */
	public CheckRequest vip(Boolean vip) {
		this.vip = vip;
		return this;
	}

	/**
	 * @return the registration_no
	 */
	public CheckRequest registration_no(String registration_no) {
		this.registration_no = registration_no;
		return this;
	}

	/**
	 * @return the registration_date
	 */
	public CheckRequest registration_date(String registration_date) {
		this.registration_date = registration_date;
		return this;
	}
	
	public CheckRequest clerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
		return this;
	}

	/**
	 * @return the device_id
	 */
	public CheckRequest device_id(String device_id) {
		this.device_id = device_id;
		return this;
	}

	/**
	 * @return the micr
	 */
	public CheckRequest micr(String micr) {
		this.micr = micr;
		return this;
	}


	
	
}
