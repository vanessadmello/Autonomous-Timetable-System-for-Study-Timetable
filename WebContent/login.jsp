<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 <!DOCTYPE html>
 <html>
<head>
 <style>
  body {
   padding: none;
   margin: none;
   background: url(./images/timetable.jfif);
   background-repeat: no-repeat;
   background-size: cover;
   background-position: center;
   background-attachment: fixed;
   width: 100%;
  }
 </style>
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <title>Login | Autonomous Timetable System</title>
</head>
 <body>
  <div class="w3-container w3-padding-16 w3-pale-blue w3-display-middle">
   <h1>Student Login Form</h1>
   <form action="<%=request.getContextPath()%>/login" method="post">
    <table style="width: 100%">
     <tr>
      <td>Email: </td>
      <td><input type="email" class="w3-input w3-border w3-round" name="email" /></td>
     </tr>
     <tr>
      <td>Password: </td>
      <td><input type="password" class="w3-input w3-border w3-round" name="password" /></td>
     </tr>
    </table>
    <input type="submit" value="Submit" class="w3-button w3-blue w3-round-xlarge w3-medium"/>
   </form>
   <a href="Register.jsp"> Don't have an account? Register Here! </a>
  </div>
 </body>
</html>