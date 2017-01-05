<!DOCTYPE HTML>
<html>
  <head>
    <title>Register</title>
    <link href="../../resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../../resources/style.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <div class="container">
      <form class="form-signin" action="./register" method="POST">
        <h2 class="form-signin-heading">Register</h2>
        <label for="firstname" class="sr-only">Firstname</label>
        <input type="text" id="firstname" class="form-control" placeholder="Firstname" name="firstname" required autofocus>
        <label for="lastname" class="sr-only">Lastname</label>
        <input type="text" id="lastname" class="form-control" placeholder="Lastname" name="lastname" required autofocus>
        <label for="email" class="sr-only">Email address</label>
        <input type="email" id="email" class="form-control" placeholder="Email address" name="email" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" required name="password">
        <label for="role" class="sr-only" name="role">Role</label>
        <select id="role" class="form-control" required name="role">
          <option value="ADMIN">Admin</option>
          <option value="SUPERVISOR">Superviseur</option>
          <option value="RIGGER">Plieur</option>
        </select> 
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>
    </div>
  </body>
</html>
