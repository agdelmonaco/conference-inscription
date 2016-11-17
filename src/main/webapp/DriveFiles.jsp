<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drive Files Manager</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://apis.google.com/js/api.js"></script>
<script type="text/javascript">
    init = function() {
        s = new gapi.drive.share.ShareClient(); 
        s.setOAuthToken('${sessionScope.accessToken}');
        
    }
    window.onload = function() {
        gapi.load('drive-share', init);
    }
</script>
</head>
<body>


<div style="margin-bottom: 25px; margin-top: 43px; margin-left: 20px;" class="form-group">
	<form action="AddNewDriveDocument">
		<div class="form-group">
		  <label for="newDocument">Nuevo documento:</label>
		  <input type="text" class="form-control" name="newDocument" id="newDocument" style="width: 17%;">
		</div>
	 	<input type="submit" class="btn btn-success" value="Crear">
	 </form>
</div>

<div class="table-responsive" style="margin-left: 200px">
<span>Lista de archivos en el ROOT de drive:</span>
	<table border="1"class="table-striped ">		
		<tr>
				<th>Tipo</th>
				<th>Nombre</th>
				<th>Opciones</th>
			</tr>
		<c:forEach items="${sessionScope.fileList}" var="file">
			
		    <tr>
		    	<td><img src="${file.getIconLink()}"></img></td>      
		        <td><a href="${file.getAlternateLink()}">${file.getTitle()}</a></td>
		        <td><button onclick="s.setItemIds(['${file.getId()}']);s.showSettingsDialog();">Compartir</button></td>
		    </tr>
		</c:forEach>

	</table>

</div>


</body>
</html>