package com.insurancequote.service;



	import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

	import com.insurancequote.bean.AccountBean;
	import com.insurancequote.bean.PolicyBean;
	public interface IInsuredService {

		
			  public void addDetails(AccountBean insuredBean) throws SQLException, IOException;
			 public List<PolicyBean> PolicyDetails(Long accountNumber) throws SQLException, IOException;
	}

