<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd." />
<title>首页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script> 


 </head>
<body class="easyui-layout">
	<!-- 头部开始 -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<h1>人事管理系统</h1>
        </div>
        <div class="wu-header-right">
        	<p><strong class="easyui-tooltip" title="2条未读消息" id="welcomeWho">hello</strong>，欢迎您！</p>
            <p><a href="head.do">网站首页</a>|<a href="#">支持论坛</a>|<a href="#">帮助中心</a>|<a href="logout.do">安全退出</a>|<a href="#" iconCls="icon-edit" onclick="openUpdatePwd()" plain="true">密码修改</a></p>
        </div>
    </div>
    <!-- 头部结尾 -->
    <!-- 左边导航开始 -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"> 
    	<div class="easyui-accordion" data-options="border:false,fit:false"> 
        	<div title="系统管理" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
    			
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="user.do" iframe="0">用户管理</a></li>
                	<li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="roleFP.do" iframe="0">职位管理</a></li>
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="powerPage.do" iframe="0">权限管理</a></li>
                    
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="departmentPage.do" iframe="0">部门管理</a></li>
                </ul>
            </div>
        	
        	<div title="人事部" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
    			
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="recruit.do" iframe="0">招聘管理</a></li>
                	
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="transfer.do" iframe="0">人事调配</a></li>
                    <li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="education.do" iframe="0">培训管理</a></li>
                    <li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="toClockingPage.do" iframe="0">绩效考核</a></li>
      				<li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="toPaymentPage.do" iframe="0">薪酬福利</a></li>
                </ul>
            </div>
            <div title="行政部" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
    			
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="contract.do" iframe="0">合同管理</a></li>
                	  <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="satffRecord.do" iframe="0">员工档案管理</a></li>
                </ul>
            </div>
       <div title="员工服务" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
    			
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="basicMassage.do" iframe="0">员工基本信息管理</a></li>
                </ul>
            </div>

        </div>
        
    </div>	
        <!-- 左边导航结尾 -->  
        
        
        <!-- 模态框开始 -->
<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
	<form id="wu-form" method="post">
        <table>
            <tr>
                <td align="right">用户名:</td>
                <td><input type="text" name="employeeNo" class="wu-text" /></td>
            </tr>
			<tr>
                <td width="60" align="right">旧密码:</td>
                <td><input type="password" name="oldPassword" class="wu-text" /></td>
            </tr>
            <tr>
                <td align="right">新密码:</td>
                <td><input type="password" name="newPassword" class="wu-text" /></td>
            </tr>
        </table>
    </form>
</div>
        <!-- 模态框结束-->
        
    <!-- 工作区域开始 -->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="首页" data-options="href:'head.do',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
        </div>
    </div>
    <!-- 工作区域结束 --> 
    <!-- 底部开始 -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	&copy; 2018 版 版权所有:rock
    </div>
    <!-- 底部结束 -->  
    <script type="text/javascript">
    /**
	*  打开修改密码窗口
	*/
	function openUpdatePwd(){
		$('#wu-form').form('clear');
		$('#wu-dialog').dialog({
			closed: false,
			modal:true,
            title: "修改信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: updatePwd 
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog').dialog('close');                    
                }
            }]
        });
	}	
	/**
	*  修改密码
	*/
	function updatePwd(){
	
		$('#wu-form').form('submit', {
			url:'updatePwd.do',
			success:function(data){
				console.log(data)
				if(data==1){
					$.messager.alert('信息提示','修改成功！','info');
					$('#wu-dialog').dialog('close');
					/* //刷新
					$("#wu-datagrid").datagrid("load"); */
				}
				else
				{
					$.messager.alert('信息提示',data,'info');
				}
			}
		});
	}
    
    
    
    
		$(function(){
			$('.wu-side-tree a').bind("click",function(){
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe')==1?true:false;
				addTab(title,url,iconCls,iframe);
			});	
			/* 将用户信息进行显示 */
			getUserMsg();
		})
		/*获取用户自己的信息
		*
		*/
		function getUserMsg (){
			$.ajax({
				type : "get",//请求的方式
				url : "getUserMsg.do",//请求的url
				dataType : "text",//接收的数据类型声明
				data : {}, 
				success : function(data) {
						$("#welcomeWho").html(data);
				},
				error : function() {//当ajax请求失败回调
					alert("ajax请求失败")
				}
			});
		}
		
		/**
		* Name 添加菜单选项
		* Param title 名称
		* Param href 链接
		* Param iconCls 图标样式
		* Param iframe 链接跳转方式（true为iframe，false为href）
		*/	
		function addTab(title, href, iconCls, iframe){
			var tabPanel = $('#wu-tabs');
			if(!tabPanel.tabs('exists',title)){
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
				
				tabPanel.tabs('add',{
						title:title,
						content:content,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
				});

			}
			else
			{
				tabPanel.tabs('select',title);
			}
		}
		/**
		* Name 移除菜单选项
		*/
		function removeTab(){
			var tabPanel = $('#wu-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab){
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
	</script>
</body>
</html>
