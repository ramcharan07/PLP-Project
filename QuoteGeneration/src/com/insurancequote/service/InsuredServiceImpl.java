package com.insurancequote.service;
import com.insurancequote.dao.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancequote.bean.AccountBean;
import com.insurancequote.bean.PolicyBean;

public class InsuredServiceImpl implements IInsuredService{

	static IInsuredDao insuredDao=null;
	@Override
	public void addDetails(AccountBean insuredBean) throws SQLException, IOException {
		
		insuredDao=new InsuredDaoImpl();
		insuredDao.addDetails(insuredBean);
		
	}

	@Override
	public List<PolicyBean> PolicyDetails(Long accountNumber) throws SQLException, IOException {
		
		List<PolicyBean> list=new ArrayList<>();
		insuredDao=new InsuredDaoImpl();
		list=insuredDao.policyDetails(accountNumber);
		
		return list;
	}

}
