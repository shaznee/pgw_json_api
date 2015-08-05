package com.firstdata.payeezygateway;
/**
 * @author Steve Copous <steve.copous@firstdata.com>
 *
 * <p>Possible values:</p>
 * <ul>
 * <li>{@link EcommerceFlagType#MOTOSingle} = 1</li>
 * </ul> 
 * @see <a href="https://support.payeezy.com/hc/en-us/articles/205757587-Dynamic-Currency-Conversion-DCC-and-Dynamic-Pricing-DP-Feature-Guide">https://support.payeezy.com/hc/en-us/articles/205757587-Dynamic-Currency-Conversion-DCC-and-Dynamic-Pricing-DP-Feature-Guide</a>
 */
public class DCCIndicatorType {
	
	private String _value_;
	
	protected DCCIndicatorType(String value) { this._value_ = value; }
	
	private static String _DCCIndicator1 = "1";
	private static String _DCCIndicator2 = "2";
	private static String _DCCIndicator3 = "3";
	private static String _DCCIndicator4 = "4";
	private static String _DCCIndicator6 = "6";
	
	public static DCCIndicatorType DCCIndicator1 = new DCCIndicatorType(_DCCIndicator1);
	public static DCCIndicatorType DCCIndicator2 = new DCCIndicatorType(_DCCIndicator2);
	public static DCCIndicatorType DCCIndicator3 = new DCCIndicatorType(_DCCIndicator3);
	public static DCCIndicatorType DCCIndicator4 = new DCCIndicatorType(_DCCIndicator4);
	public static DCCIndicatorType DCCIndicator6 = new DCCIndicatorType(_DCCIndicator6);
	
	public String toString() {
		return _value_;
	}
}
