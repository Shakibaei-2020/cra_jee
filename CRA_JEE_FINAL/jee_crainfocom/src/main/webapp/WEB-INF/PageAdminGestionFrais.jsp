<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>page gestion Frais</p>

<!-- ************************************************************************ -->

<p>supprimer</p>
<form method="post" action=ControleAdminGestionFrais>
	<select name="saisiRaison" id="saisiRaison" >
     	<c:forEach items="${ tabRaisonFrais }" var="tabRaisonFrais" varStatus="status">
        <p><option><c:out  value="${tabRaisonFrais}"></option></c:out ></p>
		</c:forEach>
	</select>
<input type="submit" value="supprimer collab"/>
</form>

<!-- ************************************************************************ -->

<p>Maj</p>
 <form method="post" action="ControleInterneGestionFrais">
 
            <label for="idUp">id : </label>
            <input type="text" name="idUp" id="idUp" />
            
            <label for="raisonUp">raison : </label>
            <input type="text" name="raisonUp" id="raisonUp" />
            
            <label for="prixUp">prix : </label>
            <input type="text" name="prixUp" id="prixUp" />
            
            <label for="dateUp">date: </label>
            <input type="text" name="dateUp" id="dateUp" />
            
            <input type="submit" value="Update collab" />    
</form>
<!-- ************************************************************************ -->

<p>Check</p>

		<select>
     	<c:forEach   items="${ tabNoteDeFrais }" var="tabCollab" varStatus="status">
        <p> <option method="get" action="ControleAdminGestionCollab"  ><c:out value="${tabNoteDeFrais}"></option></c:out ></p>
		</c:forEach>
		</select>

</body>
</html>