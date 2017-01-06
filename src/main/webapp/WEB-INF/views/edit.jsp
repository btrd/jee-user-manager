<!DOCTYPE HTML>
<html>
  <head>
    <title>Edit</title>
    <link href="../../resources/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../../resources/style.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <div class="container">
      <form class="form-signin" action="./edit" id="user" method="POST">
        <h2 class="form-signin-heading">Edit</h2>
        <input type="hidden" name="id" id="id" value="${user.id}"/>
        <label for="firstname" class="sr-only">Firstname</label>
        <input type="text" id="firstname" class="form-control" placeholder="Firstname" name="firstname" value="${user.firstname}" required autofocus>
        <label for="lastname" class="sr-only">Lastname</label>
        <input type="text" id="lastname" class="form-control" placeholder="Lastname" name="lastname" value="${user.lastname}" required autofocus>
        <label for="email" class="sr-only">Email address</label>
        <input type="email" id="email" class="form-control" placeholder="Email address" name="email" value="${user.email}" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" name="password" value="${user.password}" required>
        <label for="role" class="sr-only" name="role">Role</label>
        <select id="role" class="form-control" required name="role">
          <option value="ADMIN">Admin</option>
          <option value="SUPERVISOR">Supervisor</option>
          <option value="RIGGER">Rigger</option>
        </select> 
        <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
        <a href="./list" class="btn btn-lg btn-danger btn-block">Cancel</a>
      </form>
    </div>
  </body>
</html>