package com.firstdata.payeezygateway;

/**
 * @author Steve Copous <steve.copous@firstdata.com>
 * <p>INTENDED FOR DEMONSTRATION PURPOSES ONLY.  NOT FOR PRODUCTION USE.</p>
 *
 */
public class Environment {

	private static final int CURRENT_VERSION = 19;
	
	/**
	 * Prepopulated values for accessing the GGe4 demo environment.
	 */
	public static final Environment DEMO = new Environment("https://api.demo.globalgatewaye4.firstdata.com/transaction/v" + CURRENT_VERSION);
	public static final Environment CERT = new Environment("https://api-crt.gateway.payeezytest.com/transaction/v" + CURRENT_VERSION);
	
	public final String baseURL;
	
	/**
	 * Constructor for Environment class.
	 * 
	 * @param baseURL {@link #String} containing the URL of the GGe4 API Endpoint.
	 */
	protected Environment(String baseURL) {
		this.baseURL = baseURL;
	}
	
	public int getVersion() {
		return CURRENT_VERSION;
	}
}
