<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Branch | XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
<style>
body{
background-image:url('https://wallpaperaccess.com/full/1567665.png');
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
lable{
font-size:15px;
font-family:Century Gothic;
}
table{
background-color:white;
width:400px;
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
</head>
<body>
<table align="center"cellpadding="20px">
<form action="addbranch" method="Post">
<tr><td><lable>Branch Name</lable><br>
<input type="text" id="branchname" name="branchname" value="" placeholder="Type Branch Name" required onkeyup="d()" ></td></tr>
<tr><td><lable>MICR Code</lable>
<input type="text" id="micrcode" name="micrcode" value="" placeholder="Type MICR Code" required></tr></td>
<tr><td><lable>IFSC Code</lable>
<input type="text" id="ifsccode" name="ifsccode" value="" placeholder="Type IFSC Code" required></td></tr>
<tr><td><label>Address</label>
<textarea rows="4" id="address" name="address" placeholder="Type Branch Address" required></textarea></td></tr>
<tr><td><lable>Telephone no</lable>
<input type="text" id="telephonenumber" name="telephonenumber" placeholder="Type Telephone number" required></td></tr>
<tr><td><button type="submit">Add Branch</button>
</form>
</td></tr>
</table>
</body>
<script>
function d(){
	var b=document.getElementById("branchname").value;
	var s="";
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
</script>
</html>