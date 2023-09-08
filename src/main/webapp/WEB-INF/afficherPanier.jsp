<%@page import="java.util.List"%>
<%@page import="fr.eni.gestionListesCourses.bo.Ligne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listes de courses - Ma liste</title>
</head>
<body>
	<h1>Courses</h1>
	<h2>Mon panier</h2>
	
	<c:forEach items="${lignes}" var="ligne">
		<c:if test="${!ligne.buy}">
    		<p>${ligne.article}"</p>
    		
    		<form method="POST" action="mon-panier">
    			<input type="hidden" name="listeId" value="${idLigne}" />
    			<input type="hidden" name="ligneId" value="${ligne.id}" />
    			<input type="submit" value="Retirer" name="action"/>
    		</form>
    	
    		<br>
    	</c:if>
	</c:forEach>
	
	<p>${message}</p>

	<a href="mes-listes">Revenir à mes listes</a>
	
	<form method="POST" action="mon-panier">
		<input type="hidden" name="listeId" value="${idLigne}" />
    	<input type="submit" value="Retablir le panier" name="action"/>
    </form>
</body>
</html>