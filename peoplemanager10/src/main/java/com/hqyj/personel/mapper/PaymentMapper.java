package com.hqyj.personel.mapper;

import java.util.List;

import com.hqyj.personel.po.Payment;

public interface PaymentMapper {
    /** 分页查询 */
	List<Payment> paymentPage(Payment p);
	/** 总条数 */
	int countPayment();
	
	/** 添加薪酬 */
	int addPayment(Payment payment);
	/** 删除数据 */
	int deletePayment(int paymentId);
	/** 修改 */
	int updatePayment(Payment payment);
	
	/** 模糊查询 */
	List<Payment> searchPaymentByLike(Payment payment);
	/** 模糊查询的总条数 */
	int countPaymentByLike(Payment payment);	
}