<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:grey">
<center><h1>Actions Collaborateur</h1></center>

<h2>Ajout collab</h2>
 <form method="post" action="accueil">
            <label for="nomColl">Nom : </label>
            <input type="text" name="nomColl" id="nomColl" />
            
            <label for="societeColl">societe : </label>
            <input type="text" name="societeColl" id="societeColl" />
            
            <label for="posteColl">Poste : </label>
            <input type="text" name="posteColl" id="posteColl" />
     
            <input type="submit" value="Ajout Collab" />
        </form>
        
<c:if test="${ !empty nomColl }"><p><c:out value="Bonjour, vous vous appelez ${ nomColl } vous etes ${ posteColl }  chez ${ societeColl } " /></p></c:if>


 <h2>Supprimer collab</h2>

<form method="post" action="">
	<select name="pets" id="pet-select">
    	<option value="">Choisir collab a supprimer</option>
    	<option value="dog">Collab</option>
	</select>
<input type="submit" value="Supprimer collab" />
</form>
 

 <h2>Mise a jour collab</h2>
 <form method="post" action="">
 <p>Collab à modifier</p>
	<select name="pets" id="pet-select">
    	<option value="">Mettre a jour collab</option>
    	<option value="dog">Collab</option>
	</select>
	<p>Nouvelles valeurs</p>
	   <input type="text" name="nomColl" id="nomColl" />
            
            <label for="societeColl">societe : </label>
            <input type="text" name="societeColl" id="societeColl" />
            
            <label for="posteColl">Poste : </label>
            <input type="text" name="posteColl" id="posteColl" />
     
            
<input type="submit" value="Modifier collab" />
</form>

<br>

</div>


<div style="background-color:blue">
        <center><h1>Actions Note de Frais</h1></center>
        
</div>        
        
  
 


</body>
</html>