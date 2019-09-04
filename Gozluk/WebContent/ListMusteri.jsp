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
                                                    Kullanıcı id
                                            </th>
                                            <th>
                                                    Adi
                                            </th>
                                            <th>
                                                    Soyadi
                                            </th>
                                            <th>
                                                    Email
                                            </th>
                                            <th>
                                                    Parola
                                            </th>
                                            <th>
                                                    Yetki
                                            </th>
                                    </tr>
                            </thead>
                            <tbody>
                                    <c:forEach items="${musteriler}" var="musteri">
                                            <tr>
                                                    <td>
                                                            <c:out value="${musteri.musteriId}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${musteri.adi}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${musteri.soyadi}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${musteri.email}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${musteri.parola}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${musteri.yetki}"/>
                                                    </td>
                                                    <td><a href="MusteriController?action=edit&musteriId=<c:out value="${musteri.musteriId}"/>">Bilgileri Güncelle</a></td>
                                                    <td><a href="MusteriController?action=delete&musteriId=<c:out value="${musteri.musteriId}"/>">Sil</a></td>
                                            </tr>
                                    </c:forEach>
                            </tbody>
                    </table>
            <a href="MusteriController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Yeni Müşteri Oluştur</a>	
            </div>
	</section>	
</div>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>