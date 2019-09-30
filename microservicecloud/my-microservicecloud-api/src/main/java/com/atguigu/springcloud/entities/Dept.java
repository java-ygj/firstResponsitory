package com.atguigu.springcloud.entities;

import java.io.Serializable;
//Nosql���ݿ��û���������int long�ȵȣ����л����ڴ洢
//���л����ڴ��䣬�ֲ�ʽ�������ڴ��䡣
//���л��ӿ�ʵ�����ǿսӿڣ�ûʲô��������ʵ�����Ǹ���jvm���bean���Ա����л�
//https://www.jianshu.com/p/4935a87976e5

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@SuppressWarnings("serial")
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Data//set/get/toString/equals/hashCode
@Accessors(chain=true)//链式表达式
public class Dept implements Serializable{//串行化，在分布式开发中传数据有利
	private Long  deptno;  
	private String  dname;   
	
	private String  db_source;
	
//	public static void main(String[] args) {
//		Dept dept = new Dept();
//		dept.setDeptno(11l).setDb_source("db1").setDname("研发部");
//	}
}
