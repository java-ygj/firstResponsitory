package com.hqyj.personel.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;
@Component
public class MdFive {
	/**
	 * MD5加密
	 * @param password 明码，即原始密码
	 * @param saltValue 自定义的盐值
	 * @return 加密后的密码
	 */
	public Object encrypt(String password,String saltValue){
		//MD5hash，哈希值计算器，用于算出一个固定的MD5码来
        Object salt = new Md5Hash(saltValue);  
        /**
         * SimpleHash第一个参数 是加密方式
         * 第二个参数 是要加密的密码
         * 第三个参数 经过哈希计算的盐值
         * 第四个参数 加密次数
         */
        Object result = new SimpleHash("MD5", password, salt, 1024);
       
        return result;
	}
}
