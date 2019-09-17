package com.hqyj.personel.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.TestPo;

public interface MyTestService {

	String login(TestPo tp, RedirectAttributes redirectAttributes);

}
