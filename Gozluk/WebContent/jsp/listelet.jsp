<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<body >
 <p>ÜRÜNLER </p>
      
      <form action="../UrunListele" method="post">
      <input type="submit" value="urun listele">
 	</form>
            <c:forEach items="${urunListesi}" var="urun" >
            <c:out value="${urun.urunAdi}" /><br>
     		 <c:out value="${urun.urunCins}" /><br>
     		 <c:out value="${urun.urunFiyat}" /><br>
     		  <c:out value="${urun.urunResim}" /><br>
            </c:forEach>
            


</body>
</html>