package com.insurancequote.client;
	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.insurancequote.bean.AgentViewPolicyBean;
import com.insurancequote.bean.UserBean;
import com.insurancequote.bean.AccountBean;
import com.insurancequote.bean.PolicyBean;
	import com.insurancequote.bean.QuestionBean;
	import com.insurancequote.service.UnderWriterServiceImpl;
import com.insurancequote.service.AgentServiceImpl;
import com.insurancequote.service.IAgentService;
import com.insurancequote.service.IInsuredService;
import com.insurancequote.service.InsuredServiceImpl;
import com.insurancequote.service.UnderWriterService;

	public class Client {
		 static Scanner scanner=new Scanner(System.in);
		static UnderWriterService under=new UnderWriterService();
		static PolicyBean policyBean = new PolicyBean();
		static QuestionBean questionBean = new QuestionBean();
		static AccountBean insuredBean=new AccountBean();
		static IAgentService agentService=new AgentServiceImpl();
		static IInsuredService insuredService=null;
		public static void main(String[] args)  {
			System.out.println("welcome to login page");
			System.out.println("Enter username");
			String username=scanner.next();
			System.out.println("Enter Password");
			String password=scanner.next();

			UserBean bean=new UserBean();
			bean.setUserName(username);
			bean.setPassword(password);
			
			
			UnderWriterServiceImpl service=new UnderWriterServiceImpl();
			String role=service.validateUser(bean);
			
			if(role.equals("Insured"))
			{
			      
				if (username == null) {
					System.out.println("1.Account creation");
					System.out.println("2.View Policy");
					System.out.println("Enter the choice");
                  
					int option = scanner.nextInt();
					switch (option) {
					case 1:
						while(insuredBean==null)
						{
									try {
										insuredBean=populateBean();
										insuredService=new InsuredServiceImpl();
										insuredService.addDetails(insuredBean);
										System.out.println("Details Successfully Added");
									} catch (SQLException | IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								
						}
						
						break;
					case 2:
						System.out.println("enter the account number");
						Long number=scanner.nextLong();
						viewPolicy(number);
						break;
					default:
						System.out.println("enter correct credentials");
						break;
					}
				} 
				else if (username != null) {
					System.out.println("1.view policy");
					System.out.println("Enter the choice");
					int input =scanner.nextInt();
					if(input==1) {
						System.out.println("enter the account number");
						Long number=scanner.nextLong();
						viewPolicy(number);
					}
					else {
						System.out.println("enter the correct option");
					}
					
				}
				  }
				
				else if(role.equals("Agent"))
				{
			
					System.out.println("Agent logged in");
					System.out.println("1.Account creation");
					System.out.println("2.Policy creation");
					System.out.println("3.View Policy");
					System.out.println("Enter Your Choice");
					int opt1=scanner.nextInt();
					
					switch(opt1)
					{
					case 1:
						
						while(insuredBean==null) {
						try {
							insuredBean= populateBean() ;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						
						break;
					case 2:
						System.out.println("Enter Details for Policy Creation");
						
						
						
						break;
					case 3:
						System.out.println("Policies are:");
						AgentViewPolicyBean agentViewPolicyBean=new AgentViewPolicyBean();
						
							
							agentViewPolicyBean=agentService.viewAgentPolicy(username);
						
						if(agentViewPolicyBean!=null)
						{
							System.out.println("Policy Details of your customer");
							System.out.println("___________________________________________________\n");
							System.out.println("Insured Name:"+agentViewPolicyBean.getInsuredName());
							System.out.println("Policy Number: "+agentViewPolicyBean.getPolicyNumber());
							System.out.println("Policy Premium: "+agentViewPolicyBean.getPolicyPremium());
							System.out.println("Account No: "+agentViewPolicyBean.getAccountNumber());
							System.out.println("___________________________________________________\n");
							
						}
						if(agentViewPolicyBean==null)
						{
							System.out.println("___________________________________________________\n");
							System.out.println("Agent Name is invalid!!");
							System.out.println("___________________________________________________\n");
							System.exit(0);
						}
						break;
						
			        }
				}
					
				else
				{
					System.out.println("UnderWriter logged in");
					System.out.println("1.New Profile Creation");
					System.out.println("2.Account Creation");
					System.out.println("3.Policy Creation");
					System.out.println("4.view policy");
					System.out.println("5.Report Generation");
					System.out.println("Enter your choice");
					int opt2=scanner.nextInt();
					switch(opt2)
					{
					case 1:
						System.out.println("Enter Details for Creating profile");
						break;
					case 2:
						System.out.println("Enter Details for Account Creation");
						break;
					case 3:
						System.out.println("Enter Details for Policy creation");
						try {
							populateBean();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			                   									
					
						break;
					case 4:
						System.out.println("In view Policy");
						break;
					case 5:
						
						
						System.out.println("Report Generation");
						break;
						default:
							System.out.println("Enter correct number");
						
					
					
				}
				
			}
			
		}
		public static void viewPolicy(Long accountNumber) {
			List<PolicyBean> al=new ArrayList();
			 insuredService=new InsuredServiceImpl();
			try {
				al= insuredService.PolicyDetails(accountNumber);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(al);
		}
		private static AccountBean populateBean() throws  SQLException, IOException {
			AccountBean insuredBean=new AccountBean();
			System.out.println("Enter Insured Name:");
			insuredBean.setInsuredName(scanner.next());
			System.out.println("Enter Insured Street:");
			insuredBean.setInsuredStreet(scanner.next());
			System.out.println("Enter Insured City:");
			insuredBean.setInsuredCity(scanner.next());
			System.out.println("Enter Insured State:");
			insuredBean.setInsuredState(scanner.next());
			System.out.println("Enter Insured Zip:");
			insuredBean.setInsuredZip(scanner.nextLong());
			
			
			System.out.println("Choose Your Business Segment:");
			
				try {
					policyCreation();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Enter your account no:");
			insuredBean.setAccountNumber(scanner.nextLong());
			//check role if it is agent take username or enter manually
			System.out.println("Enter you unique Agent user name:");
			insuredBean.setAgentName(scanner.next());
//			validate the details entered by the user
			//check weather the agent name is already exist in the user table and account number no present in the table
//			AgentServiceIMPL agentServiceIMPL=new AgentServiceIMPL();
//			agentServiceIMPL.validateAgent(agentBean);
			return insuredBean;
			
		}
public static void policyCreation() throws ClassNotFoundException, IOException, SQLException {
	System.out.println("1.Business Auto");
	System.out.println("2.R																													estaurant");
	System.out.println("3.Apartment");
	System.out.println("4.General Merchant");
	 int option1 = scanner.nextInt();
	
	ArrayList<PolicyBean> al = new ArrayList<>();
	
	al = under.createPolicy();
	
	for(PolicyBean pBean:al) {
		System.out.println(pBean.getQuestion());
		System.out.println("1."+pBean.getAnswer1()+"\t"+"2."+pBean.getAnswer2()+"\t"+"3."+pBean.getAnswer3());
		System.out.println("enter the option");
		int option=scanner.nextInt();
		switch(option) {
		case 1:
			questionBean.setAnswer(pBean.getAnswer1());
			questionBean.setWeightage(pBean.getWeightage1());
			
			
			break;
		case 2:
			questionBean.setAnswer(pBean.getAnswer2());
			questionBean.setWeightage(pBean.getWeightage2());
			
			break;
		case 3:
			questionBean.setAnswer(pBean.getAnswer3());
			questionBean.setWeightage(pBean.getWeightage3());
			
			
			
			
			
		}
		questionBean.setQuestion(pBean.getQuestion());
		questionBean.setBusinessSegment(pBean.getBusinessSegment());
		 under.PolicyQuestion(questionBean);
		//in that method write query to insert  the details into the table 
		//and the method should return policy number and premium value too which is unique and primary key
		}

}
		
	}


