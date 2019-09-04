<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Musteriler</title>
</head>
<body>
    <center>
        <h1>Musteri Yonetimi</h1>
        <h2>
            <a href="/new/musteri">Musteri Ekle</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list/musteri">Musterileri Listele</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
           
            <tr>
                <th>Id</th>
                <th>Adı</th>
                <th>Soyadı</th>
                <th>Email</th>
                <th>Parola</th>
            </tr>
            <c:forEach var="musteri" items="${liste}">
                <tr>
                    <td><c:out value="${musteri.id}" /></td>
                    <td><c:out value="${musteri.adi}" /></td>
                    <td><c:out value="${musteri.soyadi}" /></td>
                    <td><c:out value="${musteri.email}" /></td>
                    <td><c:out value="${musteri.parola}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${musteri.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${musteri.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>