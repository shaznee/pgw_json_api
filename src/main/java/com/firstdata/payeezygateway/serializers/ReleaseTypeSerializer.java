package com.firstdata.payeezygateway.serializers;

import java.lang.reflect.Type;

import com.firstdata.payeezygateway.ReleaseType;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ReleaseTypeSerializer implements JsonSerializer<ReleaseType> {

	public JsonElement serialize(ReleaseType src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.toString());
	}
}
