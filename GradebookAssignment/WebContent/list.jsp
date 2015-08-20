<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Gradebook</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Mackleberry</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
         <li><a href="GetList">Current List</a></li>
        <li><a href="form.jsp">Add Record</a></li>
        <li><a href="GetAvg">Avg Grade</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
         
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Assignment</th>
        <th>Grade</th>
      </tr>
    </thead>
    <tbody>
     ${fullList}
    </tbody>
  </table>
</div>

</body>
</html>
