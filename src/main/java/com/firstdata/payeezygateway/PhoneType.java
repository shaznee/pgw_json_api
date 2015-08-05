package com.firstdata.payeezygateway;

public class PhoneType {
	private String _value;
	
	protected PhoneType(String value) {
		this._value = value;
	}
	
	private static final String _Home = "H";
	private static final String _Work = "W";
	private static final String _Day = "D";
	private static final String _Night = "N";
	
	public static final PhoneType Home = new PhoneType(_Home);
	public static final PhoneType Work = new PhoneType(_Work);
	public static final PhoneType Day = new PhoneType(_Day);
	public static final PhoneType Night = new PhoneType(_Night);
	
	@Override
	public String toString() {
		return _value;
	}
}
