package com.hqyj.personel.service;

import java.util.HashMap;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.SatffRecord;

public interface SatffRecordService {

	HashMap<String, Object> getRecordBySql(SatffRecord sr);

	int addRecord(SatffRecord sr,RedirectAttributes redirectAttributes);

	int updateRecord(SatffRecord sr);

	int delRecordByIds(String id);

}
