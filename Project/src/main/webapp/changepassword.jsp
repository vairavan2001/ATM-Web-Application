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
margin-top:145px;
background-color:white;
width:400px;
height:350px;
border-radius:20px;
font-family:Century Gothic;
}
</style>
<script>
function p(){
	var password=document.getElementById("password").value;
	var conformpassword=document.getElementById("conformpassword").value;
	if(password==conformpassword){
		
		}
	else{
		alert("Password and conform password not matched");
		return false;
		}
	if(password.length>=8){
		return true;
		}
	else{
		alert("Password should be greater than or equal to 8 characters");
		return false;
		}
}

</script>
<meta charset="ISO-8859-1">
<title>Customer | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
</head>
<body>
<table align="center" cellpadding="20px">
<form action="change_password" method="post" onsubmit="return p()" autocomplete="off"> 
<tr><td><lable><b>Password</b></lable><br><br><input id="password" name="password" type="password" placeholder="Type your new password" required></td></tr>
<tr><td>
<lable><b>Conform Password</b></lable><br><br><input id="conformpassword" name="conformpassword" type="password" placeholder="Type your new password" required></td></tr><tr><td style='align:center ;height:80px; text-align:center;'>
<button type="submit"><b>Confirm</b></button></td></tr></table>
</form>
</body>
</html>