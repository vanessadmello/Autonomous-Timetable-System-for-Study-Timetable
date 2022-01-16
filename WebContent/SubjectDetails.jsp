<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
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
  <title>Timetable Details | Autonomous Timetable System</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<script>

 function display() {
  var j = document.getElementById("subjectno").value;
  var ele = document.getElementById("subjectno");
  ele.parentNode.removeChild(ele);
  ele = document.getElementById("label");
  ele.parentNode.removeChild(ele);
  ele = document.getElementById("subjectsubmit");
  ele.parentNode.removeChild(ele);

  a = document.getElementById("demo");
  table = document.createElement("table");
  table.border = '1';
  a.appendChild(table);
  var tbody = document.createElement("tbody");
  table.appendChild(tbody);
  for (i = 0; i < j; i++) {
    tr = document.createElement("tr");
    td1 = document.createElement("td");
    td2 = document.createElement("td");
    td3 = document.createElement("td");
    
    td3.setAttribute("id", "t"+(i + 1));

    b = document.createElement("input");
    c = document.createElement("label");
    d = document.createElement("label");
    e = document.createElement("input");
    g = document.createElement("input");

    b.setAttribute("class", "w3-input w3-border w3-round");
    b.setAttribute("type", "text");
    b.setAttribute("name", "s" + (i + 1));
    b.setAttribute("id", "s" + (i + 1));
    c.setAttribute("for", "s" + (i + 1));
    c.textContent = "Subject " + (i + 1)+ " : ";

    d.textContent = "Number of Modules :";
    e.setAttribute("class", "w3-input w3-border w3-round");
    e.setAttribute("type", "text");
    e.setAttribute("name", "m" + (i + 1));
    e.setAttribute("id", "m" + (i + 1));
    d.setAttribute("for", "m" + (i + 1));

    g.setAttribute("type", "button");
    g.setAttribute("class", "w3-button w3-blue w3-round-large w3-medium")
    g.setAttribute("value", "submit");
    g.setAttribute("name", (i + 1));
    g.setAttribute("id", "h" + (i + 1));
    g.setAttribute("onClick", "displayModules(name)");
  
    td1.appendChild(c);
    td1.appendChild(b);
    td2.appendChild(d);
    td2.appendChild(e);
    td3.appendChild(g);
   
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);

    tbody.appendChild(tr);
  }
  
  b = document.createElement("input");
  b.setAttribute("type", "submit");
  b.setAttribute("class", "w3-button w3-blue w3-round-large w3-medium")
  a.appendChild(b);
  
 }
 function displayModules(id){ 
    var j = document.getElementById("m"+id).value;
    var td = document.getElementById("t"+id);
    var ele = document.getElementById("h" + id);
    ele.parentNode.removeChild(ele);

    table = document.createElement("table");
    td.appendChild(table);
    var tbody = document.createElement("tbody");
    table.appendChild(tbody);
    console.log(j);

    for (i = 0; i < j; i++) {
      tr = document.createElement("tr");
      td1 = document.createElement("td");
      td2 = document.createElement("td");

      b = document.createElement("input");
      c = document.createElement("label");
      d = document.createElement("label");
      e = document.createElement("input");

      b.setAttribute("class", "w3-input w3-border w3-round");
      b.setAttribute("type", "text");
      b.setAttribute("name", "mod" + (i + 1));
      b.setAttribute("id", "mod" + (i + 1));
      c.setAttribute("for", "mod" + (i + 1));
      c.textContent = "Module " + (i + 1) + " : ";

      e.setAttribute("class", "w3-input w3-border w3-round");
      d.textContent = "Number of Hours :";
      e.setAttribute("type", "text");
      e.setAttribute("name", "hour" + (i + 1));
      e.setAttribute("id", "hour" + (i + 1));
      d.setAttribute("for", "hour" + (i + 1));

      td1.appendChild(c);
      td1.appendChild(b);
      td2.appendChild(d);
      td2.appendChild(e);

      tr.appendChild(td1);
      tr.appendChild(td2);

      tbody.appendChild(tr);
    }

 }
</script>

<body>
  <div class="w3-container w3-padding-16 w3-pale-blue w3-display-middle">
      <h1>Subject Details</h1>
      <form id="demo" action="<%=request.getContextPath()%>/subjectdetails.jsp" method="post" >
        <label for="subjectno" id="label">Number of Subjects:</label>
        <input id="subjectno" class="w3-input w3-border w3-round" type="text" id="subjectno">
        <br />
      </form>
    <br />
    <input type="button" class="w3-button w3-blue w3-round-large w3-medium w3-display-bottommiddle" value="Submit" id="subjectsubmit" onclick="display()" />
  </div>

</body>
</html>
