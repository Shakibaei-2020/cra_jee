<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Interne</p>
<p>Ajout</p>
<form method="post" action="ControleInterneGestionFrais" >
 
            <label for="raisonIn">raison : </label>
            <input type="text" name="raisonIn" id="raisonIn" />
            
            <label for="mailIn">prix : </label>
            <input type="text" name="prixIn" id="prixlIn" />
        
            <label for="dateIn">date : </label>
            <input type="text" name="dateIn" id="dateIn" />
   
            <input type="submit" value="Ajout note de frais" />
</form>

<form method="post" action="ControleAdminGestionCollab" >

            <input type="submit" value="AutrePage" />
</form>

</body>
</html>