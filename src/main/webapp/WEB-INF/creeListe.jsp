<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listes de courses - Créer une liste</title>
</head>
<body>
	<h1>Courses</h1>
	<h2>Nouvelle liste</h2>
	
	<form method="POST" action="cree-liste">
		<label for="title">Nom de la liste : </label>
		<input type="text" id="tilte" name="title" required/>
		
		<label for="article">Nom de l'article : </label>
		<input type="text" id="article" name="article1" required/>
		
		<label for="article">Nom de l'article : </label>
		<input type="text" id="article" name="article2"/>
		
		<label for="article">Nom de l'article : </label>
		<input type="text" id="article" name="article3"/>
		
		<label for="article">Nom de l'article : </label>
		<input type="text" id="article" name="article4"/>
		
		<label for="article">Nom de l'article : </label>
		<input type="text" id="article" name="article5"/>
		
		<input type="submit" value="Ajouter la liste"/>
	</form>
	
	<p>${message}</p>

	<a href="mes-listes">Revenir à mes listes</a>
</body>
</html>