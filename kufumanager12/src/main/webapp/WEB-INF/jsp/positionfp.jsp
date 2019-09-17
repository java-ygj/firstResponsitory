<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd." />
<title>职位管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script> 

 </head>
<body>
<div class="easyui-layout" data-options="fit:true">
  
    <div data-options="region:'center',border:false">
    	<!-- 工具栏开始 -->
        <div id="wu-toolbar">
            <div class="wu-toolbar-button">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reflesh()" plain="true">刷新</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="openAdd()" plain="true">打印</a>
               <!--  <a href="#" class="easyui-linkbutton" iconCls="icon-help" onclick="openEdit()" plain="true">帮助</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="remove()" plain="true">撤销</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="cancel()" plain="true">重做</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-sum" onclick="reload()" plain="true">总计</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="reload()" plain="true">返回</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="reload()" plain="true">提示</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="reload()" plain="true">保存</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cut" onclick="reload()" plain="true">剪切</a>  -->
            </div>
            <div class="wu-toolbar-search">
            
            	<label>用户组：</label> 
                <select  panelHeight="auto" style="width:100px" id="selectDep">
                    <option value="0">选择部门</option>
                    <option value="1">人事</option>
                    <option value="2">行政</option>
                </select>
                <label>起始时间：</label><input id="beginTime"   class="easyui-datebox" style="width:100px">
                <label>结束时间：</label><input id="endTime" class="easyui-datebox" style="width:100px">
               
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="selectByDate()">入职时间查询</a>
               
                <label>关键词：</label><input  class="wu-text" style="width:100px" id="myKey">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="selectByKey()">开始检索</a>
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
                <td width="60" align="right"></td>
                <td><input type="hidden" name="positionId" class="wu-text" /></td>
            </tr>
            <tr>
                <td align="right">职称:</td>
                <td><input type="text" name="positionName" class="wu-text" /></td>
            </tr>
			<tr>
                <td width="60" align="right">部门id:</td>
                <td><input type="text" name="departmentId" class="wu-text" /></td>
            </tr>
            <tr>
                <td align="right">职位描述:</td>
                <td><input type="text" name="positionDesc" class="wu-text" /></td>
            </tr>
            <tr>
                <td align="right">创建时间:</td>
                <td><input type="text" name="positionCreateTime" class="easyui-datebox" style="width:263px" id="testbirthday"/></td>
            </tr>
            <tr>
                <td width="60" align="right">职位状态:</td>
                <td><input type="text" name="positionState" class="wu-text" /></td>
            </tr>
            <!--  <tr>
                <td align="right">下拉测试:</td>
                <td> 
     <input class="easyui-combotree" data-options="url:'tree_data1.json',method:'get',label:'Select Node:',labelPosition:'top'" style="width:100%"></td>
            </tr> -->
           <!--   <tr>
                <td align="right">测试下拉框:</td>
                <td><select type="text" name="deleteStatus" class="wu-text" >
                 <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
                </select></td>
            </tr> -->
            
        </table>
    </form>
