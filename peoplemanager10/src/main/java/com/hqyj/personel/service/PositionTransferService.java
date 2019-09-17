package com.hqyj.personel.service;

import java.util.HashMap;

import com.hqyj.personel.po.PersonelTransferManager;

public interface PositionTransferService {

	HashMap<String, Object> loadPositionTransfer(PersonelTransferManager personelTransfer);

	String addPositionTransfer(PersonelTransferManager pTM, String positionDesc);


	HashMap<String, Object> searchTransferrByKey(String key, PersonelTransferManager ptm);

}
