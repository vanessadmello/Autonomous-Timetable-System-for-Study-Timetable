<%@page import="scheduler.*"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

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
	<meta name="viewport" >
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>View TimeTable | Time Table Generator</title>
</head>

<body>
<%
	
	Chromosome chrom=(Chromosome) request.getSession().getAttribute("son");
	int hours=inputdata.hoursperday,days=inputdata.daysperweek;
	int nottable=inputdata.notimetable;
	Gene[] gene=chrom.gene;
	
	//days(only for display purpose)
	//String[] day=new String[days];
	
			
	//slot and break timings(only for display purpose)
	String start[]=new String[hours];
	String end[]=new String[hours];
	for(int i=0;i<hours;i++){
		start[i]=request.getParameter("start"+i);
		end[i]=request.getParameter("end"+i);
	}
	int breakslot=0;
	String sbreakslot=request.getParameter("breakslot");
	if(sbreakslot!=null)breakslot=Integer.parseInt(sbreakslot);
	
	//for each student group separate time table
	for(int i=0;i<nottable;i++){

		//status used to get name of student grp because in case first class is free it will throw error
		boolean status=false;
		int l=0;
		while(!status){
			
			//printing name of batch
			if(TimeTableSchedule.slot[gene[i].slotno[l]]!=null){
				
				out.print("<div class='w3-container w3-padding-16 w3-pale-blue w3-display-middle'><h3>Timetable</h3>");
				status=true;
			
			}
			l++;		
		}
		
		//printing column headings
		out.print("<table border='1px' width='100%' style='text-align:center' class='w3-table-all w3-centered'>");		
		out.print("<thead><tr><td></td>");
		for(int k=0;k<hours;k++){
			
			//printing break if it exist
			if(sbreakslot!=null)
				if(breakslot==k)
					out.print("<th style='text-align:center;width:60px'>Break</th>");
			
			//printing heading
			if(start[k]!=null)
				out.print("<th style='text-align:center'>"+start[k]+"-"+end[k]+"</th>");
			else out.print("<th style='text-align:center'>Period "+(k+1)+"</th>");
		
		}
		out.print("</tr></thead>");
		out.print("<tbody>");
		
		
		//looping for each day
		for(int j=0;j<days;j++){
			
			
			out.print("<tr><td>Day "+(j+1)+"</td>");
			
			
			//looping for each hour of the day
			for(int k=0;k<hours;k++){
			
				//printing break if it exist
				if(sbreakslot!=null)
					if(breakslot==k)
						out.print("<td></td>");
				
				
				//checking if this slot is free otherwise printing it
				if(TimeTableSchedule.slot[gene[i].slotno[k+j*hours]]!=null){
					String subjectname=scheduler.inputdata.subject[TimeTableSchedule.slot[gene[i].slotno[k+j*hours]].subjectid].getName();
					out.print("<td style='text-align:center'>"+TimeTableSchedule.slot[gene[i].slotno[k+j*hours]].module+"<br>"+subjectname+"</td>");
				}
				else out.print("<td></td>");
			
			}
			
			out.print("</tr>");
		}
		
		out.print("</tbody></table></div><hr>");
	
	}
%>


</body>

</html>

