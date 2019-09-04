 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/signup.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
  

<title>Giriş Yap</title>
</head>
<body>
<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					
					<div class="right-top-bar flex-w h-full">
						<a href="homepagewithoutlogin.jsp" class="flex-c-m trans-04 p-lr-25">
		
							Anasayfaya Dön
						</a>

					</div>
				</div>
			</div>
</div>
<div class="login-wrap">
<form class="login-html" action="KaydolController" method="post">
	
		<input id="tab-2" type="radio" name="tab" class="sign-up" checked>
		<c:choose> 
			<c:when test="${yetki== true}"> 
				<label for="tab-2" class="tab">
				Müşteriyi Kaydet 
				</label>
				</c:when>
			<c:when test="${yetki != true}"> 
				<label for="tab-2" class="tab">
				Kaydol
				</label>
				</c:when>
		</c:choose>
	
		<div class="login-form">
		
			<div class="sign-up-htm">
				<div class="group">
					<label for="user" class="label">Ad</label>
					<input name="adi" type="text" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Soyad</label>
					<input name="soyadi" type="text" class="input" >
				</div>
					<div class="group">
					<label for="pass" class="label">E-mail</label>
					<input name="email" type="email" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Parola</label>
					<input name="parola" type="password" class="input" type="password">
				</div>
			
				<div class="group">
					<input type="submit" class="button" value="Kaydol">
				</div>
			
			</div>
		</div>

</form>
</div>
</body>
</html>