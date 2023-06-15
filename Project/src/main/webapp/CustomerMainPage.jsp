<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
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
  width:360px;
  height:50px;
  font-family:Century Gothic;
}
button:hover{
background-color:green;
color:white;
}
table{
margin-top:100px;
margin-left:50px;
margin-right:50px;
width:1400px;
}
</style>
</head>
<body>
<button style="width:100px; height:30px;float:right; background-color:red;" onClick="location.href='/logout'"><b>Logout</b></button>
<table align="left" cellpadding="50px"><tr><td>
<button onClick="location.href='change_pin';"><b>Change Pin</b></button>
</td><td align="right"><button onClick="location.href='deposit';"><b>Deposit Cheque</b></button></td> 
</tr>
<tr><td><button onClick="location.href='fast_withdrawal';"><b>Fast Cash</b></button></td>
<td align="right"><button onClick="location.href='cash_withdrawal';"><b>Cash Withdrawal</b></button></td></td>
</tr>
<tr><td><button onClick="location.href='view_balance';"><b>View Balance</b></button></td>
<td align="right"><button onClick="location.href='mini_statement';"><b>Mini Statement</b></button></td></td>
</tr>
</table>
</body>
</html>