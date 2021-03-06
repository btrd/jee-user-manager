<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <link href="../../resources/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../../resources/style.css" rel="stylesheet" type="text/css">
    <title>Users List</title>
  </head>
  <body>
    <div class="container">
      <a href="./login"><button class="btn btn-danger">Disconnect</button></a>

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
      <table class="table table-striped table-hover" style="background: white;">
      	<tr><th>Firstname</th><th>Lastname</th><th>Email</th><th>Role</th><th>Edit</th><th>Delete</th></tr>
      	<c:forEach items="${listUser}" var="listUser">
      	<tr>
    	  <td><c:out value="${listUser.firstname}"/></td>
    	  <td><c:out value="${listUser.lastname}"/></td>
          <td><c:out value="${listUser.email}"/></td>
          <td><c:out value="${listUser.role}"/></td>
          <td><a href="./edit?id=${listUser.id}"><button class="btn warning">Edit</button></a></td>
          <td><a href="./delete?id=${listUser.id}"><button class="btn btn-danger">Delete</button></a></td>
      	</tr>
      	</c:forEach>
      </table>
      <a href="./register"><button class="btn btn-primary">Create User</button></a>
	</div>
</body>
</html>
