 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE>
<html>

<head>
  <title>X-Gözlük</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="../mycss/anasayfa.css" />
 
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.html">Gözlükçüyük<span class="logo_colour"></span></a></h1>
          <h2>Gözlük mü satıyoruz :D</h2>
			
		<c:if test="${oturumismi != null}" >
			 <p class="kullanicigirdi"> Hoşgeldin <% String user=(String)session.getAttribute("oturumismi"); out.println(user);%> </p>
		</c:if>			
			
	
        </div>
        
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li class="selected"><a href="examples.html">Anasayfa</a></li>
        <li><a href="page.html" >Kadın</a></li>
         
          <li><a href="#">Erkek</a></li>
          <li><a href="#">Sepet</a></li>
          <li><a href="http://localhost:8085/Gozluk/jsp/giris.jsp">Giriş Yap</a></li> 
 
        </ul>
      </div>
    </div>
   </div>
   
</body>
</html>
