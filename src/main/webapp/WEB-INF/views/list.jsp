
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Liste des Utilisateurs</title>

  </head>
  <style>body { margin-top: 70px; }</style>
  <body>

    <div class="container">

      <table class="table table-striped table-hover">
      	<tr><th>Firstname</th><th>Lastname</th></tr>
      	<c:forEach items="${listUser}" var="listUser">
      	<tr>
      		<td><c:out value="${listUser.firstname}"/></td>
      		<td><c:out value="${listUser.lastname}"/></td>
      	</tr>
      	</c:forEach>
      </table>
	</div>
</body>
</html>
