package com.home.prec0724.openAPI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//JSON 이란? 자바스크립트 객체 표기법 
//	  xml과 함께 이기종간 데이터 교환시 사용되는 데이터 포맷 (그냥 문자열이다..)
// 자바는 json이해 못함 따라서 문자열에 불과한 json 포맷을 자바언어가 이해하도록
//처리 즉 해석 하는 프로그래밍을 배워보자, 파싱법을 배워보자
public class JsonParseTest {
	public static void main(String[] args) {
		//String클래스의 특징 - 불변의 특징
		//즉 한번 선언된 String객체는 수정이 불가 immutable -> 즉, 상수임
		String m="KOREA";
		m="korean";
		
		//String 은 문자열 상수이므로 변할수 없음. 따라서 다수의 문자열을
		//변경할 목적으로 프로그램을 작성할때는 StringBuilder, StringBuffer 객체를 이용할 수 있음.
		
		//명시적 선언법 explicit
		String s = new String();
		
		//암시적(묵시적) 선언법 implicit
		StringBuilder str=new StringBuilder(); //String클래스가 아님!!
		
		str.append("{");
		str.append("\"name\":	\"철수\", ");
		str.append("\"age\": 28, ");
		str.append("\"children\" :[");
		str.append("{");
		str.append("\"type\":\"고양이\",");
		str.append("\"age\" :2, ");
		str.append("\"name\":\"나비\",");
		str.append("\"color\":\"검정\"");
		str.append("},");
		str.append("{");
		str.append("\"type\":\"강아지\",");
		str.append("\"age\" :5, ");
		str.append("\"name\":\"뽀미\",");
		str.append("\"color\":\"흰색\"");
		str.append("}");
		str.append("]");
		str.append("}");
		
		//System.out.println(str);
		
		JSONParser jsonParser=new JSONParser();
		try {
			
			JSONObject obj=(JSONObject)jsonParser.parse(str.toString());
			//System.out.println(obj.get("name"));
			
			JSONArray array=(JSONArray)obj.get("children");
			System.out.println(array.size());
			for(int i=0;i<array.size();i++) {
				JSONObject pet=(JSONObject)array.get(i);
				System.out.println("종류"+pet.get("type"));
				System.out.println("나이"+pet.get("age"));
				System.out.println("이름"+pet.get("name"));
				System.out.println("색상"+pet.get("color"));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}







