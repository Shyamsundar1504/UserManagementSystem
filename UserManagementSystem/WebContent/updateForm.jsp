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
<body style="background-color:lightblue">
<div>
<nav class="navbar navbar-expand-lg navbar-light ">
  <a class="navbar-brand text-center text-light text-bold" href="#" >User management system</a>
  </nav>
</div>


<div class="container col-md-4 px-5 py-5 bg-dark" style="border: 1px solid ; margin-top:2% ;   ">
<c:if test="(user1!=null)"> </c:if>
   <form action="update" method="get" class="form-grop">
   <h2 class="text text-center text-warning">Update User Info</h2>
        <label for="id"  class="text-white">Id</label>
       <input type="number" id="id" class="form-control " value="<c:out value="${user1.id }"/>" name="id" placeholder="Enter the Id"><br>
         <label for="name"  class="text-white">Name</label>
       <input type="text" id="name" class="form-control " value="<c:out value="${user1.name }"/>" name="name" placeholder="Enter the Name"><br>
         <label for="email"  class="text-white">Email</label>
       <input type="email" id="email" class="form-control" value="<c:out value="${user1.email }"/>" name="email" placeholder="Enter the Email"><br>
         <label for="address"  class="text-white">Address</label>
       <input type="text" id="address" class="form-control" value="<c:out value="${user1.address}"/>" name="address" placeholder="Enter The Address"><br>
       <button type="submit" class="btn btn-primary" >Submit</button>
   </form>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" ></script>
</html>