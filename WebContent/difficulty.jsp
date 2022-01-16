<%
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server
%> 

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home | Time Table Generator</title>
</head>

<body>
	<form action="<%=request.getContextPath()%>/Timetable" method="post">
		
		<input type="submit" value="Submit for custom input">

	</form>
				
</body>

</html>
