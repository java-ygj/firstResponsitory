package com.hqyj.personel.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.personel.po.Payment;
import com.hqyj.personel.service.PaymentService;

/**
 * 薪酬记录
 * @author SJY
 *
 */
@Controller
public class PaymentController {
	@Autowired
	private PaymentService service;
	
	/** 进入薪酬管理页面 */
	@RequestMapping(method = RequestMethod.GET,value = "toPaymentPage.do")
	public String toPaymentPage() {
		return "payment";
	}
	/** SQL分页 */
	@RequestMapping("paymentPage.do")
	@ResponseBody
	public HashMap<String, Object> paymentPage(Payment p){
		return service.paymentPage(p);
	}
	
	/**
	 * 添加薪酬管理
	 * @param payment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addPayment.do")
	public int addPayment(Payment payment) {
		// System.out.println("addPayment: "+ payment);
		return service.addPayment(payment);
	}
	
	/**
	 * 删除(一条或多条)
	 * @return
	 */
	@RequestMapping("deletePaymentIds.do")
	@ResponseBody
	public int deletePaymentIds(String[] ids) {
		int i =0;
		for (String string : ids) {
			int id = Integer.valueOf(string);
			if(id != 0) {
				i = service.deletePayment(id);
			}
		}
		return i;
	}

	/**
	 * 修改
	 * @param payment
	 * @return
	 */
	@RequestMapping("updatePayment.do")
	@ResponseBody
	public int updatePayment(Payment payment) {
		int i = service.updatePayment(payment);
		return i;
	}
	
	/**
	 * 模糊查询
	 * @param key
	 * @param cr
	 * @return
	 */
	@RequestMapping("searchPaymentByLike.do")
	@ResponseBody
	public HashMap<String, Object> searchPaymentByLike(String key, Payment payment){
		return service.searchPaymentByLike(key,payment);
	}
	
}
