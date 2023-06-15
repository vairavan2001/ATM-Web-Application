<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-image:url('https://wallpaperaccess.com/full/2312112.png');
background-repeat :no-repeat;
background-size:cover;
}
input{
border-top:none;
border-right:none;
border-left:none;
width:350px;
height:50px;
font-family:Century Gothic;
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
  align:center;
  font-family:Century Gothic;
}
button:hover{
background-color:green;
color:white;
}
a{   
color:blue;
}
a:hover{
color:red;
}
lable{
font-size:15px;
font-family:Century Gothic;
}
table{
margin-top:110px;
background-color:white;
width:400px;
height:350px;
border-radius:20px;
font-family:Century Gothic;
}
</style>
<meta charset="ISO-8859-1">
<title>Customer | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
</head>
<body>
<script>
function cus(){
var num = /^\d{10}$/;
var num1 = /^\d{7}$/;
var ci=document.getElementById("customerid").value;
var mn=document.getElementById("mobilenumber").value;
if(ci.match(num1)){
	
}
else{
	alert("** Invalid customer id **");
	return false;
}

if(mn.match(num)){
	return true;
}
else{
	alert("** Invalid mobile number **");
	return false;
}
	

}
</script>
<table align="center" cellpadding="20px">
<tr><th style='align:center ; font-size:35px'>
New User
</tr></th>
<form action="new_user" method="post" autocomplete="off" onsubmit="return cus()"> 
<tr><td><lable><b>Customer id</b></lable><br><br><input id="customerid" name="customerid" type="text" placeholder="Type your Customer id" required></td></tr>
<tr><td>
<lable><b>Mobile number</b></lable><br><br><input id="mobilenumber" name="mobilenumber" type="text" placeholder="Type your Mobile number" required></td></tr><tr><td style='align:center ;height:80px; text-align:center;'>
<button type="submit"><b>Next</b></button></td></tr></table>
</form>
</body>
</html>