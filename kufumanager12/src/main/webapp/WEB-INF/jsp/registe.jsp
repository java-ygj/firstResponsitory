<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>人力资源管理系统</title>
		<!--引入样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css" />
		<link href="${pageContext.request.contextPath}/css/icon.css" type="text/css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet" />
		
		<!-- 开始 element样式和组件 -->
		<!-- 引入样式 -->
		<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
		<!-- 引入组件库 -->
		<script src="https://unpkg.com/element-ui/lib/index.js"></script>
		<!-- 结束 element -->
		
		
		<!--导入jquery和easyui-->
		<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

	</head>

	<body class="imgbody">
		<h1 class="myTitle">人力资源管理系统</h1>
		<div id="login" class="easyui-window" title="用户注册" style="padding: 35px; width: 600px; height: 360px;">
			<div style="text-align: center; padding: 5px;">
				<form  method="post" id="myForm" name="demo">
					<div>
						<img src="${pageContext.request.contextPath}/images/user.png" widthe="60" height="20" style="position: relative; top: 5px;" />
						<!--用户登录输入框-->
						<label for="userName">用户名:&nbsp;</label>
						<input class="easyui-textbox" type="text" name="employeeNo" id="employeeNo"  placeholder="请输入用户名" ></input>
						<span id="userNameMsg" style="color:red"></span>
					</div>
					<br />
						<div>
						<img src="${pageContext.request.contextPath}/images/pwd.png" widthe="60" height="20" style="position: relative; top: 5px;" />
						<!--密码登录输入框-->
						<label for="userPwd">密&nbsp;码:&nbsp;&nbsp;&nbsp; </label>
						<input class="easyui-textbox" name="password" type="password" id="password"  placeholder="请输入密码" ></input>
						<span id="passwordMsg" style="color:red"></span>
					</div><br />
						<div>
						<img src="${pageContext.request.contextPath}/images/user.png" widthe="30" height="20" style="position: relative; top: 5px;" />
						<!--邮箱输入框-->
						<label for="userName">邮箱:</label>
						<input class="easyui-textbox" type="text" name="emailAddress" id="emailAddress"  placeholder="请输入验证邮箱"></input>
						<span id="emailMsg" style="color:red"></span>
						<br><a href="javascript:void()" class="easyui-linkbutton" onclick="getCheckId()">获取验证码</a>	
									
							</div>
					<br />
					<div>
						<img src="${pageContext.request.contextPath}/images/user.png" widthe="20" height="20" style="position: relative; top: 5px;" />
						<!--验证码输入框-->
						<label for="userName">验证码:&nbsp;</label>
						<input class="easyui-textbox" type="text" name="checkId" id="checkId" placeholder="请输入验证码"></input>
					<span style="color:red" id="myMessage"></span>
					</div>
					
				
						
					<br/>
					<!--登录按钮-->
					<a href="javascript:void()" class="easyui-linkbutton" icon="icon-ok" onclick="regeiste()">注册</a> &nbsp;&nbsp;&nbsp;
					<a href="loginPage.do" class="easyui-linkbutton" iconCls="icon-cancel" >已注册，返回登录</a>
				</form>
			</div>
		</div>

		<script type="text/javascript">
			/* 
			*注册触发方法
			*/
			function regeiste() {
				//js的submit提交,myForm
				var employeeNo = $("#employeeNo").val();
				var password = $("#password").val();
				var emailAddress = $("#emailAddress").val();
				var checkId = $("#checkId").val()
				alert("信息"+employeeNo+password+emailAddress);
				if(employeeNo==""){
					$("#userNameMsg").html("账户为空")
				}else if(password==""){
					$("#passwordMsg").html("密码为空")
					$("#userNameMsg").html("")
				}else if(emailAddress==""){
					$("#emailMsg").html("邮箱地址为空")
					$("#passwordMsg").html("")
					$("#userNameMsg").html("")
				}else if(checkId==""){
					$("#emailMsg").html("验证码为空")
					$("#emailMsg").html("")
					$("#passwordMsg").html("")
					$("#userNameMsg").html("")
				}else{
					$.ajax({
						type : "post",//请求的方式
						url : "regesite.do",//请求的url
						dataType : "text",//接收的数据类型声明
						scriptCharset: 'utf-8',
						data : {
							employeeNo: employeeNo,
							password:password,
							emailAddress:emailAddress,
							checkId:checkId
						}, 
						success : function(data) {
							var msg = data ;
							$("#myMessage").html(msg);
						},
						error : function() {//当ajax请求失败回调
							alert("ajax请求失败")
						}
					});
					
				}
			}
			/*
			*验证码的获取
			*/
			function getCheckId(){
				/* emailAddress
				employeeNo
				password
				checkId */
			/* 	userNameMsg
				passwordMsg
				emailMsg */
				var employeeNo = $("#employeeNo").val();
				var password = $("#password").val();
				var emailAddress = $("#emailAddress").val();
				alert("信息"+employeeNo+password+emailAddress);
				if(employeeNo==""){
					$("#userNameMsg").html("账户为空")
				}else if(password==""){
					$("#passwordMsg").html("密码为空")
				}else if(emailAddress==""){
					$("#emailMsg").html("邮箱地址为空")
				}else{
					$.ajax({
						type : "post",//请求的方式
						url : "getCheckId.do",//请求的url
						dataType : "text",//接收的数据类型声明
						scriptCharset: 'utf-8',
						data : {
							employeeNo: employeeNo,
							password:password,
							emailAddress:emailAddress
						}, 
						success : function(data) {
							var msg = data ;
							$("#myMessage").html(msg);
						},
						error : function() {//当ajax请求失败回调
							alert("ajax请求失败")
						}
					});
				}
			}
			/*
			*公共部分
			*/
			
					//窗口的设置
		$('#login').window({
			collapsible:false,//关闭折叠按钮
			maximizable:false,//关闭最大化按钮
			minimizable:false,//关闭最小化按钮
			closable:false
		});
		</script>
	</body>

</html>