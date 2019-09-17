<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd." />
		<title>薪酬</title>
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
			$(function() {
				loadIn('paymentPage.do');
				selectDepartment();
			})
			
			function reload(){
				loadIn('paymentPage.do');
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
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteById()" plain="true">删除</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="" plain="true">打印</a>
					</div>
					<div class="wu-toolbar-search">
						<label>关键字：</label>
						<input class="wu-text" style="width: 200px" id="key">
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
		<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
			<form id="wu-form" method="post">
				<table>
					<tr>
						<td><input type="hidden" name="paymentId" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">员工编号:</td>
						<td><input type="text" name="employeeNo" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">基本工资:</td>
						<td><input type="text" name="basicPayment" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">绩效工资:</td>
						<td><input type="text" name="performance" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">奖金:</td>
						<td><input type="text" name="reward" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">罚款:</td>
						<td><input type="text" name="punishment" class="wu-text" /></td>
					</tr>
					<tr>
						<!-- <td align="right">薪酬数目:</td> -->
						<td><input type="hidden" name="salary" class="wu-text" /></td>
					</tr>
					<tr>
						<td align="right">获薪时间:</td>
						<td><input name="getSalaryTime" type="text"  class="easyui-datebox"></td>
					</tr>

				</table>
			</form>
		</div>
	</body>
	<!-- 模态框结束-->
	<script type="text/javascript">
	/**
	* 模糊查询
	*/
	function searchByKey() {
		var key = $("#key").val();
		var str = 'searchPaymentByLike.do?key='+key;
		loadIn(str);
	}
	
	/**
	* 选择部门后调用方法 
	*/
	$("#selectDep").change(function(){
		var departmentDes = $("#selectDep").val();
		//alert(departmentDes);
		var str = 'searchPaymentByLike.do?key='+departmentDes;
		loadIn(str);
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
				var depInf = "<option>-----请选择部门-----</option>";
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
		 * 添加记录
		 */
		function add() {
			$('#wu-form').form('submit', {
				url: 'addPayment.do',
				success: function(data) {
					console.log(data)
					if(data==1) {
						$.messager.alert('信息提示', '提交成功！', 'info');
						$('#wu-dialog').dialog('close');
						reload();
					} else {
						$.messager.alert('信息提示', '提交失败！', 'info');
					}
				}
			});
		}

		/**
		 *  修改记录
		 */
		function edit() {

			$('#wu-form').form('submit', {
				url: 'updatePayment.do',
				success: function(data) {
					if(data) {
						$.messager.alert('信息提示', '提交成功！', 'info');
						$('#wu-dialog').dialog('close');
						// 刷新
						reload();
					} else {
						$.messager.alert('信息提示', '提交失败！', 'info');
					}
				}
			});
		}

		/**
		 *  删除记录
		 */
		function deleteById() {
			$.messager.confirm('信息提示','确定要删除该记录？', function(result){
				if(result){
					var items = $('#wu-datagrid').datagrid('getSelections');
					console.log(items)
					var ids = "0";
					$(items).each(function(){
						ids += "," + this.paymentId;
					});
					console.log(typeof ids);
					//alert(ids);
					
					$.ajax({
						url:"deletePaymentIds.do",
						data:{ids:ids},
						success:function(data){
							if(data != 0){
								$.messager.alert('信息提示','删除成功！','info');
								// 刷新
								reload();
							}
							else
							{
								$.messager.alert('信息提示','删除失败！','info');		
							}
						}	
					});
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
				title: "添加信息",
				buttons: [{
					text: '确定',
					iconCls: 'icon-ok',
					handler: add
				}, {
					text: '取消',
					iconCls: 'icon-cancel',
					handler: function() {
						$('#wu-dialog').dialog('close');
					}
				}]
			});
		}

		/**
		 *  打开修改窗口
		 */
		function openEdit() {
			//获取选中行
			var item = $('#wu-datagrid').datagrid('getSelected');
			console.log(item)
			if(item == null) {
				$.messager.alert('信息提示', '请选中行！', 'info');
				return;
			}
			$('#wu-form').form('clear');
			//绑定值
			$('#wu-form').form('load', item)

			$('#wu-dialog').dialog({
				closed: false,
				modal: true,
				title: "修改信息",
				buttons: [{
					text: '确定',
					iconCls: 'icon-ok',
					handler: edit
				}, {
					text: '取消',
					iconCls: 'icon-cancel',
					handler: function() {
						$('#wu-dialog').dialog('close');
					}
				}]
			});
		}

		/**
		 * 载入数据
		 */
		function loadIn(str) {
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
						},
						{
							field: 'paymentId',
							title: 'id',
							width: 15
						},
						{
							field: 'employeeNo',
							title: '员工编号',
							width: 60
						},
						{
							field: 'basicPayment',
							title: '基本工资',
							width: 100
						},
						{
							field: 'performance',
							title: '绩效工资',
							width: 100
						},
						{
							field: 'reward',
							title: '奖金',
							width: 100
						},
						{
							field: 'punishment',
							title: '罚款',
							width: 100
						},
						{
							field: 'salary',
							title: '薪酬数目',
							width: 100
						},
						{
							field: 'getSalaryTime',
							title: '获薪时间',
							width: 100
						},

					]
				]
			});
		}
	</script>