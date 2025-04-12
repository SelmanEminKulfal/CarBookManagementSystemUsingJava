<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kiralama İşlemi - Sell&Book</title>
    <style>
        .rent-a-car-container {
            padding: 20px;
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        .success-message {
            color: green;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .error-message {
            color: red;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .back-button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .back-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="rent-a-car-container">
        <h1>Kiralama İşlemi</h1>

        <% if (request.getParameter("rentalSuccess") != null && request.getParameter("rentalSuccess").equals("true")) { %>
            <div class="success-message">İşlem başarılı! Kiralanan araçları "Kiralanan Araçlar" sekmesinde görüntüleyebilirsiniz.</div>
        <% } %>
        <% if (request.getParameter("rentalError") != null) { %>
            <div class="error-message">
                <% if (request.getParameter("rentalError").equals("invalidVehicleId")) { %>
                    Geçersiz araç ID'si.
                <% } else if (request.getParameter("rentalError").equals("missingInfo")) { %>
                    Araç ID'si veya kullanıcı bilgisi bulunamadı.
                <% } else { %>
                    Bir hata oluştu.
                <% } %>
            </div>
        <% } %>

        <a href="user-panel.jsp" class="back-button">Kullanıcı Paneline Dön</a>
    </div>
</body>
</html>