<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Details |XYZ Bank</title>
<link rel="shortcut icon" href="https://symbols.getvecta.com/stencil_87/54_lloyds-bank-icon.403e2b8229.svg">
<style>
body{  
background-image:url("https://wallpaperbat.com/img/155959-free-download-instabank-new-standard-for-rapid-establishment.jpg");
background-repeat :no-repeat;
background-size:cover;
}
button{
background-color:orange;
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
table{
margin:20px;
margin-top:60px;
width:1450px;
}
</style>
</head>
<body>
<table align="left" cellpadding="60px"><tr><td><button onClick="location.href='edit_name';"><b>Edit Name</b></button> </td>
<td align="right"><button onClick="location.href='edit_father_name';"><b>Edit Father Name</b></button> </td></tr>
<tr><td><button onClick="location.href='change_permanent_address';"><b>Change Permanent Address</b></button> </td>
<td align="right"><button onClick="location.href='change_present_address';"><b>Change Present Address</b></button> </td></tr>
<tr><td><button onClick="location.href='change_mobile_number';"><b>Change Mobile Number</b></button> </td>
<td align="right"><button onClick="location.href='change_branch_name';"><b>Change Branch</b></button></td>
</table>
</body>
</html>