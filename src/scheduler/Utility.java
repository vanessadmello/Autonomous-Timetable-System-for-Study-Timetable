/*package scheduler;

public class Utility {
	
	public static void printInputData(){
		System.out.println("Nostgrp="+inputdata.nostudentgroup+" Noteachers="+inputdata.noteacher+" daysperweek="+inputdata.daysperweek+" hoursperday="+inputdata.hoursperday);
		for(int i=0;i<inputdata.nostudentgroup;i++){
			
			System.out.println(inputdata.studentgroup[i].id+" "+inputdata.studentgroup[i].name);
			
			for(int j=0;j<inputdata.studentgroup[i].nosubject;j++){
				System.out.println(inputdata.studentgroup[i].subject[j]+" "+inputdata.studentgroup[i].hours[j]+" hrs "+inputdata.studentgroup[i].teacherid[j]);
			}
			System.out.println("");
		}
		
		for(int i=0;i<inputdata.noteacher;i++){			
			System.out.println(inputdata.teacher[i].id+" "+inputdata.teacher[i].name+" "+inputdata.teacher[i].subject+" "+inputdata.teacher[i].assigned);
		}
	}
	
	
	public static void printSlots(){
		
		int days=inputdata.daysperweek;
		int hours=inputdata.hoursperday;
		int nostgrp=inputdata.nostudentgroup;
		System.out.println("----Slots----");
		for(int i=0;i<days*hours*nostgrp;i++){
			if(TimeTable.slot[i]!=null)
				System.out.println(i+"- "+TimeTable.slot[i].studentgroup.name+" "+TimeTable.slot[i].subject+" "+TimeTable.slot[i].teacherid);
			else
				System.out.println("Free Period");
			if((i+1)%(hours*days)==0) System.out.println("******************************");
		}
		
	}
	
	
	
}*/



package scheduler;

public class Utility {
	
	public static void printInputData(){
		System.out.println("Nottable="+inputdata.notimetable+" Nosubjects="+inputdata.nosubject+" daysperweek="+inputdata.daysperweek+" hoursperday="+inputdata.hoursperday);
		for(int i=0;i<inputdata.notimetable;i++){  // for each timetable printing its id and name modules, hours, subject
			
			System.out.println(inputdata.timetable[i].id+" "+inputdata.timetable[i].name);
			
			for(int j=0;j<inputdata.timetable[i].nomodule;j++){
				System.out.println(inputdata.timetable[i].module[j]+" "+inputdata.timetable[i].hours[j]+" hrs "+inputdata.timetable[i].subjectid[j]);
			}
			System.out.println("");
		}
		
		for(int i=0;i<inputdata.nosubject;i++){			
			System.out.println(inputdata.subject[i].id+" "+inputdata.subject[i].name+" "+inputdata.subject[i].module+" "+inputdata.subject[i].assigned);
		}
	}
	
	
	public static void printSlots(){
		
		int days=inputdata.daysperweek;
		int hours=inputdata.hoursperday;
		int nottable=inputdata.notimetable;
		System.out.println("----Slots----");
		for(int i=0;i<days*hours*nottable;i++){
			if(TimeTableSchedule.slot[i]!=null)
				System.out.println(i+"- "+TimeTableSchedule.slot[i].timetable.name+" "+TimeTableSchedule.slot[i].module+" "+TimeTableSchedule.slot[i].subjectid);
			else
				System.out.println("Free Period");
			if((i+1)%(hours*days)==0) System.out.println("******************************");   // when all slots printed for a week
		}
		
	}
	
	
	
}

