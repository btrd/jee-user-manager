<!DOCTYPE HTML>
<html>
<head>
  <title>Sign In</title>
  <link href="../../resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
  <link href="../../resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  
  <div class="container">
    
    <form class="form-signin" action="./login" method="POST">
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
      <label for="inputPassword" class="sr-only" name="password">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
      <div class="checkbox">
        <label>
          <!-- <input type="checkbox" value="remember-me"> Remember me -->
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
    
  </div>
</body>
</html>