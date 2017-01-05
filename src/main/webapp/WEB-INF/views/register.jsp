<!DOCTYPE HTML>
<html>
  <head>
    <title>Sign In</title>
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
                  
                  <label for="inputPassword" class="sr-only" name="password">Password</label>
                  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <div class="checkbox">
                      <label>
                        <!-- <input type="checkbox" value="remember-me"> Remember me -->
                      </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
                  </form>
                  
                </div>
              </body>
            </html>