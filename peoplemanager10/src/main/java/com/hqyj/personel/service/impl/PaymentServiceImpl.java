package com.hqyj.personel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.personel.mapper.PaymentMapper;
import com.hqyj.personel.po.Payment;
import com.hqyj.personel.service.PaymentService;
import com.hqyj.personel.vo.PaymentVO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentMapper mapper;

	/**
	 * 分页查询薪资
	 */
	@Override
	public HashMap<String, Object> paymentPage(Payment p) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (p.getPage() - 1) * p.getRows();
		p.setStart(start);
		// 查询结果集
		List<Payment> list = mapper.paymentPage(p);
		List<PaymentVO> list2 = new ArrayList<>();
		// 因为payment中有日期，要将日期显示出来
		for (int i = 0; i < list.size(); i++) {
			Payment payment = list.get(i);
			list2.add(new PaymentVO(payment.getPaymentId(), payment.getEmployeeNo(), payment.getBasicPayment(),
					payment.getPerformance(), payment.getReward(), payment.getPunishment(), payment.getSalary(),
					payment.strSalaryTime()));
		}
		// 总条数
		int total = mapper.countPayment();

		map.put("total", total);
		map.put("rows", list);

		return map;
	}

	/**
	 * 添加一个薪酬
	 */
	@Override
	public int addPayment(Payment payment) {
		// 基本工资 +
		float a = payment.getBasicPayment();
		// 绩效工资 +
		float b = payment.getPerformance();
		// 奖金 +
		float c = payment.getReward();
		// 罚款 -
		float d = payment.getPunishment();
		// 薪酬
		float salary = a + b + c - d;
		payment.setSalary(salary);
		int i = mapper.addPayment(payment);
		return i;
	}

	/**
	 * 删除数据
	 */
	@Override
	public int deletePayment(int paymentId) {
		return mapper.deletePayment(paymentId);
	}

	/**
	 * 修改
	 */
	@Override
	public int updatePayment(Payment payment) {
		// 基本工资 +
		float a = payment.getBasicPayment();
		// 绩效工资 +
		float b = payment.getPerformance();
		// 奖金 +
		float c = payment.getReward();
		// 罚款 -
		float d = payment.getPunishment();
		// 薪酬
		float salary = a + b + c - d;
		payment.setSalary(salary);
		int i = mapper.updatePayment(payment);
		return i;
	}

	@Override
	public HashMap<String, Object> searchPaymentByLike(String key, Payment payment) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (payment.getPage()-1)*payment.getRows();
		payment.setStart(start);
		payment.setEmployeeNo("%"+key+"%");
		
		// 查询结果集
		List<Payment> list = mapper.searchPaymentByLike(payment);
		// 模糊查询的总条数
		int total = mapper.countPaymentByLike(payment);
		
		map.put("total", total);
		map.put("rows", list);
		
		return map;
	}

}
