<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html lang="en">
<head>
		
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<title>Test page</title>

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">
<style>
body  {
    background:#E6EFED;
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

</style>
</head>
	<body>
	
	<div class="wrap">
	<section>
            <div class="container">
                    <table class="table table-hover">
                            <thead>
                                    <tr>
                                            <th>
                                                    #
                                            </th>
                                            <th>
                                                    Adi
                                            </th>
                                            <th>
                                                    Cinsiyet
                                            </th>
                                            <th>
                                                    Marka Id
                                            </th>
                                            <th>
                                                    Model
                                            </th>
                                            <th>
                                                    Kategori
                                            </th>
                                            <th>
                                                    Stok
                                            </th>
                                            <th>
                                                    Fiyat
                                            </th>
                                            <th>
                                                    Resim
                                            </th>
                                    </tr>
                            </thead>
                            <tbody>
                                    <c:forEach items="${urunler}" var="urun">
                                            <tr>
                                                    <td>
                                                            <c:out value="${urun.urunId}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunAdi}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunCins}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunMarkaId}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunModel}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunKat}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunStok}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunFiyat}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${urun.urunResim}"/>
                                                    </td>
                                                    <td><a href="UrunController?action=edit&urunId=<c:out value="${urun.urunId}"/>">Bilgileri Güncelle</a></td>
                                                    <td><a href="UrunController?action=delete&urunId=<c:out value="${urun.urunId}"/>">Sil</a></td>
                                            </tr>
                                    </c:forEach>
                            </tbody>
                    </table>
            <a href="UrunController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Yeni Urun Ekle</a>	
            </div>
	</section>	
</div>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>