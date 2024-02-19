<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management System</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style type="text/css">
   .navbar{
   background-color: black;
   }
</style>
</head>
<body style="background-color:lightblue;">
<div>
<nav class="navbar navbar-expand-lg navbar-light ">
 <span class="navbar-brand mb-0 h1 text-white">User Management System</span>
  <ul  class="navbar-nav ">
    <li><a href="list" class="nav-link text-success btn-outline-success rounded-pill">View User List</a></li>
  </ul>

  </nav>
</div>

<div class="container col-md-4 px-5 py-5 bg-dark " style="border: 1px solid ; margin-top: 5% ;   ">

   <form action="insert" method="post" class="form-grop">
   <h2 class="text text-center text-warning">User Details</h2>
      
         <label for="name"  class="text-white">Name</label>
       <input type="text" id="name" class="form-control " name="name" placeholder="Enter The Name"><br>
         <label for="email"  class="text-white">Email</label>
       <input type="email" id="email" class="form-control" name="email" placeholder="Enter The Email"><br>
         <label for="address"  class="text-white">Address</label>
       <input type="text" id="address" class="form-control" name="address" placeholder="Enter The Address"><br>
       <button type="submit" class="btn btn-primary" >Submit</button>
   </form>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" ></script>
</html>