package com.hqyj.personel.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 自定义角色过滤器
 * 功能：实现角色或的关系MyFilterRoles[角色1,角色2]
 * @author ygj
 *
 */
public class MyFilerter extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		//获取到当前用户
		Subject subject = getSubject(request, response);
		//获取配置的权限参数
		String[] roles = (String[]) mappedValue;
		for (String string : roles) {
			System.err.println("MyFilter过滤器设置的权限参数有:"+string);
		}
		//如果没有设置权限参数，默认成功
		for(int i=0;i<roles.length;i++) {
			if(subject.hasRole(roles[i])) {
				System.out.println("");
				return true;
			}
		}
		return false;
	}
	
}
