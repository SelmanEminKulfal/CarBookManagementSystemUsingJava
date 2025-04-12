<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
	.body {
		background-color: black;
		width: 100%;
		height: 100%;
	}
	.giris-formu {
		background-color: #fff;
    	padding: 30px;
    	border-radius: 8px;
    	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    	width: 400px;
    	max-width: 90%;
	}
	.giris-formu h2{
		text-align: center;
	    margin-bottom: 20px;
	    color: #333;
	}
	.giris-formu label {
		display: block;
	    margin-bottom: 8px;
	    color: #555;
	    font-weight: bold;
	}
	.giris-formu input[type="email"],
	.giris-formu input[type="password"] {
		width: calc(100% - 22px); /* İç padding ve border için pay bırak */
	    padding: 10px;
	    margin-bottom: 15px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box; /* Padding ve border'ın genişliğe dahil olmasını sağlar */
	    font-size: 16px;
	}

	.giris-formu .hata-mesaji {
	    color: red;
	    margin-top: 10px;
	    text-align: center;
	}
	.giris-formu button[type="submit"] {
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

	.giris-formu button[type="submit"]:hover {
	    background-color: #0056b3;
	}
</style>
</head>
<body>
	<div class="giris-formu">
        <h2>Giriş Yap</h2>
        <form action="login" method="post">
            <label for="email">E-posta:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="sifre">Şifre:</label>
            <input type="password" id="sifre" name="sifre" required><br><br>

            <button type="submit">Giriş Yap</button>
        </form>

        <%-- Servlet tarafından gönderilen hata mesajını gösterme --%>
        <% String loginError = (String) request.getAttribute("loginError"); %>
        <% if (loginError != null && !loginError.isEmpty()) { %>
            <p class="hata-mesaji"><%= loginError %></p>
        <% } %>
    </div>
</body>
</html>