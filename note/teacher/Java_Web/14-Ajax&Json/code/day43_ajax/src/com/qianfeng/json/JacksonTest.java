package com.qianfeng.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	@Test
	public void bean2Json() throws Exception{
		
		Student s = new Student(2, "zhagnsan", 39);
		ObjectMapper mapper = new ObjectMapper();
		// 转为json格式字符串
		String json = mapper.writeValueAsString(s);
		System.out.println(json);
		
	}
	
	@Test
	public void list2Json() throws Exception{
		
		List<Student> l = new ArrayList<>();
		Student s = new Student(2, "zhagnsan", 39);
		Student s1 = new Student(4, "zhagnsan4", 39);
		l.add(s);
		l.add(s1);
		
		ObjectMapper mapper = new ObjectMapper();
		// 转为json格式字符串
		String json = mapper.writeValueAsString(l);
		System.out.println(json);
		
	}
	
	@Test
	public void json2bean() throws Exception{
		String json = "{\"name\":\"lisi\", \"age\":30,\"id\":5}";
		// json格式字符串转为对象
		ObjectMapper mapper =  new ObjectMapper();
		// json格式字符串转为对象
		Student stu = mapper.readValue(json, Student.class);
		System.out.println(stu.getName());
	}
	
	@Test
	public void json2list() throws Exception{
		String json = "[{\"name\":\"lisi\", \"age\":30,\"id\":5}]";
		// json格式字符串转为数组
		ObjectMapper mapper = new ObjectMapper();
		List<Student> list = mapper.readValue(json, new TypeReference<List<Student>>(){});
		System.out.println(list.get(0).getName());
	}
	
	@Test
	public void dateInfo() throws Exception{
		Person p = new Person();
		p.setAge(30);
		p.setName("haha");
		p.setBirth(new Date());
		ObjectMapper mapper = new ObjectMapper();
		// 日期对象默认转为时间戳
		System.out.println(mapper.writeValueAsString(p));
		
		// 自定义格式
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		System.out.println(mapper.writeValueAsString(p));
		
	}
}