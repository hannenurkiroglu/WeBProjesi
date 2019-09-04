 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../mycss/login.css">  

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Giris Yapiniz</title>
</head>
<body>
<div class="login-box">
    <img src="avatar.png" class="avatar">
    
        <h1>Login Here</h1>
            <form method="post" action="../AdminMusteriGiris">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">
            <input type="submit" name="submit" value="Login">
            <a href="#">Forget Password</a> 
		    <c:if test="${uyeyok == true }" >
			 <div  style=" background: rgba(0, 0, 0, 0.1); border: 1px solid rgba(0, 0, 0, 0);border-radius: 8px;"> 
			 <p align="center"> Email ya da Parola hatalı </p> 
			 </div>
			</c:if>	
		    </form>
 			
      </div>
</body>
</html>
