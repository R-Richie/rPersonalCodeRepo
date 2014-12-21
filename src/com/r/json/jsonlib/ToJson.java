package com.r.json.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ToJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Using the JSONSerializer
		/**
		 * JSONSerializer can transform any java object to JSON notation and
		 * back with a simple and clean interface, leveraging all the builders
		 * in JSONObject and JSONArray. To transform a java obect into JSON use
		 * JSONSerializer.toJSON(). To transform a valid JSON value (by JSON, I
		 * mean an Object implementing that interface), use toJava(). The last
		 * method is an instance method because the serializer needs special
		 * configuration to transform a JSON value to a bean class, array, List
		 * or DynaBean.
		 */

		// 将string转换成json
		String s1 = new String("{1:1}");
		String s2 = new String("[1,1]");
		JSONObject json1 = (JSONObject) JSONSerializer.toJSON(s1);
		System.out.println("——用JSONSerializer将string转换json——" + json1);
		JSONArray json2 = (JSONArray) JSONSerializer.toJSON(s2);
		System.out.println("——用JSONSerializer将string转换jsonArray——" + json2);

		// Working with arrays and collections,——>json

		boolean[] booleanArray = new boolean[] { true, false, true };
		JSONArray fromObject = JSONArray.fromObject(booleanArray);
		System.out.println(fromObject);

		List list = new ArrayList();
		list.add("first");
		list.add("second");
		JSONArray fromObject2 = JSONArray.fromObject(list);
		System.out.println(fromObject2);

		// Working with objects
		// From Beans & Maps toJSON
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");

		JSONObject jsonObject2 = JSONObject.fromObject(map);
		System.out.println("——map转换json——\n" + jsonObject2);
		// 自定义MyBean对象中包含MyBean2对象，所以bean——>Json，无论是否自定义对象，都可以转换json格式
		JSONObject jsonObject3 = JSONObject.fromObject(new MyBean());
		System.out.println();
		System.out.println("——beans转换json——\n" + jsonObject3);
	}
}
