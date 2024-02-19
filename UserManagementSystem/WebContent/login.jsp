<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<style type="text/css">
   .navbar{
   background-color: black;
   }
</style>
</head>
<body style=" background: lightblue;">

<nav class="navbar navbar-expand-lg navbar-light  d-flex justify-content-between">
 
 <span class="navbar-brand mb-0 h1 text-white">User Management System</span>
 </nav>

 <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">

<div class="col-md-3" style=" margin-top: 5% "></div>
<div class="container col-md-4 px-5 py-5 bg-light text-dark mt-3" style="border: 0px solid  ; ">
<form action="login" method="post" class="form-group" >
    <h1 class="text-center">Log in</h1>
   
    
  

    <label for="email" class="mt-2">Email</label>
    <input type="text" id="email" class="form-control " name="email" placeholder="abc@gmail.com" required>  

    <label for="password" class="mt-2">Password</label>
    <input type="password" id="password" class="form-control " name="password" placeholder="Enter Password" required>

  

    <label>
      <input class="mt-2" type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>

    
    <div >
      
      <button class="btn btn-primary btn-lg text-center" type="submit">Log in</button>
    </div>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" ></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
  var status=document.getElementById("status").value;
  if(status == "failed"){
	  swal("sorry","your email & password incorrect","error");
  }

</script>
	
</body>
</html>