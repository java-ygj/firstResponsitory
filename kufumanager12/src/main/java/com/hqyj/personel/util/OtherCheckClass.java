package com.hqyj.personel.util;

public class OtherCheckClass {

	public static boolean chineseCheck(String str) {
		String chinese = "^[\\u4e00-\\u9fa5]+$";

		return str.matches(chinese);
	}

	public static boolean personIdCheck(String str) {
		String personelId = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";

		return str.matches(personelId);
	}

	public static boolean numCheck(String str) {
		String num = "^[0-9]*$";
		return str.matches(num);
	}

	public static boolean dateCheck(String str) {
		String date = "((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)";
		return str.matches(date);
	}

}
