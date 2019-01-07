package com.insurancequote.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insurancequote.bean.UserBean;
import com.insurancequote.bean.AccountBean;
import com.insurancequote.bean.PolicyBean;
import com.insurancequote.util.DBConnection;

public class InsuredDaoImpl implements IInsuredDao {

	static Connection connection=null;
	static PreparedStatement preparedStatement=null;
	@Override
	public void addDetails(AccountBean insuredBean) throws SQLException, IOException {
		
		connection=DBConnection.getConnection();
		preparedStatement=connection.prepareStatement("insert into createaccount values(?,?,?,?,?,?,?,?)");
		preparedStatement.setString(1, insuredBean.getAgentName());
		preparedStatement.setString(2, insuredBean.getInsuredName());
		preparedStatement.setString(3, insuredBean.getInsuredStreet());
		preparedStatement.setString(4, insuredBean.getInsuredCity());
		preparedStatement.setString(5, insuredBean.getInsuredState());
		preparedStatement.setLong(6, insuredBean.getInsuredZip());
		preparedStatement.setLong(7, insuredBean.getAccountNumber());
		preparedStatement.setString(8, insuredBean.getBusinessSegment());
		preparedStatement.executeQuery();
		
		
		
		
		
	}
	@Override
	public String checkDetails(UserBean insuranceBean) throws SQLException, IOException {
		
		connection=DBConnection.getConnection();
		preparedStatement=connection.prepareStatement("select role from user where username=? AND  password=?");
		preparedStatement.setString(1,insuranceBean.getUserName());
		preparedStatement.setString(2,insuranceBean.getPassword());
		ResultSet resultSet=preparedStatement.executeQuery();
		String user_role=null;
		while(resultSet.next())
		{
			user_role=resultSet.getString(3);
		}
		
		
		return user_role;
		
		
		
	}
	@Override
	public List<PolicyBean> policyDetails(Long accountNumber) throws SQLException, IOException {
		
		List<PolicyBean> list=new ArrayList<>();
		connection=DBConnection.getConnection();
		preparedStatement=connection.prepareStatement("select * from policyaccount where accountnumber=?");
		preparedStatement.setLong(1,accountNumber);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			PolicyBean policyBean=new PolicyBean();
			
			policyBean.setQuestion(resultSet.getString(1));
			policyBean.setAnswer1(resultSet.getString(2));
			policyBean.setWeightage1(resultSet.getInt(3));
			policyBean.setAnswer2(resultSet.getString(4));
			policyBean.setWeightage2(resultSet.getInt(5));
			policyBean.setAnswer3(resultSet.getString(6));
			policyBean.setWeightage3(resultSet.getInt(7));
			policyBean.setBusinessSegment(resultSet.getString(8));
			
			list.add(policyBean);
		}
		return list;
	}

}
