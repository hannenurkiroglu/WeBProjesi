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
            <form method="POST" action='UrunController' name="frmAddUrun" role="form">
              <div class="kaydir">        
                  <h3>Ürün Bilgileri</h3>
                <div class="form-group">
                    <label for="urunid">
                       Ürün Id: <input class="form-control" type="number" id="urunId" name="urunId" readonly value=<c:out value="${urun.urunId}" /> />
                    </label>
                </div>
                <div class="form-group">
                    <label for="urunadi">
                        Adı<input class="form-control" type="text" id="urunAdi" name="urunAdi" value="<c:out value="${urun.urunAdi}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="cinsiyet">
                        Cinsiyet:<input class="form-control" type="text"  name="cinsiyet" value="<c:out value="${urun.urunCins}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="markaid">
                        MarkaId: <input class="form-control" type="number" name="markaId" value="<c:out value="${urun.urunMarkaId}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="model">
                        Model: <input class="form-control" type="text" name="model" value="<c:out value="${urun.urunModel}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="kategori">
                        Kategori: <input class="form-control" type="text" name="kategori" value="<c:out value="${urun.urunKat}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="stok">
                        Stok: <input class="form-control" type="number" name="stok" value="<c:out value="${urun.urunStok}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="fiyat">
                        Fiyat: <input class="form-control" type="number" name="fiyat" value="<c:out value="${urun.urunFiyat}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="resim">
                        Resim: <input class="form-control" type="text" name="resim" value="<c:out value="${urun.urunResim}" />" />
                    </label>
                </div>
                <input type="submit" value="Ürünü Kaydet" class="btn btn-info" />
            </form>
                </div>   
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>