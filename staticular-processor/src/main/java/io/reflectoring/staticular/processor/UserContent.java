package io.reflectoring.staticular.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

public class UserContent {

	@Getter
	private List<Field> fields = new ArrayList<>();

	public UserContent addField(Field field){
		this.fields.add(field);
		return this;
	}

	public Map<String, String> asMap(){
		Map<String, String> map = new HashMap<>();
		for(Field field : this.fields){
			map.put(field.getName(), field.getValue());
		}
		return map;
	}

}
