<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="txt/html; charset= UTF-8">
<link href="style.css" rel="stylesheet" type= "text/css">
	
<title>Formularz rejestracji </title>
</head>
<body>
	<div id= "container"> 
		<form action="registration"  method="post">
		
			<label> Nazwa użytkownika <br/><input type="text"  pattern ="[a-zA-Z]*" title="Please enter only alphabets." id= "username" name="username" required/> </label><br/>		
			<label> Hasło <br/><input type="password"  oninput="checkPasswordValidity();" id= "password" name="password" required/> </label><br/>		
			<label> Wpisz ponownie hasło <br/><input type="password" oninput="checkPasswordValidity();" id= "checkPassword" name="checkPassword" required/> </label><br/>		
			<label> Email <br/><input type="email"  oninput="checkEmailValidity();" id= "email" name="email" required/> </label><br/>		
			<input type="submit" name ="send" value="wyślij">
			
			<br/><br/>
			<button onclick="location.href='/login.jsp';" type="button"> Zaloguj się</button>
			
		</form>
	</div>

<script>
    function checkPasswordValidity(str) {
        const password = document.getElementById('password');
        const checkPassword= document.getElementById('checkPassword');

        if (password.value === checkPassword.value) {
        	checkPassword.setCustomValidity('');
        } else {
        	checkPassword.setCustomValidity('Password must match');
        }
        console.log('password customError ', document.getElementById('checkPassword').validity.customError);
        console.log('password validationMessage ', document.getElementById('checkPassword').validationMessage);
    }
</script>

</body>
</html>