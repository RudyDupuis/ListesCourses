<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listes de courses - Mes listes</title>
</head>
<body>
	<h1>Courses</h1>
	<h2>Mes liste</h2>
	
	<c:forEach items="${listes}" var="liste">
    	<c:out value="${liste.title}" />
    	
    	<form method="POST" action="mes-listes">
    		<input type="hidden" name="listeId" value="${liste.id}" />
    		<input type="submit" value="Supprimer" name="action"/>
    	</form>
    	
    	<form method="POST" action="mes-listes">
    		<input type="hidden" name="listeId" value="${liste.id}" />
    		<input type="submit" value="Voir la liste" name="action"/>
    	</form>
    	<br>
	</c:forEach>
	
	
	<p>${message}</p>
	
	<a href="cree-liste">Ajouter une liste</a>
</body>
</html>