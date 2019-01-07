package com.insurancequote.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.insurancequote.bean.UserBean;
import com.insurancequote.bean.PolicyBean;
import com.insurancequote.bean.QuestionBean;


public interface IUnderWriterDao {
	public  ArrayList<PolicyBean> createPolicy() throws ClassNotFoundException, IOException, SQLException;


	public String PolicyQuestion(QuestionBean question);


	public String validateUser(UserBean bean);
	
}
