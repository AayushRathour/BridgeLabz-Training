package com.annotations.customserialization;

import java.lang.reflect.Field;

public class ConvertJson {
	public static void main(String[] args) throws Exception {
		User user = new User("user 1", 20);
		Class<?> class1 = user.getClass();
		StringBuilder json = new StringBuilder();
		json.append("{\n");
		
		Field[] fields = class1.getDeclaredFields();
		
		for(int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			
			if(field.isAnnotationPresent(JsonField.class)) {
				JsonField annotation = field.getAnnotation(JsonField.class);
				String key = annotation.name();
				Object value = field.get(user);
				
				field.setAccessible(true);
				json.append("\t");
				json.append("\"");
				json.append(key);
				json.append(" : ");
				json.append(value);
				if(i != fields.length-1) json.append(",");
				json.append("\n");
			}
		}
		json.append("}");
		System.out.println(json);
	}
}
