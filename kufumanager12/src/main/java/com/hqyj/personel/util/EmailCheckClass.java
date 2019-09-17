package com.hqyj.personel.util;
/*email格式的验证*/
public class EmailCheckClass {
	public static Boolean checkEmail(String email) {
		if (email.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")) {
			return true;
		} else {
			return false;
		}
	}
}
