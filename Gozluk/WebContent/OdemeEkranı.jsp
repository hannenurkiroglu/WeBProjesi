<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body  {
    background-image: url("images/sliderwoman.jpg");
      background-size:cover;
}
</style>
<body>
<h2>Ödeme Ekranı Hoşgeldiniz</h2>
<h3>Son adım olarak ödeme tipini seçip alışverişinizi tamamlayabilirsiniz.</h3>

<% String user=(String)session.getAttribute("oturumismi");

	 
	 String ad=(String)session.getAttribute("musteriadi");
	 String soyad=(String)session.getAttribute("musterisoyadi");
	

%>

<table>
<tr>
  <th>Adınız</th>
  <th>Soyadınız</th>
   <th>Toplam Tutar</th>

</tr>
<tr>
  <td><% out.println(ad); %></td>
  <td><% out.println(ad); %></td>
 <td><% out.println(ad); %></td>
</tr>

</table>


</body>
</html>