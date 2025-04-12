<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hesabımı Sil - Sell&Book</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #d9534f;
            margin-bottom: 20px;
        }
        .confirmation-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 0 auto;
            text-align: center;
        }
        p {
            color: #555;
            margin-bottom: 15px;
        }
        form {
            display: inline-block;
        }
        button {
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
            margin: 5px;
        }
        .confirm-button {
            background-color: #d9534f;
            color: white;
        }
        .confirm-button:hover {
            background-color: #c9302c;
        }
        .cancel-button {
            background-color: #f0ad4e;
            color: white;
        }
        .cancel-button:hover {
            background-color: #ec971f;
        }
        .error {
            margin-top: 15px;
            padding: 10px;
            border-radius: 3px;
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
    <h1>Hesabımı Sil</h1>
    <div class="confirmation-container">
        <p>Hesabınızı silmek istediğinizden emin misiniz? Bu işlem geri alınamaz.</p>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form action="delete-account" method="post">
            <input type="hidden" name="confirmation" value="onay">
            <button type="submit" class="confirm-button">Evet, Sil</button>
        </form>
        <button class="cancel-button" onclick="window.location.href='user.html'">İptal</button>
    </div>
</body>
</html>