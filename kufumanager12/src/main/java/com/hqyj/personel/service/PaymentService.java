package com.hqyj.personel.service;

import java.util.HashMap;

import com.hqyj.personel.po.Payment;

public interface PaymentService {
	/** 分页 */
	HashMap<String, Object> paymentPage(Payment p);
	
	/** 添加一个薪酬 */
	int addPayment(Payment payment);
	/** 删除数据 */
	int deletePayment(int paymentId);
	/** 修改 */
	int updatePayment(Payment payment);
	/** 模糊查询 */
	HashMap<String, Object> searchPaymentByLike(String key, Payment payment);
	
}
