<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<center><p>page gestion Collab</p></center>
<hr> 
<!-- ************************************************************************ -->
<p>Ajout</p>
<form method="post" action="ControleAdminGestionCollab" >
 
            <label for="nomIn">Nom : </label>
            <input type="text" name="nomIn" id="nomIn" />
            
            <label for="mailIn">mail : </label>
            <input type="text" name="mailIn" id="mailIn" />
        
            <label for="mdpIn">mdp : </label>
            <input type="text" name="mdpIn" id="mdpIn" />
   
            <input type="submit" value="Ajout Collab" />
</form>
<!-- ************************************************************************ -->
<p>supprimer</p>
<form method="post" action=ControleAdminGestionCollab>
	<select name="saisiNom" id="saisiNom" >
     	<c:forEach items="${ tabNomColl }" var="tabNomColl" varStatus="status">
        <p><option><c:out  value="${tabNomColl}"></option></c:out ></p>
		</c:forEach>
	</select>
<input type="submit" value="supprimer collab"/>
</form>

<!-- ************************************************************************ -->
<p>Maj</p>
 <form method="post" action="ControleAdminGestionCollab">
 
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
<!-- ************************************************************************ -->
<p>Check</p>
		<select>
     	<c:forEach   items="${ tabCollab }" var="tabCollab" varStatus="status">
        <p> <option method="get" action="ControleAdminGestionCollab"  ><c:out value="${tabCollab}"></option></c:out ></p>
		</c:forEach>
		</select>
		
<!-- ************************************************************************ -->

</body>
</html>