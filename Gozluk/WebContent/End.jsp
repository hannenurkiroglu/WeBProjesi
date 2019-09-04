<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<style>
body  {
    background-image: url("images/sliderwoman.jpg");
      background-size:cover;
}
</style>
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
<center><h2>
<% String user=(String)session.getAttribute("oturumismi");
if (user!=null) {
	 String ad=(String)session.getAttribute("musteriadi");
	 String soyad=(String)session.getAttribute("musterisoyadi");
	 out.println("MERHABA " + ad + " " +soyad + " SİPARİŞİNİZ TAMAMLANDI");
}

%>
</center>
</h2>

</body>
</html>