</div>
</body>
<!-- 模态框结束-->
<script type="text/javascript">

		/*查询这个入职时间内的人员信息*/
		function selectByDate(){
			var DeptMsg = $("#selectDep").val();
			var bTime= $("#beginTime").datebox("getValue");
			var eTime = $("#endTime").datebox("getValue");
			if(bTime==""&&eTime==""){
				alert("选择时间")
			}else{
				if(bTime==""){
					if(dateCheck(eTime)){
						selectCommonLoad('empty',eTime,DeptMsg);
					}else{
						alert("格式不正确，输入时间应如:2018-05-09")
					}
				}else if(eTime==""){
					if(dateCheck(bTime)){
						
						selectCommonLoad(bTime,'empty',DeptMsg);
					}else{
						alert("格式不正确，输入时间应如:2018-05-09")
					}
				}else{
					 if(dateCheck(bTime)&&dateCheck(eTime)){
						
						selectCommonLoad(bTime,eTime,DeptMsg); 
					} else{
						alert("格式不正确，输入时间应如:2018-05-09")
					}
				}
			}
		}
		
		
		/*时间格式检查*/
		function dateCheck(date){
			if(isNaN(date)&&!isNaN(Date.parse(date))){
				return 1;
			}
		}
		/*时间部门查询的方法*/
		
		function selectCommonLoad(str1,str2,str3){
			let str ="#";
			alert(str);
			/* commonLoad(str); */
		}
		/*关键词查询*/
		function selectByKey(){
			/* <input class="wu-text" style="width:100px" id="key"> */
			var mykey = $("#myKey").val();
			
			let mykeyStr = "searchPositionByKey.do?key="+mykey;
			alert("mykeyStr"+mykeyStr)
			/* commonLoad(mykeyStr); */
		}

		/**
		* 公共部分
		*/
		function commonLoad(str){
			$('#wu-datagrid').datagrid({
				url:str,
				method:"get",//提交方式	
				rownumbers:true,//显示行号
				singleSelect:false,
				pagination: true, //如果表格需要支持分页，必须设置该选项为true
				pageSize: 3, //表格中每页显示的行数
				pageList: [3, 5, 10], 
				fitColumns:true,
				fit:true,
				columns:[[
					{ checkbox:true},
					{ field:'positionId',title:'职位id',width:8},
			
					{ field:'positionName',title:'职称',width:8},
					
					{ field:'departmentId',title:'部门id',width:8},
					
					{ field:'positionDesc',title:'职位描述',width:8},
					
					{ field:'positionCreateTime',title:'创建时间',width:15},
					
					{ field:'positionState',title:'职位状态',width:12}
				]]
			});
		}
		/**
		* 载入数据
		*/
		$(function(){
			commonLoad('selectPositionSql.do')
			selectDepartment()
		})
		/*刷新页面*/
		
		function reflesh(){
			commonLoad('selectPositionSql.do');
		}
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
				var depInf = "<option value='0'>--选择部门--</option>";
				for(let i=0; i<list.length; i++){
					var dep = list[i];
					depInf += "<option value='"+dep.departmentDes+"'>"+dep.departmentName+"</option>";
				}
				/* $("#selectDep").combobox('setValue',depInf); */
				$("#selectDep").html(depInf);
			},
			error : function() {//当ajax请求失败回调
				alert("ajax请求失败")
			}
		});
	}
	
	/*监听事件，下拉框,根据部门查询user*/
	/* $("#selectDep").change(function (){
		var myDepartMsg = $("#selectDep").val();
		var myStr = 'searchUserByDept.do?Department='+myDepartMsg;
		
		$("#beginTime").datebox("setValue","");
		$("#endTime").datebox("setValue","");
		commonLoad(myStr);
	}) */
	
	/**
	* 添加记录
	*/
	function add(){
		$('#wu-form').form('submit', {
			url:'addPosition.do',
			success:function(data){
				console.log(data)
				if(data==1){
					$.messager.alert('信息提示','添加成功！','info');
					$('#wu-dialog').dialog('close');
					//刷新
					$("#wu-datagrid").datagrid("load");
				}
				else
				{
					$.messager.alert('信息提示',data,'info');
				}
			}
		});
	}
	
	/**
	*  修改记录
	*/
	function edit(){
	
		$('#wu-form').form('submit', {
			url:'updatePosition.do',
			success:function(data){
				console.log(data)
				if(data==1){
					$.messager.alert('信息提示','修改成功！','info');
					$('#wu-dialog').dialog('close');
					//刷新
					$("#wu-datagrid").datagrid("load");
				}
				else
				{
					$.messager.alert('信息提示','修改失败！','info');
				}
			}
		});
	}
	
	/**
	*  删除记录
	*/
	function remove(){
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				var items = $('#wu-datagrid').datagrid('getSelections');
				console.log(items)
				var ids = "";
				$(items).each(function(){
					
					ids+=this.userId+","
				});
				console.log(ids)
			
				$.ajax({
					url:'delPosition.do',
					data:{id:ids},
					success:function(data){
						if(data!=""){
							$.messager.alert('信息提示','删除成功！','info');	
							//刷新
							$("#wu-datagrid").datagrid("load");
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
	function openAdd(){
		$('#wu-form').form('clear');
		$('#wu-dialog').dialog({
			closed: false,
			modal:true,
            title: "添加信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
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
	*  打开修改窗口
	*/
	function openEdit(){
		//获取选中行
		var item = $('#wu-datagrid').datagrid('getSelected');
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
	
</script>