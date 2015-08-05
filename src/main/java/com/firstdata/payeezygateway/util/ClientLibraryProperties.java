package com.firstdata.payeezygateway.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.firstdata.payeezygateway.exceptions.UnexpectedException;

/**
 * @author Steve Copous <steve.copous@firstdata.com>
 *
 */
public class ClientLibraryProperties {
	
	public static final String GATEWAY_PROPERTIES_FILE = "payeezygateway.properties";
	public static final String VERSION_PROPERTY_NAME = "payeezy.gateway.version";
	
	private final Properties properties = loadProperties(GATEWAY_PROPERTIES_FILE);
	
	public String version() {
		return properties.getProperty(VERSION_PROPERTY_NAME);
	}
	
	private Properties loadProperties(String propertyFile) {
		try {
			InputStream stream = getClass().getClassLoader().getResourceAsStream(propertyFile);
			Properties p = new Properties();
			p.load(stream);
			return p;
		} catch (IOException e) {
			throw new UnexpectedException("Couldn't load " + GATEWAY_PROPERTIES_FILE + " unable to continue.", e);
		}
	}
}
