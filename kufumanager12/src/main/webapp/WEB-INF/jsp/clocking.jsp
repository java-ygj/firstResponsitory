<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd." />
		<title>考勤管理</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
		<script type="text/javascript">
		/**
		 * 页面加载就调用的方法
		 */
		$(function(){
			commonData('clockingPage.do');
			selectDepartment();
		})
		
		/**
		* 刷新
		*/
		function reload(){
			commonData('clockingPage.do');
			selectDepartment();
		}
		</script>
	</head>

	<body>
		<div class="easyui-layout" data-options="fit:true">

			<div data-options="region:'center',border:false">
				<!-- 工具栏开始 -->
				<div id="wu-toolbar">
					<div class="wu-toolbar-button">
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">打卡</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
					</div>
					
					<div class="wu-toolbar-search">
						<label>考勤时间：</label>
						<input class="easyui-datebox" type="text" style="width: 100px" id="myKey">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchByKey()">开始检索</a>
						
						<label>选择部门：</label>
						<select id="selectDep" panelHeight="auto" style="width:150px">
						</select>
					</div>
					
				</div>
				<!-- 工具栏结束 -->
				<!--表格开始  -->
				<table id="wu-datagrid" toolbar="#wu-toolbar"></table>
				<!--表格结束  -->
			</div>
		</div>
		
		<!-- 模态框开始 -->
		<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 400px; padding: 10px;">
			<form id="wu-form" method="post">
				<table>
					<tr>
						<td><input name="clockingId" type="hidden"></td>
					</tr>
					<tr>
						<td width="50" align="right">考勤时间:</td>
						<td><input type="text" name="clockingDate" class="easyui-datebox" /></td>
					</tr>
					<tr>
						<td align="right">员工编号:</td>
						<td><input type="text" name="employeeNo" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">类型:</td>
						<td>
							<select id="selectType" name="type">
								<option>-----选择-------</option>
								<option value="OnTime">准时</option>
								<option value="Late">迟到</option>
								<option value="Leave">请假</option>
								<option value="OverTime">加班</option>
								<option value="WorkTrip">出差</option>
								<option value="Out">旷工</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">奖惩金额:</td>
						<td>
							<!-- <input id="rap" name="reardAndPunish" type="text" class="wu-text" /> -->
							<select  id="rap" name="reardAndPunish">
								<option>-----选择-------</option>
								<option value="0">0</option>
								<option value="-20">-20</option>
								<option value="-10">-10</option>
								<option value="50">50</option>
								<option value="100">100</option>
								<option value="-100">-100</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">考勤人:</td>
						<td>
							<select name="clocker">
								<option value="admin">admin</option>
								<option value="other">other</option>
							</select>
						</td>
					</tr>

				</table>
			</form>
		</div>
	</body>
	<!-- 模态框结束-->
	
	<script type="text/javascript">
	
	/**
	* 改变上班类型的时候，自动改变奖惩金额
	*/
	$("#selectType").change(function(){
		var type = $("#selectType").val();
		if (type == "OnTime") {
			$("#rap").val(0);
		} else if(type == "Late") {
			$("#rap").val(-20);
		}else if(type == "Leave") {
			$("#rap").val(-10);
		}else if(type == "OverTime") {
			$("#rap").val(50);
		}else if(type == "WorkTrip") {
			$("#rap").val(100);
		}else if(type == "Out") {
			$("#rap").val(-100);
		}
	})
	
	/**
	* 选择部门后调用方法 
	*/
	$("#selectDep").change(function(){
		var departmentDes = $("#selectDep").val();
		alert(departmentDes);
		var str = 'searchClockingByLike.do?key='+departmentDes;
		commonData(str);
	})
	
	/**
	* 获取部门
	*/
	function selectDepartment() {
		$.ajax({
			type : "get",//请求的方式 ("get")有乱码
			url : "getAllDepartments.do",//请求的url
			dataType : "text",//接收的数据类型声明
			data : {},
			success : function(list) {
				list = JSON.parse(list);
				var depInf = "<option value='0'>-----请选择部门-----</option>";
				for(let i=0; i<list.length; i++){
					var dep = list[i];
					depInf += "<option value='"+dep.departmentDes+"'>"+dep.departmentName+"</option>";
				}
				$("#selectDep").html(depInf);
			},
			error : function() {//当ajax请求失败回调
				alert("ajax请求失败")
			}
		});
	}
	/**
	* 模糊查询 search(searchByKey.do?key=$('#key'))
	*/
	function searchByKey(){
		var key = $("#myKey").datebox('getValue')
		console.log(key);
		alert(key);
		var str = 'searchClockingByDate.do?key='+key;
		commonData(str); 
	}
	/**
	*  打开修改窗口
	*/
	function openEdit(){
		//获取选中行   item是object
		var item = $('#wu-datagrid').datagrid('getSelected');
		// alert(item);
		console.log(item)
		if(item==null){
			$.messager.alert('信息提示','请选中行！','info');
			return;
		}
		$('#wu-form').form('clear');
		//绑定值
		$('#wu-form').form('load', item)
	
		$('#wu-dialog').dialog({
			closed: false,
			modal:true,
            title: "修改信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: edit
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
	*  修改记录
	*/
	function edit(){
		$('#wu-form').form('submit', {
			url:'updateClocking.do',
			success:function(data){
				if(data){
					$.messager.alert('信息提示','提交成功！','info');
					$('#wu-dialog').dialog('close');
					//刷新
					$("#wu-datagrid").datagrid("load");
				}
				else
				{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	}
	
	
	
		/**
		 * 添加记录
		 */
		function add() {
			$('#wu-form').form('submit', {
				url: 'addClocking.do',
				success: function(data) {
					console.log(data)
					if(data) {
						$.messager.alert('信息提示', '提交成功！', 'info');
						$('#wu-dialog').dialog('close');
						//刷新
						$("#wu-datagrid").datagrid("load");
					} else {
						$.messager.alert('信息提示', '提交失败！', 'info');
					}
				}
			});
		}

		/**
		 * 打开添加窗口
		 */
		function openAdd() {
			$('#wu-form').form('clear');
			$('#wu-dialog').dialog({
				closed: false,
				modal: true,
				title: "添加考勤信息",
				buttons: 
					[{ text: '确定',iconCls: 'icon-ok',handler: add }, 
					{text: '取消',iconCls: 'icon-cancel',handler: function() {
						$('#wu-dialog').dialog('close');
					}
				}]
			});
		}
		
		
		
		/**
		 * 加载表格的方法
		 */
		 function commonData(str){
			 $('#wu-datagrid').datagrid({
					url: str,
					method: "get", //提交方式	
					rownumbers: true, //显示行号
					singleSelect: false,
					pagination: true, //如果表格需要支持分页，必须设置该选项为true
					pageSize: 10, //表格中每页显示的行数
					pageList: [3, 5, 10],
					fitColumns: true,
					fit: true,
					columns: [
						[{
								checkbox: true
							},{
								field: 'clockingId',
								title: 'id',
								width: 10
							}, {
								field: 'clockingDate',
								title: '考勤时间',
								width: 100
							}, {
								field: 'employeeNo',
								title: '员工编号',
								width: 100
							}, {
								field: 'type',
								title: '类型',
								width: 100
							}, {
								field: 'reardAndPunish',
								title: '奖惩金额',
								width: 100
							}, {
								field: 'clocker',
								title: '考勤人',
								width: 100
							}

						]
					]
				});
		}
		
	</script>