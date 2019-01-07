package com.insurancequote.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.insurancequote.bean.UserBean;
import com.insurancequote.bean.PolicyBean;
import com.insurancequote.bean.QuestionBean;
import com.insurancequote.util.DBConnection;

public class DaoUnderWriterImpl implements IUnderWriterDao{

	
	QuestionBean questionBean = new QuestionBean();
	
	Connection con = null;
	PreparedStatement pst = null; 
	Statement cs=null;
	ResultSet rs= null;
	@Override
	public ArrayList<PolicyBean> createPolicy() throws ClassNotFoundException, IOException, SQLException {
		
		ArrayList<PolicyBean> al = new ArrayList<>();
		try {
		   con=DBConnection.getConnection();
		    cs=con.createStatement();
		    String val="Restaurant";
		    rs=cs.executeQuery("select * from policycreation where business_segment='"+val+"'");
			
			
			while(rs.next()) {
			PolicyBean policyBean=new PolicyBean();
				policyBean.setBusinessSegment(rs.getString(1));
				policyBean.setQuestion(rs.getString(2));
				policyBean.setAnswer1(rs.getString(3));
				policyBean.setWeightage1(rs.getInt(4));
				policyBean.setAnswer2(rs.getString(5));
				policyBean.setWeightage2(rs.getInt(6));
				policyBean.setAnswer3(rs.getString(7));
				policyBean.setWeightage3(rs.getInt(8));
				al.add(policyBean);
			}
			
			
		}
		catch(Exception e) {
			
		}
		
		return al;
	}

	@Override
	public String PolicyQuestion(QuestionBean ques) {
		
		try {
			 con=DBConnection.getConnection();
			  pst=con.prepareStatement("insert into QA values (?,?,?,?,?,?)");
			  
			 pst.setString(1, ques.getQuestion());
			 pst.setString(2, ques.getAnswer());
			 pst.setInt(3, ques.getWeightage());
			 pst.setString(4,ques.getBusinessSegment());
			 pst.setString(5, ques.getUsername());
			 pst.setInt(6, ques.getPremium());
			 int i=pst.executeUpdate();
           
			
			  
		}
		catch(Exception e)
		{
			System.out.println("Exception while Insertion");
		}
		return null;
	}

	@Override
	public String validateUser(UserBean bean) {
		
		return null;
	}

}
