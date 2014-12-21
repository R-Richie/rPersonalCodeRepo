package com.r.json.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBean3 {

	private List<MyBean2> mybean2List = new ArrayList<MyBean2>();

	private Map<String, MyBean2> mybean2Map = new HashMap<String, MyBean2>();

	public List<MyBean2> getMybean2List() {
		return mybean2List;
	}

	public void setMybean2List(List<MyBean2> mybean2List) {
		this.mybean2List = mybean2List;
	}

	public Map<String, MyBean2> getMybean2Map() {
		return mybean2Map;
	}

	public void setMybean2Map(Map<String, MyBean2> mybean2Map) {
		this.mybean2Map = mybean2Map;
	}

}
