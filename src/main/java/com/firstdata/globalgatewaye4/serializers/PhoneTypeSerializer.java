package com.firstdata.globalgatewaye4.serializers;

import java.lang.reflect.Type;

import com.firstdata.globalgatewaye4.PhoneType;
import com.firstdata.globalgatewaye4.TaxType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class PhoneTypeSerializer implements JsonSerializer<PhoneType>, JsonDeserializer<PhoneType> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public JsonElement serialize(PhoneType src, Type typeOfSrc,	JsonSerializationContext context) {
		return new JsonPrimitive(src.toString());
	}

	public PhoneType deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		if(json.getAsString().equals("H")) {
			return PhoneType.Home;
		}
		else if(json.getAsString().equals("W")) {
			return PhoneType.Work;
		}
		else if(json.getAsString().equals("D")) {
			return PhoneType.Day;
		}
		else if(json.getAsString().equals("N")) {
			return PhoneType.Night;
		}
		
		return null;
	}
}
