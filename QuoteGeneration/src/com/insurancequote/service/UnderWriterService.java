package com.insurancequote.service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.insurancequote.bean.PolicyBean;
import com.insurancequote.bean.QuestionBean;
import com.insurancequote.dao.DaoUnderWriterImpl;
import com.insurancequote.dao.IUnderWriterDao;
import com.insurancequote.util.DBConnection;

public class UnderWriterService
{
	static IUnderWriterDao iDao=new DaoUnderWriterImpl();
	public ArrayList<PolicyBean> createPolicy() throws ClassNotFoundException, IOException, SQLException{
		
		ArrayList<PolicyBean> al = new ArrayList<>();
		al = iDao.createPolicy();
		return al;
	}
	public String PolicyQuestion(QuestionBean question) {
		

		 String number=iDao.PolicyQuestion(question);
		 return number;
	}
}


/*public ArrayList<PolicyBean> createPolicy(){
	Connection con = DBConnection.getConnection();
	PreparedStatemenet preparedStatement=null;  
	ResultSet rs= null;
	try {
		preparedStatement = con.prepareStatement("select * from businesssegment");
		rs = preparedStatemenet.executeQuery();
		ArrayList<PolicyBean> al = new ArrayList<>();
		while(rs.hasNext()) {
			BusinessSegement bs = new BusinessSegement();
			bs.setname(rs.getString(1));
			bs.setId(rs.getString(2));
			al.add(bs);
		}
		return al;
	}
	catch(Exception e) {
		
	}
}*/