package com.firstdata.payeezygateway.serializers;

import java.lang.reflect.Type;

import com.firstdata.payeezygateway.transactiontypes.CreditCardType;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Steve Copous <steve.copous@firstdata.com>
 *
 */
public class CreditCardTypeSerializer implements JsonSerializer<CreditCardType> {
	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public JsonElement serialize(CreditCardType src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.toString());
	}
}
