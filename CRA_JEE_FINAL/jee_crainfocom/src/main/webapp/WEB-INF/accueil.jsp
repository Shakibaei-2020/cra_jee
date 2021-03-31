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

<h2>Ajout collab</h2>

<form method="post" action="ajoutCollab" >
 
            <label for="nomColl">Nom : </label>
            <input type="text" name="nomColl" id="nomColl" />
            
            <label for="societeColl">societe : </label>
            <input type="text" name="societeColl" id="societeColl" />
        
            <label for="posteColl">Poste : </label>
            <input type="text" name="posteColl" id="posteColl" />
   
            <input type="submit" value="Ajout Collab" />
</form>
        
        
<h2>Supprimer collab</h2>
<form method="post" action=SupprCollab>
	<select name="saisiNom" id="saisiNom" >
     	<c:forEach items="${ tabNomColl }" var="tabNomColl" varStatus="status">
        <p><option><c:out  value="${tabNomColl}"></option></c:out ></p>
		</c:forEach>
	</select>
<input type="submit" value="supprimer collab"/>
</form>


 <h2>Mise a jour collab</h2>
 <form method="post" action="UpdateCollab">
 
            <label for="nomColl">idColl : </label>
            <input type="text" name="idColl" id="idColl" />
            
            <label for="nomColl">nomColl : </label>
            <input type="text" name="nomColl" id="nomColl" />
            
            <label for="nomColl">posteColl : </label>
            <input type="text" name="posteColl" id="posteColl" />
            
            <label for="nomColl">societeColl: </label>
            <input type="text" name="societeColl" id="societeColl" />
            
            <input type="submit" value="Update collab" />    
</form>
  
 <h2> tout les collab</h2>
 
		<select>
     	<c:forEach   items="${ tabCollab }" var="tabCollab" varStatus="status">
        <p> <option method="get" action="SupprCollab"  ><c:out value="${tabCollab}"></option></c:out ></p>
		</c:forEach>
		</select>

</div>

</body>
</html>