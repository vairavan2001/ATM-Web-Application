<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Branch | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
<style>
body{
background-image:url('https://wallpaperaccess.com/full/3059703.jpg');
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
margin-top:80px;
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
<form action="statement" method="post" onsubmit="return v()" autocomplete="off">
<tr><td>
<lable>Customer Id</lable><br>
<input type="text" id="customerid" name="customerid" value="" placeholder="Type Customer Id" required></td></tr>
<tr><td><lable>Account Number</lable><br>
<input type="text" id="accountnumber" name="accountnumber" value="" placeholder="Type Account Number" required></td></tr>
<tr><td><label>From Date</label><br>
<input type="text" id="fromdate" name="fromdate" value="" placeholder="DD/MM/YYYY" required onblur="fd()"></td></tr>
<tr><td><label>To Date</label><br>
<input type="text" id="todate" name="todate" value="" placeholder="DD/MM/YYYY" required onblur="td()"></td></tr>
<tr><td align="center"><button type="submit">Generate</button></td></tr>
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
	return true;
}
else{
	alert("** Invalid Account number **");
	return false;
}
}

function fd(){
	var dob =document.getElementById("fromdate").value;
	var s="";
	for(var i=0 ; i<8;i++){
		if(i==2 || i==4){
			s+= ("/"+dob.charAt(i));
			}
		else{
			s+=dob.charAt(i);
			}
		}
	document.getElementById("fromdate").value=s;
}

function td(){
	var dob =document.getElementById("todate").value;
	var s="";
	for(var i=0 ; i<8;i++){
		if(i==2 || i==4){
			s+= ("/"+dob.charAt(i));
			}
		else{
			s+=dob.charAt(i);
			}
		}
	document.getElementById("todate").value=s;
}
</script>
</body>
</html>