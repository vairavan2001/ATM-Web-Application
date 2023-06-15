package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Interface i;
	@Autowired
	Interface1 i1;
	@Autowired
	Interface2 i2;
	@Autowired
	Interface3 i3;
	@Autowired
	Interface4 i4;
	@Autowired
	Interface5 i5;
	public String username="";
	public String password="";
	public int opening_balance;
	public int pin;
	public String card_number="";
	public int customerid1;
	public long accountnumber;
	public int amo;
	public int checknumber;
	public long mobilenumber;
	public String bankname;
	HttpSession session;
	@RequestMapping("/customer")
public String customer(HttpServletRequest req) {
	username=req.getParameter("username");
	password=req.getParameter("password");
	List a = i.findByUsernameAndPassword(req.getParameter("username"),req.getParameter("password"));
	if(a.size()>=1) {
		return "CustomerMainPage";
	}
	else {
		return "LoginPageError(c)";
	}
}
	@RequestMapping("/admin")
	public String admin(HttpServletRequest req,HttpServletResponse res) {
		username=req.getParameter("username");
		password=req.getParameter("password");
		List a = i1.findByUsernameAndPassword(username,password);
		if(a.size()>=1) {
			return "AdminWelcomePage";
		}
		else {
			return "LoginPageError";
		}
	}
	@RequestMapping("/addbranch")
	public String addBranch(Bean2 b) {
		try {
		i2.save(b);
		return "BranchAddSucess";
		}
		catch(Exception e) {
			return "BranchAddError";
		}
	}
	@RequestMapping("/addcustomer")
	public String addcustomer(Bean3 b ,HttpServletRequest req) {
		try {
			List l=i2.findBybranchname(req.getParameter("branchname"));
			List l1=i3.findByPanAndBranch(req.getParameter("pancardnumber"),req.getParameter("branchname"));
			int j=0;
			long ac=0;
			String s="";
			String m="";
			int pin=0;
			String array[];
			List l3=i3.accountNumber(501255100,"Savings");
			List l5=i3.accountNumber(501467100,"Current");
			
			if(l.size()==1 & l1.size()!=1) {
				if(req.getParameter("accounttype").equals("Savings")) {
				if(l3.size()!=0) {
					s= l3.get(l3.size()-1).toString();
					char ar[]=s.toCharArray();
					for(int k=6;k<=8;k++) {
					m+=ar[k];
					}
					j =Integer.parseInt(m);
					
					}
					else {
						j=100;
					}
				
					ac=501255;
					for(int i=j+1;i<1000;i++) {
						ac=(ac*1000)+i;
						break;
					}
				}
				else {
					if(l5.size()!=0) {
						s= l5.get(l5.size()-1).toString();
						char ar[]=s.toCharArray();
						for(int k=6;k<=8;k++) {
						m+=ar[k];
						}
						j =Integer.parseInt(m);
						
						}
						else {
							j=100;
						}
					ac=501467;
					for(int i=j+1;i<1000;i++) {
						ac=(ac*1000)+i;
						break;
					}
				}
				b.setAccountnumber(ac);
			}
			else {
				return"AddCustomerError";
			}
			List lp = i3.pin();
			if(lp.size()!=0) {
				pin=(int) lp.get(lp.size()-1);
				pin+=1;
			}
			else {
				pin=1021;
			}
			for(int i=pin;i<9000;i++) {
			pin=pin;	
			}
			b.setPin(pin);
			List l4=i3.cardnumber();
			if(l4.size()!=0) {
				s="";
				s=(String) l4.get(l4.size()-1);
				array=s.split("-");
				j=Integer.parseInt(array[0]);
				array[0]=Integer.toString(j+1);
				j=Integer.parseInt(array[1]);
				array[1]=Integer.toString(j+1);
				j=Integer.parseInt(array[2]);
				array[2]=Integer.toString(j+1);
				j=Integer.parseInt(array[3]);
				array[3]=Integer.toString(j+1);
				s=array[0]+"-"+array[1]+"-"+array[2]+"-"+array[3];
			}
			else {
			s="4256-2685-8532-5296";
			}
			b.setCardnumber(s);
			b.setPinchange(0);
			i3.save(b);
			return"AddCustomerSucess";
		}
		catch(Exception e){
			//return "Error";
			return null;
		}
		
	}
	@RequestMapping("/closeaccount")
	public String closeaccount(Bean3 b,HttpServletRequest req) {
		try {
		int len=i3.closeAccount(Integer.parseInt(req.getParameter("customerid")) ,Long.parseLong(req.getParameter("accountnumber")));
		int len1=i4.closeAccount(Integer.parseInt(req.getParameter("customerid")));
		if(len==1) {
			return"CloseAccountSucess";
		}
		else {
		return "CloseAccountError";
		}
		}
		catch(Exception e) {
			return "Error";
		}
	}
	@RequestMapping("/changebranch")
	public String changeBranch(HttpServletRequest req) {
		List l=i2.findBybranchname(req.getParameter("branchname"));
		if(l.size()==1) {
			int i=i3.changeBranch(req.getParameter("branchname"),Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")));
			if(i==1) {
				req.setAttribute("accountnumber", req.getParameter("accountnumber"));
				req.setAttribute("branch",req.getParameter("branchname"));
				RequestDispatcher rs= req.getRequestDispatcher("ChangeBranchSucess");
			return "ChangeBranchSucess";
			}
			else {
				return"ChangeBranchError";
			}
		}
		else {
			return "BranchNotFoundError";
		}
	}
	@RequestMapping("/changefathername")
	public String changeFatherName(HttpServletRequest req) {
		int l=i3.changeFatherName(req.getParameter("fathername"),Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")));
	if(l==1) {
		return"ChangeFatherNameSucess";
	}
	else {
		return"ChangeFatherNameError";
	}
	}
	@RequestMapping("/changemobilenumber")
	public String changeMobileNumber(HttpServletRequest req) {
		int l=i3.changeMobileNumber(Long.parseLong(req.getParameter("mobilenumber")),Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")));
		int l1=i.changemobilenumber(Long.parseLong(req.getParameter("mobilenumber")),Integer.parseInt(req.getParameter("customerid")));
		if(l==1) {
		return"ChangeMobileNumberSucess";
	}
	else {
		return"ChangerMobileNumberError";
	}
	}
	@RequestMapping("/changename")
	public String changeName(HttpServletRequest req) {
		int l=i3.changeName(req.getParameter("name"),Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")));
	if(l==1) {
		return"ChangeNameSucess";
	}
	else {
		return"ChangeNameError";
	}
	}
	@RequestMapping("/changepermanentaddress")
	public String changePermanentAddress(HttpServletRequest req) {
		int l=i3.changePermanentAddress(req.getParameter("permanentaddress"),Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")));
	if(l==1) {
		return"ChangePermanentAddressSucess";
	}
	else {
		return"ChangePermanentAddressError";
	}
	}
	
	@RequestMapping("/changepresentaddress")
	public String changePresentAddress(HttpServletRequest req) {
		int l=i3.changePresentAddress(req.getParameter("presentaddress"),Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")));
	if(l==1) {
		return"ChangePresentAddressSucess";
	}
	else {
		return"ChangePresentAddressError";
	}
	}
	@RequestMapping("/statement")
	public String accountstatement(HttpServletRequest req , HttpServletResponse res) throws SQLException, IOException {
		try {
		Bean3 b3=new Bean3(); 
		PrintWriter pw = res.getWriter(); 	
		res.setContentType("text/html");
		List<Bean3> customer_details=i3.customerdetails(Integer.parseInt(req.getParameter("customerid")), Long.parseLong(req.getParameter("accountnumber")));
		String cd[]=customer_details.get(0).toString().split("=");
		String s="";
		pw.print("<link rel=\"shortcut icon\" href=\"https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg\">");
		pw.print("<style> body{background-image:url('http://sfwallpaper.com/images/nice-background-image-for-website-2.jpg');} img{ width:70px;height:40px;border-radius=50%;}p{font-size:30px;} button{ background-color:skyblue;border: none;color: Black;text-align: center;text-decoration: none;display: inline-block;font-size: 18px;border-radius:12px;width:200px;height:50px;align:center;font-family:Century Gothic; margin-bottom:20px; margin-right:30px;margin-left:30px} button:hover{background-color:green;color:white;}</style>");
		pw.print("<table align='center'><tr><td>");
		pw.print("<img src=\"https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg\"  alt=\"Loding...\"></img></td>");
		pw.print("<td><b><p>XYZ Bank</p><b></td></tr></table>");
		for(int i=0;i<1;i++){
			pw.print("<table style='margin:50px ;font-size:25px'; width='1400px' height='0px ' cellpadding='10px'><tr><td width='500px'>");
			pw.print("Name :"+cd[0]+"<br>"+"Address :"+cd[5]+"<br>"+"Mobile number:"+cd[7]+"<br>"+"Account Type :" + cd[9]+"<br>"+"Account Number :"+cd[12]+"<br>"+"Customer Id :"+cd[15]+"<br></td>"+"<td align='right'>"+"Branch Name :"+cd[11]+"<br>");
			 s= cd[11];
		}
		
		List<Bean2>branch=i2.branch(s);
		String b[]=branch.get(0).toString().split("=");
		for(int i=0;i<1;i++){
			pw.print("Branch code :"+b[0]+"<br>"+"MICR Code :"+b[2]+"<br>"+"IFSC Code :"+b[3]+"<br>"+"Branch Address :"+b[4]+"<br>"+"Telephone Number :"+b[5]+"</td></tr></table>");
		}
		List <Bean4> l=i4.generatestatement(Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("accountnumber")),req.getParameter("fromdate"),req.getParameter("todate"));
		pw.print("<hr>");
		pw.print("<h2 align='center'>Bank Statement</h2>");
		pw.print("<table border='1' align='center'cellpadding='20px' margin-top='100px';margin-left='50px' margin-right='50px'width='1400px' text-align='center' style='border-collapse: collapse ; font-size:20px''");
		pw.print("<tr'><th>S.No</th>"+"</th><th>"+"DATE"+"</th><th>"+"TRANSFERED ACCOUNT"+"</th><th>"+"CHEQUE NUMBER"+"</th><th>"+"WITHDRAWAL AMOUNT"+"</th><th>"+"DEPOSITE AMOUNT"+"</th><th>"+"CLOSING BALANCE"+"</th></tr>");
		int i=0;
		String sta[];
		pw.print("<style> font:hover{background-color:yellow } </style> ");
		for(int k=0;k<l.size();k++) {
			sta=l.get(k).toString().split("=");
		for(int m=0;m<1;m++) {
			if(sta[3].equals("0") || sta[7].equals("0")) {
			i+=1;
			pw.print("<tr><td style='text-align:center'><font>"+i+"</font></td><td style='text-align:center'><font>"+sta[1]+"</font></td><td style='text-align:center'><font>"+sta[5]+"</font></td><td style='text-align:center'><font>"+" "+"</font></td><td style='text-align:center'><font>"+sta[6]+"</font></td><td style='text-align:center'><font>"+" "+"</font></td><td style='text-align:center'><font>"+sta[8]+"</font></td></tr>");
			}
			else {
				i+=1;
				pw.print("<tr><td style='text-align:center'><font>"+i+"</font></td><td style='text-align:center'><font>"+sta[1]+"</font></td><td style='text-align:center'><font>"+sta[5]+"</font></td><td style='text-align:center'><font>"+sta[3]+"</font></td><td style='text-align:center'><font>"+sta[6]+"</font></td><td style='text-align:center'><font>"+sta[7]+"</font></td><td style='text-align:center'><font>"+sta[8]+"</font></td></tr>");
			}
			}
		}
		pw.print("</table>");
		pw.print("</body>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<button style='float:left;' onClick=window.print()><b>Print</b></button>");
		pw.print("<button style='float:right;' onClick=location.href='admin_page;'><b>Back</b></button>");
		return null;
		}
		catch (Exception e) {
			return "ChangePresentAddressError";
		}
	}
	@RequestMapping("/new_pin")
	public String newpin(HttpServletRequest req) {
		List <Bean>l=i.findByUsernameAndPassword(username, password);
		List <Integer> list=i3.checkpinchange(Integer.parseInt(username));
		if(l.size()==1 && list.get(0)==0) {
		int num=i3.changepin(Integer.parseInt(req.getParameter("newpin")), Integer.parseInt(username),0);
		int n=i3.addcount(1, Integer.parseInt(username));
		if(num==1) {
		return "ChangePinSucess";
		}
		else {
			return"Error";
		}
		}
		else {
			return"AlreadyChangedError";
		}
	}
	
	@RequestMapping("/get_cash")
	public String getcash(HttpServletRequest req) {
		try {
		List <Integer> l =i3.getCash(Integer.parseInt(username),req.getParameter("cardnumber"),Integer.parseInt(req.getParameter("pin")));
		opening_balance=l.get(0);
		return"AmountEnterPage";
		}
		catch (Exception e){
			return"InvalidPin";
		}
	}
	
	
	@RequestMapping("/fast_cash")
	public String fc(HttpServletRequest req) {
		try {
		card_number=req.getParameter("cardnumber");
		pin =Integer.parseInt(req.getParameter("pin"));
		List <Integer> l =i3.getCash(Integer.parseInt(username),req.getParameter("cardnumber"),Integer.parseInt(req.getParameter("pin")));
		opening_balance=l.get(0);
		return"FastMainPage";
		}
		catch(Exception e){
			return"InvalidPin";
		}
	}
	
	@RequestMapping("/get_amount")
	public String ga(Bean4 b,HttpServletRequest req) {
		try {
			int amount=(opening_balance-Integer.parseInt(req.getParameter("amount")));
			int wamount=Integer.parseInt(req.getParameter("amount"));
			if(opening_balance!=0 && amount>=0) {
				if(wamount>=100 && wamount<=10000){
					if(wamount%100==0) {
						List<Long> b3=i3.accountnumber(Integer.parseInt(username));
						int i=i3.updateopeningamount(amount, Integer.parseInt(username));
						if(i==1) {
						DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();
						b.setTransactiondate(date.format(now).toString());
						b.setChequenumber(0);
						b.setWithdrawalamount(Integer.parseInt(req.getParameter("amount")));
						b.setDepositeamount(0);
						b.setCustomerid(Integer.parseInt(username));
						b.setClosingbalance(amount);
						b.setTransactionaccount("From ATM");
						b.setAccountnumber((b3.get(0)));
						i4.save(b);
						return"GetAmountSucess";
						}
						else {
							return"Error";
						}
					}
					else {
						return"InvalidAmount";
					}
				}
				else {
					return"InvalidAmount";
				}
				}
		else {
			return"InsufficientBalance";
		}
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	@RequestMapping("/fast_cash_1000")
	public String fc1000(Bean4 b,HttpServletRequest req) {
		try {
			int amount=(opening_balance-1000);
			int wamount=1000;
			if(opening_balance!=0 && amount>=0) {
				if(wamount>=100 && wamount<=10000){
					if(wamount%100==0) {
						List<Long> b3=i3.accountnumber(Integer.parseInt(username));
						int i=i3.updateopeningamount(amount, Integer.parseInt(username));
						if(i==1) {
						DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();
						b.setTransactiondate(date.format(now).toString());
						b.setChequenumber(0);
						b.setWithdrawalamount(1000);
						b.setDepositeamount(0);
						b.setCustomerid(Integer.parseInt(username));
						b.setClosingbalance(amount);
						b.setTransactionaccount("From ATM-Fast Cash");
						b.setAccountnumber((b3.get(0)));
						i4.save(b);
						return"GetAmountSucess";
						}
						else {
							return"Error";
						}
					}
					else {
						return"InvalidAmount";
					}
				}
				else {
					return"InvalidAmount";
				}
				}
		else {
			return"InsufficientBalance";
		}
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	
	@RequestMapping("/fast_cash_2000")
	public String fc2000(Bean4 b,HttpServletRequest req) {
		try {
			int amount=(opening_balance-2000);
			int wamount=2000;
			if(opening_balance!=0 && amount>=0) {
				if(wamount>=100 && wamount<=10000){
					if(wamount%100==0) {
						List<Long> b3=i3.accountnumber(Integer.parseInt(username));
						int i=i3.updateopeningamount(amount, Integer.parseInt(username));
						if(i==1) {
						DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();
						b.setTransactiondate(date.format(now).toString());
						b.setChequenumber(0);
						b.setWithdrawalamount(2000);
						b.setDepositeamount(0);
						b.setCustomerid(Integer.parseInt(username));
						b.setClosingbalance(amount);
						b.setTransactionaccount("From ATM-Fast Cash");
						b.setAccountnumber((b3.get(0)));
						i4.save(b);
						return"GetAmountSucess";
						}
						else {
							return"Error";
						}
					}
					else {
						return"InvalidAmount";
					}
				}
				else {
					return"InvalidAmount";
				}
				}
		else {
			return"InsufficientBalance";
		}
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	@RequestMapping("/fast_cash_5000")
	public String fc5000(Bean4 b,HttpServletRequest req) {
		try {
			int amount=(opening_balance-5000);
			int wamount=5000;
			if(opening_balance!=0 && amount>=0) {
				if(wamount>=100 && wamount<=10000){
					if(wamount%100==0) {
						List<Long> b3=i3.accountnumber(Integer.parseInt(username));
						int i=i3.updateopeningamount(amount, Integer.parseInt(username));
						if(i==1) {
						DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();
						b.setTransactiondate(date.format(now).toString());
						b.setChequenumber(0);
						b.setWithdrawalamount(5000);
						b.setDepositeamount(0);
						b.setCustomerid(Integer.parseInt(username));
						b.setClosingbalance(amount);
						b.setTransactionaccount("From ATM-Fast Cash");
						b.setAccountnumber((b3.get(0)));
						i4.save(b);
						return"GetAmountSucess";
						}
						else {
							return"Error";
						}
					}
					else {
						return"InvalidAmount";
					}
				}
				else {
					return"InvalidAmount";
				}
				}
		else {
			return"InsufficientBalance";
		}
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	
	@RequestMapping("/fast_cash_10000")
	public String fc10000(Bean4 b,HttpServletRequest req) {
		try {
			int amount=(opening_balance-10000);
			int wamount=10000;
			if(opening_balance!=0 && amount>=0) {
				if(wamount>=100 && wamount<=10000){
					if(wamount%100==0) {
						List<Long> b3=i3.accountnumber(Integer.parseInt(username));
						int i=i3.updateopeningamount(amount, Integer.parseInt(username));
						if(i==1) {
						DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 LocalDateTime now = LocalDateTime.now();
						b.setTransactiondate(date.format(now).toString());
						b.setChequenumber(0);
						b.setWithdrawalamount(10000);
						b.setDepositeamount(0);
						b.setCustomerid(Integer.parseInt(username));
						b.setClosingbalance(amount);
						b.setTransactionaccount("From ATM-Fast Cash");
						b.setAccountnumber((b3.get(0)));
						i4.save(b);
						return"GetAmountSucess";
						}
						else {
							return"Error";
						}
					}
					else {
						return"InvalidAmount";
					}
				}
				else {
					return"InvalidAmount";
				}
				}
		else {
			return"InsufficientBalance";
		}
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	@RequestMapping("/view_balance")
	public ModelAndView vb() {
		List <Integer> l =i3.balance(Integer.parseInt(username));
		opening_balance=l.get(0);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Balance");
		mv.addObject("balance",opening_balance);
		return mv;
	}
	
	@RequestMapping("/mini_statement")
	public String ministatement(HttpServletRequest req , HttpServletResponse res) throws SQLException, IOException {
		try {
		Bean3 b3=new Bean3(); 
		PrintWriter pw = res.getWriter(); 	
		res.setContentType("text/html");
		List<Bean3> customer_details=i3.minicustomer(Integer.parseInt(username));
		String cd[]=customer_details.get(0).toString().split("=");
		String s="";
		pw.print("<link rel=\"shortcut icon\" href=\"https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg\">");
		pw.print("<style> body{background-image:url('http://sfwallpaper.com/images/nice-background-image-for-website-2.jpg');} img{ width:70px;height:40px;border-radius=50%;}p{font-size:30px;} button{ background-color:skyblue;border: none;color: Black;text-align: center;text-decoration: none;display: inline-block;font-size: 18px;border-radius:12px;width:200px;height:50px;align:center;font-family:Century Gothic; margin-bottom:20px; margin-right:30px;margin-left:30px} button:hover{background-color:green;color:white;}</style>");
		pw.print("<table align='center'><tr><td>");
		pw.print("<img src=\"https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg\"  alt=\"Loding...\"></img></td>");
		pw.print("<td><b><p>XYZ Bank</p><b></td></tr></table>");
		for(int i=0;i<1;i++){
			pw.print("<table style='margin:50px ;font-size:25px'; width='1400px' height='0px ' cellpadding='10px'><tr><td width='500px'>");
			pw.print("Name :"+cd[0]+"<br>"+"Address :"+cd[5]+"<br>"+"Mobile number:"+cd[7]+"<br>"+"Account Type :" + cd[9]+"<br>"+"Account Number :"+cd[12]+"<br>"+"Customer Id :"+cd[13]+"<br></td>"+"<td align='right'>"+"Branch Name :"+cd[11]+"<br>");
			 s= cd[11];
		}
		
		List<Bean2>branch=i2.branch(s);
		String b[]=branch.get(0).toString().split("=");
		for(int i=0;i<1;i++){
			pw.print("Branch code :"+b[0]+"<br>"+"MICR Code :"+b[2]+"<br>"+"IFSC Code :"+b[3]+"<br>"+"Branch Address :"+b[4]+"<br>"+"Telephone Number :"+b[5]+"</td></tr></table>");
		}
		List <Bean4> l=i4.ministatement(Integer.parseInt(username));
		pw.print("<hr>");
		pw.print("<h2 align='center'>Bank Statement</h2>");
		pw.print("<table border='1' align='center'cellpadding='20px' margin-top='100px';margin-left='50px' margin-right='50px'width='1400px' text-align='center' style='border-collapse: collapse ; font-size:20px''");
		pw.print("<tr'><th>S.No</th>"+"</th><th>"+"DATE"+"</th><th>"+"TRANSFERED ACCOUNT"+"</th><th>"+"CHEQUE NUMBER"+"</th><th>"+"WITHDRAWAL AMOUNT"+"</th><th>"+"DEPOSITE AMOUNT"+"</th><th>"+"CLOSING BALANCE"+"</th></tr>");
		int i=0;
		int j=0;
		String sta[];
		pw.print("<style> font:hover{background-color:yellow } </style> ");
		if((l.size()-1)<10) {
			j=l.size();
		}
		else {
			j=10;
		}
		for(int k=j;k>0;k--) {
			sta=l.get(k).toString().split("=");
		for(int m=0;m<1;m++) {
			if(sta[3].equals("0") || sta[7].equals("0")) {
			i+=1;
			pw.print("<tr><td style='text-align:center'><font>"+i+"</font></td><td style='text-align:center'><font>"+sta[1]+"</font></td><td style='text-align:center'><font>"+sta[5]+"</font></td><td style='text-align:center'><font>"+" "+"</font></td><td style='text-align:center'><font>"+sta[6]+"</font></td><td style='text-align:center'><font>"+" "+"</font></td><td style='text-align:center'><font>"+sta[8]+"</font></td></tr>");
			}
			else {
				i+=1;
				pw.print("<tr><td style='text-align:center'><font>"+i+"</font></td><td style='text-align:center'><font>"+sta[1]+"</font></td><td style='text-align:center'><font>"+sta[5]+"</font></td><td style='text-align:center'><font>"+sta[3] +"</font></td><td style='text-align:center'><font>"+sta[6]+"</font></td><td style='text-align:center'><font>"+sta[7]+"</font></td><td style='text-align:center'><font>"+sta[8]+"</font></td></tr>");
			}
			}
		}
		pw.print("</table>");
		pw.print("</body>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<br>");
		pw.print("<button style='float:left;' onClick=window.print()><b>Print</b></button>");
		pw.print("<button style='float:right;' onClick=location.href='customer_page;'><b>Back</b></button>");
		return null;
		}
		catch (Exception e) {
			return "Error";
		}
	}
	
	@RequestMapping("/deposit_cheque")
	public String dc(Bean5 b,HttpServletRequest req) {
		try {
		b.setCustomerid(Integer.parseInt(username));
		List<Long> b3=i3.accountnumber(Integer.parseInt(username));
		b.setAccountnumber(b3.get(0));
		b.setChequenumber(Integer.parseInt(req.getParameter("chequenumber")));
		b.setAmount(Integer.parseInt(req.getParameter("amount")));
		b.setStatus("Not Cleared");
		b.setBankname(req.getParameter("bankname"));
		i5.save(b);
		return"DepositSucess";
		}
		catch(Exception e) {
			return "Error";
		}
	}
	
	@RequestMapping(value="/check_cheque")
	public String cc(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException {
		try {
		List <Bean5>l=i5.status("Not Cleared");
		String s[]=l.get(0).toString().toString().split("=");
		customerid1=Integer.parseInt(s[1]);
		List <String> l1=i3.branch(customerid1);
		checknumber=Integer.parseInt(s[3]);
		amo=Integer.parseInt(s[4]);
		bankname=s[6];
		accountnumber=Integer.parseInt(s[2]);
		req.setAttribute("customerid", s[1]);
		req.setAttribute("checknumber", s[3]);
		req.setAttribute("amount", s[4]);
		req.setAttribute("accountnumber",s[2]);
		req.setAttribute("bankname",s[6]);
		req.setAttribute("branchname", l1.get(0));
		RequestDispatcher rd= req.getRequestDispatcher("CheckCheque");
		return"CheckCheque";
		}
		catch(Exception e){
			return "CheckChequeError";
		}
	}
	@RequestMapping(value="/clear_cheque")
	@ResponseBody
	public String cch(Bean4 b,HttpServletRequest req,HttpServletResponse res) {
		try {
		List <Integer>l=i3.checkopeningbalance(customerid1);
		b.setAccountnumber(accountnumber);
		b.setCustomerid(customerid1);
		b.setChequenumber(checknumber);
		b.setClosingbalance(l.get(0)+amo);
		b.setDepositeamount(amo);
		b.setTransactionaccount("Deposit Cheque - "+bankname);
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDateTime now = LocalDateTime.now();
		b.setTransactiondate(date.format(now).toString());
		b.setWithdrawalamount(0);
		i3.updateopeningamount((l.get(0)+amo),customerid1);
		i4.save(b);
		int i=i5.changeStatus("Cleared", customerid1, checknumber);
		if(i==1) {
			res.sendRedirect("check_cheque");
		return null;
		}
		else {
			return"CheckChequeError";
		}
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	@RequestMapping("/reject_cheque")
	public String rc(HttpServletResponse res){
		try {
		int i=i5.changeStatus("Reject", customerid1, checknumber);
		res.sendRedirect("/check_cheque");
		return null;
		}
		catch(Exception e){
		return"Error";	
		}
		}
	
	@RequestMapping("/")
	public String login() {
		return"Welcome";
	}
	@RequestMapping("/edit_name")
	public String cn() {
		return"changeName";
	}
	@RequestMapping("/edit_father_name")
	public String cfn() {
		return"changeFatherName";
	}
	@RequestMapping("/change_mobile_number")
	public String cmn() {
		return"changeMobileNumber";
	}
	@RequestMapping("/change_branch_name")
	public String cbn() {
		return"changeBranch";
	}
	@RequestMapping("/change_permanent_address")
	public String cpa() {
		return"changePermanentAddress";
	}
	@RequestMapping("/change_present_address")
	public String cpan() {
		return"changePresentAddress";
	}
	@RequestMapping("/modify_account_deatils")
	public String macd() {
		return"ModifyMainPage";
	}
	@RequestMapping("/add_branch")
	public String ab() {
		return"AdminBranch";
	}
	
	@RequestMapping("/new_customer")
	public String ac() {
		return"AdminCustomer";
	}
	
	@RequestMapping("/close_account")
	public String ca() {
		return"AdminDelete";
	}
	
	@RequestMapping("/admin_login")
	public String al() {
		return"AdminLogin";
	}
	@RequestMapping("/customer_login")
	public String cl() {
		return"Login";
	}
	@RequestMapping("/account_statement")
	public String as() {
		return"AccountsStatement";
	}
	@RequestMapping("/change_pin")
	public String cp() {
		return"changePin";
	}
	@RequestMapping("/cash_withdrawal")
	public String cw() {
		return"getCash";
	}
	
	@RequestMapping("/fast_withdrawal")
	public String fw() {
		return"fastCash";
	}
	@RequestMapping("/deposit")
	public String d() {
		return"DepositCheque";
	}
	
	@RequestMapping("/admin_page")
	public String ap() {
		return"AdminWelcomePage";
	}
	@RequestMapping("/customer_page")
	public String cpp() {
		return"CustomerMainPage";
	}
	@RequestMapping("/forget_password")
	public String fp() {
		return"passwordforget";
	}
	
	@RequestMapping("/newuser")
	public String nu() {
		return"newuser";
	}
	
	@RequestMapping("/password")
	public String password(HttpServletRequest req) {
		List<String> l=i.changepassword(Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("mobilenumber")));
		customerid1=Integer.parseInt(req.getParameter("customerid"));
		mobilenumber=Long.parseLong(req.getParameter("mobilenumber"));
		if(l.size()==1) {
			return"changepassword";
		}
		else {
			return"passwordforgeterror";
		}
	}
	
	@RequestMapping("/change_password")
	public String pass(HttpServletRequest req) {
		int i1=i.password(req.getParameter("password"), customerid1, mobilenumber);
		if(i1==1) {
		return"changepasswordsucess";
		}
		else {
			return"Error";
		}
	}
	
	@RequestMapping("/new_user")
	public String nu(HttpServletRequest req) {
		List<String> l=i.changepassword(Integer.parseInt(req.getParameter("customerid")),Long.parseLong(req.getParameter("mobilenumber")));
		customerid1=Integer.parseInt(req.getParameter("customerid"));
		mobilenumber=Long.parseLong(req.getParameter("mobilenumber"));
		List <String> l1=i3.neuser(customerid1, mobilenumber);
		if(l.size()!=1 ) {
			if(l1.size()==1) {
			return"createnewuser";
		}
		else {
			return"accountnotfounderror";
		}
		}
			else {
				return"newusererror";
			}
	}
	
	
	@RequestMapping("/create_new_user")
	public String cnu(Bean b,HttpServletRequest req) {
		try {
		b.setCustomerid(customerid1);
		b.setMobilenumber(mobilenumber);
		b.setPassword(req.getParameter("password"));
		b.setUsername(Integer.toString(customerid1));
		i.save(b);
		return"createsucess";
		}
		catch(Exception e) {
			return"Error";
		}
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest req,HttpServletResponse res) throws IOException {
		/*req.getSession(false).invalidate();
		session=req.getSession(true);
		c.setValue(null);
		res.addCookie(c);
		System.out.println(c.getValue());
		username=null;
		password=null;
		card_number=null;
		customerid1=0;
		checknumber=0;
		amo=0;
		accountnumber=0;
		pin=0;
		session=null;*/
		res.sendRedirect("/");
	}
	
}
