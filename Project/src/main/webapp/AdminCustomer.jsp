<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
</head>
<style>
body{
background-image:url('https://wallpaperaccess.com/full/1567665.png');
}
input[type=text]{
border-top:none;
border-right:none;
border-left:none;
width:350px;
height:50px;
font-family:Century Gothic;
font-size:15px;
}
input[type=radio]{
width:20px;
height:20px;
font-family:Century Gothic;
font-size:15px;
}
input[type=date]{
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
display:inline-block;
width:200px;
}
select{
border-top:none;
border-right:none;
border-left:none;
width:350px;
height:50px;
font-family:Century Gothic;
font-size:15px;
}
table{
margin-top:10px;
background-color:white;
width:630px;
height:350px;
border-radius:20px;
font-family:Century Gothic;
}
textarea{
border-top:none;
border-right:none;
border-left:none;
width:350px;
font-family:Century Gothic;
resize:none;
}
</style>
<body>
<form action="/addcustomer" method="post" onsubmit="return v()" autocomplete="off">
<table align="center" cellpadding="20px"><tr><td>
<lable>Name</lable>
<input type="text" name="name" id="name" value="" placeholder="Name" required onkeyup="n()"><br></td></tr>
<tr><td><lable>Father Name</lable>
<input type="text" name="fathername" id="fathername" value="" placeholder="Father Name" required onkeyup="fn()"><br></td></tr>
<tr><td><lable>Date of Birth</lable>
<input type="text" value="" id="dateofbirth" name="dateofbirth" placeholder="DD/MM/YYYY" required onblur="dob()"><br></td></tr>
<tr><td><lable>Gender</lable>
<input type="radio" id="gender" name="gender" value="Male">Male</input> &nbsp
<input type="radio" id="gender" name="gender" value="Female">Female</input><br></td></tr>
<tr><td><lable>Permanent Address</lable>
<textarea rows="5" id="permanentaddress" name="permanentaddress" required></textarea><br></td></tr>
<tr><td><lable>Present Address</lable>
<textarea rows="5" id="presentaddress" name="presentaddress" required></textarea><br></td></tr>
<tr><td><lable>Pan Card Number</lable>
<input type="text" id="pancardnumber" name="pancardnumber" value="" required onkeyup="pn()"><br></td></tr>
<tr><td><lable>Mobile Number</lable>
<input type="text" id="mobilenumber" name="mobilenumber" value="" required><br></td></tr>
<tr><td><lable>Check Book</lable>
<select id="checkbook" name="checkbook" required>
<option selected diable hidden>Select one</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select><br></td></tr>
<tr><td><lable>Account Type</lable>
<select id="accounttype" name="accounttype" required>
<option selected diable hidden>Select one</option>
<option value="Savings">Savings</option>
<option value="Current">Current</option>
</select><br></td></tr>
<tr><td><lable>Opening Balance</lable>
<input type="text" id="openingbalance" name="openingbalance" value="" required><br></td></tr>
<tr><td><lable>Branch Name</lable>
<input type="text" id="branchname" name="branchname" value="" required onkeyup="d()"><br></td></tr>
<tr><td align="center"><button type="Submit">Add Customer</button></td></tr>
</form>
</table>
<script type="text/javascript">
function v(){
var mn = document.getElementById("mobilenumber").value;
var num=/^\d{10}$/;
if(mn.match(num)){
	return true;
}
else{
	alert("** Invalid mobile number **");
	return false;
}
}
function d(){
	var b=document.getElementById("branchname").value;
	var s;
	for(var i=0;i<b.length;i++){
		if(i==0){
			s+=b.charAt(i).toUpperCase();
			}
		else{
			s+=b.charAt(i);
			}
		}
	document.getElementById("branchname").value=s;

}

function n(){
	var b=document.getElementById("name").value;
	var s="";
	for(var i=0;i<b.length;i++){
		if(i==0){
			s+=b.charAt(i).toUpperCase();
			}
		else{
			s+=b.charAt(i);
			}
		}
	document.getElementById("name").value=s;
}

function fn(){
	var b=document.getElementById("fathername").value;
	var s="";
	for(var i=0;i<b.length;i++){
		if(i==0){
			s+=b.charAt(i).toUpperCase();
			}
		else{
			s+=b.charAt(i);
			}
		}
	document.getElementById("fathername").value=s;
}

function pn(){
	var b=document.getElementById("pancardnumber").value;
	var c=b.toUpperCase();
	document.getElementById("pancardnumber").value=c;
}

function dob(){
	var dob =document.getElementById("dateofbirth").value;
	var s="";
	for(var i=0 ; i<8;i++){
		if(i==2 || i==4){
			s+= ("/"+dob.charAt(i));
			}
		else{
			s+=dob.charAt(i);
			}
		}
	document.getElementById("dateofbirth").value=s;
}
</script>
</body>
</html>