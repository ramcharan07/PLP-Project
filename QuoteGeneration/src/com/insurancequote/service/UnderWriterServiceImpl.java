package com.insurancequote.service;

import com.insurancequote.bean.UserBean;
import com.insurancequote.dao.DaoUnderWriterImpl;
import com.insurancequote.dao.IUnderWriterDao;

public class UnderWriterServiceImpl {
static IUnderWriterDao daoInsurance=null;
	public String validateUser(UserBean bean) {
		String validate=null;
		daoInsurance=new DaoUnderWriterImpl();
		validate=daoInsurance.validateUser(bean);
		return validate;
		
		
	}

}
