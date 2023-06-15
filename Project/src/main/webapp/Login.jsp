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
margin-top:95px;
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
<table align="center" cellpadding="20px"><tr><th style='align:center ; font-size:35px'>
Login
</tr></th><tr><td>
<form action="customer" method="post" autocomplete="off" onsubmit="return v()"> 
<lable><b>Username</b></lable><br><br><input id="username" name="username" type="text" placeholder="Type your Username" required></td></tr>
<tr><td>
<lable><b>Password</b></lable><br><br><input id="password" name="password" type="password" placeholder="Type your Password" required><a style="float:right;" href='forget_password'>Forget password</a></td></tr><tr><td style='align:center ;height:80px; text-align:center;'>
<button type="submit"><b>Login</b></button><a href="newuser">New User</a></td></tr></table>
</form>
<script>
function v(){
var un =document.getElementById("username").value;
var ps =document.getElementById("password").value;
var num = /^\d{7}$/;
if(un.match(num)){
	
}
else{
	alert("** Invalid Username **");
	return false;
	
}
if(ps.length>=8){
	return true;
	}
else{
	alert("Password should be greater than or equal to 8 characters");
	return false;
}
}
</script>
</body>
</html>