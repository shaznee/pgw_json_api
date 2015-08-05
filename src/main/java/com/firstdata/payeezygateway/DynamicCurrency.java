package com.firstdata.payeezygateway;
/**
 * @author Steve Copous <steve.copous@firstdata.com>
 *
 * @see <a href="https://support.payeezy.com/hc/en-us/articles/205757587-Dynamic-Currency-Conversion-DCC-and-Dynamic-Pricing-DP-Feature-Guide">https://support.payeezy.com/hc/en-us/articles/205757587-Dynamic-Currency-Conversion-DCC-and-Dynamic-Pricing-DP-Feature-Guide</a>
 */
import com.google.gson.annotations.Expose;

@SuppressWarnings("unchecked")
public class DynamicCurrency<T extends DynamicCurrency<T>> {
	@Expose private Boolean opted_in;
	@Expose private String rate_response_signature;
	
	T self() {
		return (T)this;
	}
	
	/**
	 * @param opted_in
	 * {@link #Boolean} "true" or "false". Whether customer has opted-in to DCC conversion
	 * @return {@link #Request}
	 */
	public T opted_in(Boolean opted_in) {
		this.opted_in = opted_in;
		return self();
	}
	
	/**
	 * @param rate_response_signature
	 * {@link #String} The value of the "rate_response_id" from the exchange rate API (card rate request)
	 * @return {@link #Request}
	 */
	public T rate_response_signature(String rate_response_signature) {
		this.rate_response_signature = rate_response_signature;
		return self();
	}
}
