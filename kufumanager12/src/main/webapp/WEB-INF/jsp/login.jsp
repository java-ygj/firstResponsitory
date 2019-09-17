<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>人力资源管理系统</title>
<!--引入样式-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css" />
<link href="${pageContext.request.contextPath}/css/icon.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/login.css"
	type="text/css" rel="stylesheet" />

<!-- 开始 element样式和组件 -->
<!-- 引入样式 -->
<link rel="stylesheet"
	href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<!-- 结束 element -->

<!--导入jquery和easyui-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

</head>

<body class="imgbody">
	<h1 class="myTitle">人力资源管理系统</h1>
	<div id="login" class="easyui-window" title="用户登录"
		style="padding: 35px; width: 400px; height: 300px;">
		<div style="text-align: center; padding: 5px;">
			<!-- 	action="login.do" -->
			<form method="post" id="myForm" name="demo">
				<div>
					<img src="${pageContext.request.contextPath}/images/user.png"
						widthe="20" height="20" style="position: relative; top: 5px;" />
					<!--用户登录输入框-->
					<label for="userName">用户名:&nbsp;</label> <input
						class="easyui-textbox" type="text" name="employeeNo"
						id="employeeNo" placeholder="请输入用户名"></input>
				</div>

				<div>
					<img src="${pageContext.request.contextPath}/images/pwd.png"
						widthe="20" height="20" style="position: relative; top: 5px;" />
					<!--密码登录输入框-->
					<label for="userPwd">密&nbsp;码:&nbsp;&nbsp;&nbsp; </label> <input
						class="easyui-textbox" name="password" type="password"
						id="password" placeholder="请输入密码"></input>
				</div>
				<div>
					<!-- 验证码开始 -->
					<img src="${pageContext.request.contextPath}/images/pwd.png"
						widthe="20" height="20" style="position: relative; top: 5px;" />
					<label for="userPwd">验证码:&nbsp; </label> <input
						class="easyui-textbox" type="text" id="verifyCode"
						name="verifyCode" placeholder="验证码">
				</div>
			<div>
			<span style="color: red" id="errorMsg">${param.error}</span>
				<img style="position: absolute;left:100px;top:170px"
					src="${pageContext.request.contextPath }/getVerifyCode.do"
					width="200" height="60" id="verifyCodeImage"
					onclick="javascript:changeImage();">
				<!-- 验证码结束 -->
			</div>
				 <div>
				<!--登录按钮-->
				<br /><br /><br /><br /><br /> <a href="javascript:void()" class="easyui-linkbutton"
					icon="icon-ok" onclick="login()">登录</a> &nbsp;&nbsp;&nbsp; <a
					href="toregiste.do" class="easyui-linkbutton"
					iconCls="icon-add">注册</a>
					</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	/*点击刷新验证码*/
	/*点击图片更换验证码事件*/
	function changeImage() {
	    //采用改变时间戳，可以防止浏览器从本地缓存中读取图片文件。
		
			//获取现在时间的原始值
	    	var timestamp = (new Date()).valueOf();
			//取出原src
	    	var url = $("#verifyCodeImage").attr("src");
			//在原src后面拼接时间戳
	    	url = url + "?timestamp=" + timestamp;
			//将改变的后的url赋值给src
	    	$("#verifyCodeImage").attr("src", url);
	

	}
	/*注册方法*/
	/* 登录触发方法 */
	function login() {
		//js的submit提交,myForm
		document.demo.action = "login.do";
		document.demo.submit();

	}

	//窗口的设置
	$('#login').window({
		collapsible : false,//关闭折叠按钮
		maximizable : false,//关闭最大化按钮
		minimizable : false,//关闭最小化按钮
		closable : false
	});
</script>
</html>