<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Father Name | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
<style>
body{
background-image:url('https://wallpaperaccess.com/full/1104824.jpg');
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
<form action="deposit_cheque" method="post" onsubmit="return v()" autocomplete="off">
<tr><td>
<lable>Bank Name</lable><br>
<input type="text" id="bankname" name="bankname" value="" placeholder="Type Bank name of cheque" required></td></tr>
<tr><td>
<lable>Cheque Number</lable><br>
<input type="text" id="chequenumber" name="chequenumber" value="" placeholder="Type Cheque Number" required></td></tr>
<tr><td><lable>Amount</lable><br>
<input type="text" id="amount" name="amount" value="" placeholder="Type Amount" required></td></tr>
<tr><td align="center"><button type="submit">Deposit</button></td></tr>
</form>
</table>
<script>
function v(){
var cn =document.getElementById("chequenumber").value
var num1 =/^\d{4}$/;
if(cn.match(num1)){
	return true;
}
else{
	alert("** Invalid cheque number **");
	return false;
}
}
</script>
</body>
</html>