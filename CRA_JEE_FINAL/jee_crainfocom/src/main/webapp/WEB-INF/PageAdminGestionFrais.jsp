<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><p>page gestion Frais</p></center>
<hr>
<!-- ************************************************************************ -->

<p>supprimer</p>
<form method="post" action=ControleAdminGestionFrais>
	<select name="saisiRaison" id="saisiRaison" >
     	<c:forEach items="${ tabRaisonFrais }" var="tabRaisonFrais" varStatus="status">
        <p><option><c:out  value="${tabRaisonFrais}"></option></c:out ></p>
		</c:forEach>
	</select>
<input type="submit" name="button_clicked" value="supprimerFrais"/>
</form>

<!-- ************************************************************************ -->
<p> Probleme parse </p>
<p>Maj</p>
 <form method="post" action="ControleAdminGestionFrais">
 
            <label for="idUp">id : </label>
            <input type="text" name="idUp" id="idUp" />
            
            <label for="raisonUp">raison : </label>
            <input type="text" name="raisonUp" id="raisonUp" />
            
            <label for="prixUp">prix : </label>
            <input type="text" name="prixUp" id="prixUp" />
            
            <label for="dateUp">date: </label>
            <input type="date" id="dateUp" name="dateUp" value="2018-07-22" min="2018-01-01" max="2018-12-31">
            
            <input type="submit" name="button_clicked"  value="updateFrais" />    
</form>
<!-- ************************************************************************ -->

<p>Check</p>

		<select>
     	<c:forEach   items="${ tabNoteDeFrais }" var="tabCollab" varStatus="status">
        <p> <option method="get" action="ControleAdminGestionCollab"  ><c:out value="${tabNoteDeFrais}"></option></c:out ></p>
		</c:forEach>
		</select>

</body>
<!-- ************************************************************************ -->

<p>Check By id</p>

<form method="post" action=ControleAdminGestionFrais>
<label for="idSho">id: </label>
<input type="text"  name="idSho" id="idSho" />

<input type="submit" name="button_clicked" value="showFrais"/>
		<c:forEach   items="${tabNot}" var="tabNot" varStatus="status">
<p> <option method="post" action="ControleAdminGestionCollab"  ><c:out value="${tabNot}"></option></c:out ></p>
</c:forEach>
		
</form>


</body>
</html>