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
  <title>Registration | Autonomous Timetable System</title>
 </head>

 <body>
  <div class="w3-container w3-padding-16 w3-pale-blue w3-display-middle">
   <h1>Student Registration Form </h1>
   <form action="<%=request.getContextPath()%>/Register" method="post">
    <table style="width: 100%">
     <tr>
      <td>Email: </td>
      <td><input class="w3-input w3-border w3-round" type="email" name="email" /></td>
     </tr>
     <tr>
      <td>Password: </td>
      <td><input class="w3-input w3-border w3-round" type="password" name="password" /></td>
     </tr>

    </table>
    <input class="w3-button w3-blue w3-round-xlarge w3-medium" type="submit" value="Submit" />
   </form>
   <a href="login.jsp"> Already have an account? Login Here! </a>
  </div>
 </body>

 </html>