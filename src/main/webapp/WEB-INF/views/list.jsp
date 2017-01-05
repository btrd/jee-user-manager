
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Liste des Utilisateurs</title>

  </head>
  <body>

    <div class="container">

      <form action="./list" method="GET">
        <label for="name" class="sr-only">Lastname</label>
        <input type="text" class="form-control" placeholder="Lastname" name="name" autofocus>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Search By Lastname</button>
      </form>
      <hr/>
      <form action="./list" method="GET">
        <label for="role" class="sr-only" name="role">Role</label>
        <select id="role" class="form-control" required name="role">
          <option value="">---</option>
          <option value="ADMIN">Admin</option>
          <option value="SUPERVISOR">Superviseur</option>
          <option value="RIGGER">Plieur</option>
        </select> 
        <button class="btn btn-lg btn-primary btn-block" type="submit">Search By Role</button>
      </form>
      <hr/>
      <table class="table table-striped table-hover">
      	<tr><th>Firstname</th><th>Lastname</th><th>email</th><th>password</th><th>role</th></tr>
      	<c:forEach items="${listUser}" var="listUser">
      	<tr>
      		<td><c:out value="${listUser.firstname}"/></td>
      		<td><c:out value="${listUser.lastname}"/></td>
          <td><c:out value="${listUser.email}"/></td>
          <td><c:out value="${listUser.password}"/></td>
          <td><c:out value="${listUser.role}"/></td>
      	</tr>
      	</c:forEach>
      </table>
	</div>
</body>
</html>
