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
margin-top:180px;
background-color:white;
width:350px;
height:200px;
border-radius:20px;
font-family:Century Gothic;
}
</style>
</head>
<body>
<table align="center" cellpadding="20px">
<form action="new_pin" method="post" onsubmit="return f()" autocomplete="off" >
<tr><td>
<lable>New Pin</lable><br>
<input type="password" id="newpin" name="newpin" value="" placeholder="Type Your New Pin" required></td></tr>
<tr><td>
<lable>Confirm Pin</lable><br>
<input type="password" id="confirmpin" name="confirmpin" value="" placeholder="Type Your New Pin" required></td></tr>
<tr><td align="center"><button type="submit">Confirm</button></td></tr>
</form>
</table>
<script type="text/javascript">
function f(){
var pin = document.getElementById('newpin').value;
var cp=document.getElementById('confirmpin').value;
var num1 = /^\d{4}$/;
if(pin==cp){
	
}
else{
	alert("** The pin and confirm pin not matched **");
	return false;
}
if(pin.match(num1)){
	return true;
}
else{
	alert("** Pin should contain four numbers **")
	return false;
}
}
</script>
</body>
</html>