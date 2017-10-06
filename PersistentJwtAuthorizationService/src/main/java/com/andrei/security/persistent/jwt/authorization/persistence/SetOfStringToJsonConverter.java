package com.andrei.security.persistent.jwt.authorization.persistence;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Custon {link @Converter} to store a Set<String> as a JSON value during ORM.
 * 
 * @author Andrei Moldovan
 * @since 06.10.2017
 */
@Convert
public class SetOfStringToJsonConverter implements AttributeConverter<Set<String>, String> {

	private static final Type SET_OF_STRING_TYPE = TypeToken.getParameterized(Set.class, String.class).getType();

	/**
	 * Convert to DB column.
	 * 
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public String convertToDatabaseColumn(Set<String> attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return null;
		}
		return new Gson().toJson(attribute);
	}

	/**
	 * Convert DB column to entity attribute.
	 * 
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public Set<String> convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return new HashSet<>();
		}
		return new Gson().fromJson(dbData, SET_OF_STRING_TYPE);
	}
}
