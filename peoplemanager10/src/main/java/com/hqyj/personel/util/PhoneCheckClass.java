package com.hqyj.personel.util;

import org.springframework.stereotype.Component;

/*手机号码校验*/
@Component
public class PhoneCheckClass {
	
	public static void main(String[] args) {
		System.out.println(checkPhone("19981459615"));
		System.out.println(checkPhone("13181459615"));
		System.out.println(checkPhone("13581459615"));
		System.out.println(checkPhone("13881459615"));
		System.out.println(checkPhone("17781459615"));
		System.out.println(checkPhone("29981459615"));
		System.out.println(checkPhone("29981459615"));
	}
	public static Boolean checkPhone(String phone) {
		
		if (phone.matches("^1[3,4,5,7,8,9]\\d{9}$")) {
			return true;
		} else {
			return false;
		}
	}
}
