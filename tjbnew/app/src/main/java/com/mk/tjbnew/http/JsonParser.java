package com.mk.tjbnew.http;

import com.google.gson.Gson;
import com.mk.tjbnew.util.L;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;



/**
 * 
 * Json解析类
 * 
 */
public class JsonParser {

	/**
	 * Json请求封装
	 * 
	 */
	public static String toJson(Object value) {
		Gson gson = new Gson();
		String str = gson.toJson(value);
		return str;
	}

	/**
	 * Json响应解析
	 * 
	 * @param <clazz>
	 */

	@SuppressWarnings("rawtypes")
	public static Object fromJson(String json, Class clazz) {
		Gson gson = new Gson();
		Type objectType = type(Object.class, clazz);//JsonResponseModel
		try {
			return gson.fromJson(json, objectType);
		} catch (Exception e) {
			L.d(e.toString());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	static ParameterizedType type(final Class raw, final Type... args) {
		return new ParameterizedType() {
			public Type getRawType() {
				return raw;
			}

			public Type[] getActualTypeArguments() {
				return args;
			}

			public Type getOwnerType() {
				return null;
			}
		};
	}
}
