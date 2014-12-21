package com.r.json.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.util.JSONUtils;

import org.apache.commons.beanutils.PropertyUtils;

public class JsonToBeans {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Using the JSONSerializer
		JSONArray json2 = (JSONArray) JSONSerializer.toJSON("[1,2,3]");
		// 将json转换成list
		List java2 = (List) JSONSerializer.toJava(json2);
		System.out.println("——用JSONSerializer将json转换list——" + java2);

		// Json-lib can transform JSONObjects to either a DynaBean or an
		// specific bean class.
		// When using DynaBean all arrays are converted to Lists, when using an
		// specific bean class the transformation will use type conversion if
		// necessary on array properties.

		// Convert to
		// DynaBean:直接用toBean方法，String,number,boolean,list可以直接转换，其他类型都转换为DynaBean
		String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2],map:{1:1,2:2}}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		Object bean = JSONObject.toBean(jsonObject);

		String name = (String) jsonObject.get("name");
		Object property = PropertyUtils.getProperty(bean, "name");
		System.out.println(name.getClass() + "——" + name + "|"
				+ property.getClass() + "——" + property);

		Object func = jsonObject.get("func");
		Object funcProperty = PropertyUtils.getProperty(bean, "func");
		System.out.println(func.getClass() + "——" + func + "|"
				+ funcProperty.getClass() + "——" + funcProperty);
		// List expected = JSONArray.toList(jsonObject.getJSONArray("array"));
		Object array = jsonObject.get("array");
		Object arrayProperty = PropertyUtils.getProperty(bean, "array");
		System.out.println(array.getClass() + "——" + array + "|"
				+ arrayProperty.getClass() + "——" + arrayProperty);
		Map map = (Map) jsonObject.get("map");
		Object mapProperty = PropertyUtils.getProperty(bean, "map");
		System.out.println(map.getClass() + "——" + map + "|"
				+ mapProperty.getClass() + "——" + mapProperty);

		// Convert to Bean:json转换自定义bean
		String json3 = "{id:\"1\",name:\"123\"}";
		JSONObject jsonObject3 = JSONObject.fromObject(json3);
		MyBean2 bean2 = (MyBean2) JSONObject.toBean(jsonObject3, MyBean2.class);
		Object objectName = jsonObject3.get("name");
		String name2 = bean2.getName();
		System.out.println(objectName.getClass() + "——" + objectName + "|"
				+ name2.getClass() + "——" + name2);
		/**
		 * //here are two special cases when converting to an specific bean, if
		 * the target bean has a Map property and it must contain other beans,
		 * JSONObject.toBean() will transform the nested beans into DynaBeans.
		 * If you need those nested beans transformed into an specific class,
		 * you can either postprocess the Map attribute or provide hints on
		 * JSONObject's attributes for conversion. JSONObject.toBean() may be
		 * passed a third argument, a Map, that will provide thos hints. Every
		 * key must be either the name of a property or a regular expression
		 * matching the object's properties, and the value must be a Class.
		 * 
		 * The second case is similar and it happens when the target bean has a
		 * Collection (List) as a property and it must contain other beans. In
		 * this case there is no way to provide hints for class conversion. The
		 * only possible solution is to postprocess the collection transforming
		 * each DynaBean into an specific bean.
		 * 
		 * To ease the postprocessing scenarios, EZMorph provides a Morpher
		 * capable of transforming a DynaBean into an specific bean, BeanMorpher
		 **/
		// 两种特殊情况，对象中包含自定义类，需要手动转换自定义类
		String jsonMyBean = "{'name':'json','mybean2':{'id':'1','name':'mybean'},'pojoId':1,'func1':function(i){ return this.options[i]; },'func2':function(i){ return this.options[i]; },'options':['a','f']}";
		Map classMap = new HashMap();
		classMap.put("mybean2", MyBean2.class);
		// MyBean mybean = (MyBean) JSONObject.toBean(
		// JSONObject.fromObject(jsonMyBean), MyBean.class, classMap);
		// System.out.println(mybean.getMybean2().getClass());
		MyBean mybean2 = (MyBean) JSONObject.toBean(
				JSONObject.fromObject(jsonMyBean), MyBean.class);
		MyBean2 mybean22 = mybean2.getMybean2();
		System.out.println("|||||||||||||" + mybean22.getName());
		// Morpher dynaMorpher = new BeanMorpher(Person.class,
		// JSONUtils.getMorpherRegistry());
		// morpherRegistry.registerMorpher(dynaMorpher);
		// List output = new ArrayList();
		// for (Iterator i = bean.getData().iterator(); i.hasNext();) {
		// output.add(morpherRegistry.morph(Person.class, i.next()));
		// }
		// bean.setData(output);
		String jsonMyBean3 = "{'mybean2List':[{'id':'1','name':'mybean3'}],'mybean2Map':{'1':{'id':'2','name':'mybean3'}}}";
		Map classMap2 = new HashMap();
		classMap2.put("mybean2List", MyBean2.class);
		// classMap2.put("mybean2Map", Map.class);
		MyBean3 mybean3 = (MyBean3) JSONObject.toBean(
				JSONObject.fromObject(jsonMyBean3), MyBean3.class, classMap2);
		System.out.println("-------------"
				+ mybean3.getMybean2List().getClass() + "|"
				+ mybean3.getMybean2Map().getClass() + "|");
		// List<MyBean2> mybean2List = mybean3.getMybean2List();
		Morpher dynaMorpher = new BeanMorpher(MyBean2.class,
				JSONUtils.getMorpherRegistry());
		MorpherRegistry morpherRegistry = new MorpherRegistry();
		morpherRegistry.registerMorpher(dynaMorpher);
		List output = new ArrayList();
		for (Iterator i = mybean3.getMybean2List().iterator(); i.hasNext();) {
			Object morph = morpherRegistry.morph(MyBean2.class, i.next());
			output.add(morph);
		}
		mybean3.setMybean2List(output);
		// 打印结果
		for (MyBean2 object : mybean3.getMybean2List()) {
			System.out.println("特殊转换list——" + object.getName());
		}
		// Map
		morpherRegistry.registerMorpher(dynaMorpher);
		Map outputMap = new HashMap();
		for (Map.Entry outMap : mybean3.getMybean2Map().entrySet()) {
			Object value = outMap.getValue();
			outputMap.put(outMap.getKey(),
					morpherRegistry.morph(MyBean2.class, value));
		}
		mybean3.setMybean2Map(outputMap);
		// 输出部分结果
		for (Map.Entry<String, MyBean2> bean2Map : mybean3.getMybean2Map()
				.entrySet()) {
			System.out.println("特殊转换map——" + bean2Map.getKey() + ":"
					+ bean2Map.getValue());
		}
	}
}
