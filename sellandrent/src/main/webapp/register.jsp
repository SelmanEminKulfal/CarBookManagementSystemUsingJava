<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
.kayit-formu {
    background-color: gray;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 400px;
    max-width: 90%;
}

.kayit-formu h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

.kayit-formu label {
    display: block;
    margin-bottom: 8px;
    color: #555;
    font-weight: bold;
}

.kayit-formu input[type="text"],
.kayit-formu input[type="email"],
.kayit-formu input[type="tel"],
.kayit-formu input[type="password"] {
    width: calc(100% - 22px); /* İç padding ve border için pay bırak */
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; /* Padding ve border'ın genişliğe dahil olmasını sağlar */
    font-size: 16px;
}

.kayit-formu button[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 18px;
    width: 100%;
    transition: background-color 0.3s ease;
}

.kayit-formu button[type="submit"]:hover {
    background-color: #0056b3;
}

.kayit-formu .hata-mesaji {
    color: red;
    margin-top: 10px;
    text-align: center;
}
</style>
</head>
<body>
	<div class="kayit-formu">
        <h2>Kayıt Ol</h2>
        <form action="register" method="post">
            <label for="ad">Ad:</label>
            <input type="text" id="ad" name="ad" required><br><br>

            <label for="soyad">Soyad:</label>
            <input type="text" id="soyad" name="soyad" required><br><br>

            <label for="email">E-posta:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="telefon">Telefon:</label>
            <input type="tel" id="telefon" name="telefon" required><br><br>

            <label for="sifre">Şifre:</label>
            <input type="password" id="sifre" name="sifre" required><br><br>

            <button type="submit">Kayıt Ol</button>
        </form>
    </div>
</body>
</html>