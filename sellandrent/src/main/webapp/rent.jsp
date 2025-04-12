<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kiralama Listesi - Sell&Book</title>
    
</head>
<body>
    <h1>Kiralama Listesi</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Araç ID</th>
                <th>Müşteri ID</th>
                <th>Başlangıç Tarihi</th>
                <th>Bitiş Tarihi</th>
                <th>Toplam Fiyat</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rent" items="${rents}">
                <tr>
                    <td><c:out value="${rent.id}"/></td>
                    <td><c:out value="${rent.vehicleId}"/></td>
                    <td><c:out value="${rent.customerId}"/></td>
                    <td><c:out value="${rent.startDate}"/></td>
                    <td><c:out value="${rent.endDate}"/></td>
                    <td><c:out value="${rent.totalPrice}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>