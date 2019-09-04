 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/signin.css">  
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

<div class="login-wrap">
	<form class="login-html" method="post" action="AdminMusteriGiris">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Giriş Yap</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<label for="user" class="label">E-mail</label>
					<input name="user" type="email" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Parola</label>
					<input name="pass" type="password" class="input" type="password">
				</div>
				
				<div class="group">
				<!--  	<input type="submit" class="button" value="Giriş Yap"> -->
					<input type="submit" class="button" value="Giriş Yap">
          		 
			
					
				<div class="hr"></div>
				<div class="foot-lnk">
					<a href="#forgot">Parolanızı mı unuttunuz?</a>
				</div>
				  <c:if test="${uyeyok == true }" >
			 <div  style=" background: rgba(0, 0, 0, 0.1); border: 1px solid rgba(0, 0, 0, 0);border-radius: 8px;"> 
			 <p align="center"> Email ya da Parola hatalı </p> 
			 </div>
			</c:if>	
			
			<div class="sign-up-htm">
				<div class="group">
					<label for="user" class="label">Kullanıcı Adı</label>
					<input id="user" type="text" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Parola</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">Tekrar girin</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">E-mail</label>
					<input id="pass" type="text" class="input">
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