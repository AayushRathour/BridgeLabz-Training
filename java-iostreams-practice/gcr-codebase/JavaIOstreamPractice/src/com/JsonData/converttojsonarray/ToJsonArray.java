package com.jsondata.converttojsonarray;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Student> list = new ArrayList<>();
        list.add(new Student("name1", 20));
        list.add(new Student("name2", 21));

        JSONArray result = new JSONArray();
        
        for(Student student : list) {
        	JSONObject obj = new JSONObject();
        	obj.put("Name", student.name);
        	obj.put("Age", student.age);
        	result.put(obj);
        }
        
        System.out.println(result.toString());
    }
}
