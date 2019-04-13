<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="txt/html; charset= UTF-8">
<link href="style.css" rel="stylesheet" type= "text/css">
	
<title>Change Access</title>
</head>
<body>

	<form action="userAccess"  method="post">
		
		Wpisz nazwę użytkownika, któremu chcesz zmienić uprawnienia. <br/>
		
	<!-- 	<label> Id : <input type="number"  min="0"  title="tylko liczby całkowite" id= "username" name="username" required/> </label><br/>		
	-->	<label> Nazwa użytkownika <br/><input type="text"  pattern ="[a-zA-Z]*" title="Please enter only alphabets." id= "username" name="username" required/> </label><br/>		
		<label>Wybierz uprawnienia:</label><br/>
		<label>User 				<input type="radio"  name="userRole" value="user" required /> </label><br/>
		<label>Premium user			<input type="radio"  name="userRole" value="premiumUser" required /> </label><br/>
		<label>Admin	 			<input type="radio"  name="userRole" value="admin" required /> </label><br/>
		<input type="submit" name ="send" value="wyślij">
			
			
	</form>

 	<br/> <br/> <br/>
	<button onclick="location.href='/menu';" type="button"> Powrót</button> 


</body>
</html>