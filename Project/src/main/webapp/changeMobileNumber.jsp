<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Mobile Number | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
<style>
body{
background-image:url('https://wallpaperaccess.com/full/1104819.jpg');
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
font-size:15px;
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
lable{
font-size:15px;
font-family:Century Gothic;
}
table{
margin-top:130px;
background-color:white;
width:400px;
height:350px;
border-radius:20px;
font-family:Century Gothic;
}
</style>
</head>
<body>
<table align="center" cellpadding="20px">
<form action="changemobilenumber" method="post" onsubmit="return v()" autocomplete="off">
<tr><td>
<lable>Customer Id</lable><br>
<input type="text" id="customerid" name="customerid" value="" placeholder="Type Customer Id" required></td></tr>
<tr><td><lable>Account Number</lable><br>
<input type="text" id="accountnumber" name="accountnumber" value="" placeholder="Type Account Number" required></td></tr>
<tr><td><label>Mobile Number</label><br>
<input type="text" id="mobilenumber" name="mobilenumber" value="" placeholder="Type Mobile Number" required></td></tr>
<tr><td align="center"><button type="submit">Confirm</button></td></tr>
</form>
</table>
<script type="text/javascript">
function v(){
var ci=document.getElementById("customerid").value;
var ac=document.getElementById("accountnumber").value;
var num = /^\d{7}$/;
var num1 =/^\d{9}$/;
if(ci.match(num)){
	
}
else{
	alert("** Invalid Customer id **");
	return false;
}
if(ac.match(num1)){
	
}
else{
	alert("** Invalid Account number **");
	return false;
}
var mn = document.getElementById("mobilenumber").value;
var num2=/^\d{10}$/;
if(mn.match(num2)){
			return true;
		}
else{
	alert("** Invalid mobile number **");
		return false;
		}
}
</script>
</body>
</html>