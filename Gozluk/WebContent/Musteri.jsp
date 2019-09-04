<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="Resource/bootstrap.css" rel="stylesheet">
    </head>
    <style>
body  {
    background-image: url("images/sliderwoman.jpg");
      background-size:cover;
}
.btn{
	background: rgba(244, 224, 63,0.7);
	padding: 15px 25px;
	cursor: pointer;
	outline: none;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #aaaa9d;
	
}
.btn:hover {
	background-color:#efe145;
}
.btn:active {
	background-color:#fff7b2;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}
.kaydir {
margin-left: 70px;
}
</style>
    <body>
        <div class="container">
            <form method="POST" action='MusteriController' name="frmAddMusteri" role="form">
           <div class="kaydir">      
                <h3>Müşteri Bilgileri</h3>
                <div class="form-group">
                    <label for="musteriid">
                        id: <input class="form-control" type="number" id="musteriId" name="musteriId" readonly value=<c:out value="${musteri.musteriId}" /> />
                    </label>
                </div>
                <div class="form-group">
                    <label for="adi">
                        Adi:<input class="form-control" type="text" id="adi" name="adi" value="<c:out value="${musteri.adi}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="soyadi">
                        Soyadi:<input class="form-control" type="text"  name="soyadi" value="<c:out value="${musteri.soyadi}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="email">
                        Email: <input class="form-control" type="text" name="email" value="<c:out value="${musteri.email}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="parola">
                        Parola: <input class="form-control" type="text" name="parola" value="<c:out value="${musteri.parola}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="email">
                        Yetki: <input class="form-control" type="number" name="yetki" value="<c:out value="${musteri.yetki}" />" />
                    </label>
                </div>
                <input type="submit" value="Müşteriyi Kaydet" class="btn btn-info" onclick="myFunction()" />
                	<script>
								function myFunction() {
  								  alert("Müşteri Veritabanına Kaydedildi!");
								}
					</script> 
					</div>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>