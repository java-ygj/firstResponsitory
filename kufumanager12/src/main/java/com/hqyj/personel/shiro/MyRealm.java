package com.hqyj.personel.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqyj.personel.mapper.TestMapper;
import com.hqyj.personel.mapper.UserMapper;
import com.hqyj.personel.po.TestPo;
import com.hqyj.personel.po.User;


public class MyRealm extends AuthorizingRealm {
	@Autowired
	private UserMapper userMapper;

	/*
	 * 2. 授权
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 角色查询
		Object employeeNo = principals.fromRealm(this.getName()).iterator().next();
		System.err.println("给" + employeeNo + "授权");
		// 1.1 
		List<String> positionNameList = userMapper.searchPosition(employeeNo + "");
		for (String positionname : positionNameList) {
			System.out.println("MyRealm拥有的角色名字" + positionname);
		}
		// 1.2 
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		auth.addRoles(positionNameList);

		// 2.1 权限查询
		List<String> powerList = userMapper.searchPower(employeeNo + "");
		for (String power : powerList) {
			System.err.println("拥有的权限" + power);
		}
		// 2.2 
		// 2.3 
		auth.addStringPermissions(powerList);

		// 
		return auth;
	}

	/*
	 * 1. 认证 ֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 
		UsernamePasswordToken ut = (UsernamePasswordToken) token;
		Object employeeNo = ut.getPrincipal();
		
		// 根据employeeNo查询user
		User user = userMapper.getUserByemployeeNo(employeeNo + "");
		//状态码，当为1时表示已经被删除
		if (user == null ||"1".equals(user.getDeleteStatus())) {
			throw new UnknownAccountException();
		}
		// ֤
		/*
		 * 密码验证交给shiro来做
		 */
		AuthenticationInfo auth = new SimpleAuthenticationInfo(user.getEmployeeNo(), user.getPassword(), new Md5Hash(employeeNo),
				this.getName());
		return auth;
	}

}
