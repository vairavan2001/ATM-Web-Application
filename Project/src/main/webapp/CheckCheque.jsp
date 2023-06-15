<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
body{  
background-image:url("https://wallpaperaccess.com/full/2311977.jpg");
background-repeat :no-repeat;
background-size:cover;
}
button{
background-color:skyblue;
  border: none;
  color: Black;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 18px;
  border-radius:12px;
  width:200px;
  height:50px;
  font-family:Century Gothic;
}
button:hover{
background-color:green;
color:white;
}
table{
background-color:white;
border-radius:20px;
margin-top:140px;
margin-left:320px;
margin-right:50px;
width:800px;
height:350px;
font-size:20px;
text-align:center;
}
</style>
</head>
<body>
<%
String customerid= request.getAttribute("customerid").toString();
String checknumber=request.getAttribute("checknumber").toString();
String amount =request.getAttribute("amount").toString();
String accountnumber=request.getAttribute("accountnumber").toString();
String branchname =request.getAttribute("branchname").toString();
String bankname =request.getAttribute("bankname").toString();
request.setAttribute("customerid", customerid);
request.setAttribute("checknumber", checknumber);
request.setAttribute("amount", amount);
request.setAttribute("accountnumber", accountnumber);
request.setAttribute("bankname", bankname);
RequestDispatcher rd1 = request.getRequestDispatcher("clear_cheque");
out.println("<table cellpadding='25px'><tr><td>");
out.println("Customer Id:"+customerid+"</td> <td>Account Number :"+accountnumber+ "</td></tr><td> Branch name:"+branchname);
out.println("<tr><td>Cheque Number :"+checknumber +"</td> <td>Amount :"+ amount +"</td></tr>");
out.println("<tr><td align='right'><button onClick=location.href='clear_cheque'>Clear Cheque</button></td><td align='left'><button onClick=location.href='reject_cheque'>Reject</button></td></tr>");
out.println("</table>");
out.println("</body>");
out.println("</html>");
 %>



