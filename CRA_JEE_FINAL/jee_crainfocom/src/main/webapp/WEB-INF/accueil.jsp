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

<form method="post" action="Controle1Collab" >
 
            <label for="nomIn">Nom : </label>
            <input type="text" name="nomIn" id="nomIn" />
            
            <label for="mailIn">mail : </label>
            <input type="text" name="mailIn" id="mailIn" />
        
            <label for="mdpIn">mdp : </label>
            <input type="text" name="mdpIn" id="mdpIn" />
   
            <input type="submit" value="Ajout Collab" />
</form>
        
        
<h2>Supprimer collab</h2>
<form method="post" action=Controle1Collab>
	<select name="saisiNom" id="saisiNom" >
     	<c:forEach items="${ tabNomColl }" var="tabNomColl" varStatus="status">
        <p><option><c:out  value="${tabNomColl}"></option></c:out ></p>
		</c:forEach>
	</select>
<input type="submit" value="supprimer collab"/>
</form>


 <h2>Mise a jour collab</h2>
 <form method="post" action="Controle1Collab">
 
            <label for="idUp">id : </label>
            <input type="text" name="idUp" id="idUp" />
            
            <label for="nomUp">nom : </label>
            <input type="text" name="nomUp" id="nomUp" />
            
            <label for="mailUp">mail : </label>
            <input type="text" name="mailUp" id="mailUp" />
            
            <label for="mdpUp">mdp: </label>
            <input type="text" name="mdpUp" id="mdpUp" />
            
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