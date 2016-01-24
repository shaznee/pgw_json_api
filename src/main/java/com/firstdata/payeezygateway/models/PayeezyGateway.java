package com.firstdata.payeezygateway.models;

import org.apache.commons.lang.Validate;

import com.google.gson.*;
import com.firstdata.payeezygateway.Configuration;
import com.firstdata.payeezygateway.Environment;
import com.firstdata.payeezygateway.serializers.*;
import com.firstdata.payeezygateway.transactiontypes.CheckType;
import com.firstdata.payeezygateway.transactiontypes.CreditCardType;
import com.firstdata.payeezygateway.transactiontypes.CustomerIdType;
import com.firstdata.payeezygateway.transactiontypes.DCCIndicatorType;
import com.firstdata.payeezygateway.transactiontypes.EcommerceFlagType;
import com.firstdata.payeezygateway.transactiontypes.PhoneType;
import com.firstdata.payeezygateway.transactiontypes.ReleaseType;
import com.firstdata.payeezygateway.transactiontypes.TaxType;
import com.firstdata.payeezygateway.util.*;

/**
 * 
 * @author Steve Copous <steve.copous@firstdata.com>
 * @since 2013-08-01
 *
 * <p>INTENDED FOR DEMONSTRATION PURPOSES ONLY.  NOT FOR PRODUCTION USE.</p>
 * <p>This is the primary class for interfacing with Global Gateway E4 API.</p>
 * <p>Quick Start:</p>
 * 
 * <pre>
 * import com.firstdata.globalgatewaye4.*;
 * 
 * public Class Client {
 * 		public static void main(String[] args) {
 * 			GlobalGatewayE4 e4 = new GlobalGatewayE4(Environment.DEMO, GATEWAY_ID, PASSWORD, KEY_ID, HMAC_KEY);
 * 			
 * 			CreditCardRequest request = e4.getCreditCardRequest();
 * 
 *  		request
 *  			.cardholder_name("E4 Java Tester")
 *  			.cc_number("")
 *  			.cc_expiry("0420")
 *  			.transaction_type(TransactionType.PreAuthorization)
 *  			.amount("1.00");
 *  
 *			try {
 *				Response response = request.submit();
 *				System.out.println("Transaction Approved: " + response.transaction_approved());
 *				System.out.println("Bank Message:" + response.bank_message());
 *				System.out.println(response.ctr());
 *			} catch (Exception e) {
 *				e.printStackTrace();
 *			}
 * 		}
 * }
 * </pre>
 */

public class PayeezyGateway {

	private Configuration configuration;
	private Environment environment;
	private String gateway_id;
	private String password;
	private String keyId;
	private String hmacKey;
	
	public static final String Version = new ClientLibraryProperties().version();
	
	
	/**
	 * 
	 * Creates a new instance GGe4 gateway object.
	 * 
	 * Use {@link #getRequest()} to create a new transaction request.
	 * 
	 * @param environment Environment to be used for the transaction
	 * @param gateway_id GGe4 Gateway ID to send the transaction to.
	 * @param password API Password for the GGe4 Gateway ID
	 * @param keyId API Key ID for the GGe4 Gateway ID
	 * @param hmacKey HMAC Key for the GGe4 Gateway ID
	 */
	public PayeezyGateway(Environment environment, String gateway_id, String password, String keyId, String hmacKey) {
		Validate.notNull(environment, "Environment must be specified.");
		Validate.notEmpty(gateway_id, "Gateway ID is required.");
		Validate.notEmpty("password", "Password is required.");
		Validate.notEmpty(keyId, "Key ID is required.");
		Validate.notEmpty(hmacKey, "HMAC Key is required.");
		this.environment = environment;
		this.gateway_id = gateway_id;
		this.password = password;
		this.keyId = keyId;
		this.hmacKey = hmacKey;
		this.configuration = new Configuration(gateway_id, password, keyId, hmacKey);
	}
	
	
	/**
	 * @return Returns a new Credit Card transaction {@link #Request} object.
	 */
	public CreditCardRequest getCreditCardRequest() {
		CreditCardRequest request = new CreditCardRequest(this, this.configuration);
		
		return request;
	}
	
	/**
	 * @return Returns a new TeleCheck transaction {@link #CheckRequest} object.
	 */
	public CheckRequest getCheckRequest() {
		CheckRequest request = new CheckRequest(this, this.configuration);
		
		return request;
	}
	
	/**
	 * @return Returns the current GGe4 {@link #Configuration}.
	 */
	public Configuration getConfiguration() {
		return this.configuration;
	}
	
	
	/**
	 * @return Returns a {@link #Gson} object to serialize / deserialize the transactions.
	 */
	public Gson getGson() {
		return new GsonBuilder()
					.registerTypeAdapter(TransactionType.class, new TransactionTypeSerializer())
					.registerTypeAdapter(TaxType.class, new TaxTypeSerializer())
					.registerTypeAdapter(CreditCardType.class, new CreditCardTypeSerializer())
					.registerTypeAdapter(EcommerceFlagType.class, new EcommerceFlagTypeSerializer())
					.registerTypeAdapter(CheckType.class, new CheckTypeSerializer())
					.registerTypeAdapter(CustomerIdType.class, new CustomerIdTypeSerializer())
					.registerTypeAdapter(ReleaseType.class, new ReleaseTypeSerializer())
					.registerTypeAdapter(Boolean.class, new BooleanTypeAdapter())
					.registerTypeAdapter(PhoneType.class, new PhoneTypeSerializer())
					.registerTypeAdapter(DCCIndicatorType.class,  new DCCIndicatorTypeSerializer())
					.excludeFieldsWithoutExposeAnnotation()
					.setVersion(environment.getVersion())
					.create();
	}
	
	/**
	 * @return Returns the endpoint URL of the gateway object.
	 */
	public String getUrl() {
		return environment.baseURL;
	}
}