package com.home.prec0724.string;

/*
 String은 수정될 수 없음. 즉 문자열 상수로 봄.
 수정될 수 없으므로 다수의 문자열 처리 시 주의해야함
 */
public class StringTest {
	public static void main(String[] args) {
		//명시적 생성법 : 인스턴스가 heap에 생성됨
		String s1=new String("apple");
		String s2=new String("apple");
		System.out.println(s1==s2); //false
		
		//암시적 생성법 : new를 사용하지 않아도 인스턴스가 생성되었으므로,
		//즉, new를 명시하지 않고 인스턴스를 생성했다고 하여, 
		//묵시적 또는 암시적 생성법이라 함.
		
		//암시적 생성법으로 String 객체의 인스턴스를 생성하면, 
		//힙영역의 상수풀(constant pool)에에 생성되므로,
		//중복된 문자열 상수는 생성되지 않고 기존의 것을 이용함
		//암시적 생성법에 의해 생성된 String객체는 상수풀(constant pool)에 생성되어 관리됨
		//따라서, 기존의 동일한 내용의 상수가 있다면 
		String m1="korea";
		String m2="korea";
		System.out.println(m1==m2); //true, 두 레퍼런스 변수가 같은 문자열 상수를 가리킴, 즉 같은 주소를 가리키고 있음.
	
		System.out.println(m1.equals(m2));
	}
}
