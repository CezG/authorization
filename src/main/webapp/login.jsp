<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="txt/html; charset= UTF-8">
<link href="style.css" rel="stylesheet" type= "text/css">
	
<title>Formularz logowania</title>
</head>
<body>
	<div id= "container"> 
		<form action="login"  method="post">
		
			<label> Login <br/><input type="text"  pattern ="[a-zA-Z]*" title="Please enter only alphabets." id= "username" name="username" required/> </label><br/>		
			<label> Hasło <br/><input type="password"   id= "password" name="password" required/> </label><br/>		
			<input type="submit" name ="send" value="wyślij">
			
			<br/><br/>
			<button onclick="location.href='/index.jsp';" type="button"> Powrót do rejestracji</button>
			
		</form>
	</div>

</body>
</html>