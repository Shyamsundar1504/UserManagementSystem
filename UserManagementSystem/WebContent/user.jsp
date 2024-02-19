<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <% if(session.getAttribute("name")==null){
    	response.sendRedirect("home.jsp");
    }%>
<!DOCTYPE html>
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
<body style="background-color:silver">
<div>
<nav class="navbar navbar-expand-lg navbar-light">
 <span class="navbar-brand mb-0 h1 text-white">User Management System</span>
  <ul  class="navbar-nav " >
    <li><a href="register" class="nav-link text-success  btn-outline-success rounded-pill"  >Add User</a></li> 
    <li><a href="list" class="nav-link text-success btn-outline-success rounded-pill">View User List</a></li> 
     <li><a href="logout" class="nav-link text-success btn-outline-success rounded-pill">Logout</a></li>
    
  </ul>
     <ul  class="navbar-nav " style=" padding-left: 50%;">
    
     <li><a  class="nav-link  text-warning border border-warning rounded-pill"><%= session.getAttribute("name") %></a></li>
  </ul>
  </nav>
</div>
       <table class="table table-striped table-hover table-secondary" >
           <thead class="thead-dark">
           <tr>
               <th>Id</th>
               <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>modify</th>
              </tr>  
   </thead>
           <tbody>
              <c:forEach var="user1" items="${user}">
            <tr>
               <td><c:out value="${user1.id}"/></td>
                <td><c:out value="${user1.name}"/></td>
                <td><c:out value="${user1.email}"/></td>
                <td><c:out value="${user1.address}"/></td>
                <td>
                <a href="edit?id=<c:out value="${user1.id}"/>" class="btn btn-success">Edit</a>
                <a href="delete?id=<c:out value="${user1.id}"/>" class="btn btn-danger ">Delete</a>
                </td>
            </tr>
            </c:forEach>
           </tbody>
       </table>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" ></script>
</html>