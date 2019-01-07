package com.insurancequote.dao;



	import java.io.IOException;
	import java.sql.SQLException;
import java.util.List;

import com.insurancequote.bean.UserBean;
	import com.insurancequote.bean.AccountBean;
import com.insurancequote.bean.PolicyBean;

	public interface IInsuredDao {
		
	  public void addDetails(AccountBean insuredBean) throws SQLException, IOException;
	  
	  public  String checkDetails(UserBean insuranceBean) throws SQLException, IOException;

	public List<PolicyBean> policyDetails(Long accountNumber) throws SQLException, IOException;
	  
	  
	}

