<!DOCTYPE HTML>
<html>
<head>
  <title>Index</title>
  <link href="../../resources/bootstrap.css" rel="stylesheet" type="text/css">
  <link href="../../resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <div class="container">
    <h2>Congratulation ${user.firstname} you're connected</h2>
    <ul>
      <li>Email : ${user.email}</li>
      <li>Firstname : ${user.firstname}</li>
      <li>Lastname : ${user.lastname}</li>
      <li>Role : ${user.role}</li>
    </ul>
    <a href="./login"><button class="btn btn-danger">Disconnect</button></a>
  </div>
</body>
</html>