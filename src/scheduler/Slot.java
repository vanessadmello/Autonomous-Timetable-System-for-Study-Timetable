/*package scheduler;

//slot is single block of timetable

public class Slot{
	public StudentGroup studentgroup;
	public int teacherid;
	public String subject;
	
	//non parametrized constructor for allowing free periods
	Slot(){};
	
	Slot(StudentGroup studentgroup,int teacherid,String subject){
		
		this.studentgroup=studentgroup;
		this.subject=subject;
		this.teacherid=teacherid;
	
	}
}*/

package scheduler;

//slot is single block of timetable

public class Slot{
	public Timetable timetable;
	public int subjectid;
	public String module;
	
	//non parametrized constructor for allowing free periods
	Slot(){};
	
	Slot(Timetable timetable,int subjectid,String module){
		
		this.timetable=timetable;
		this.module=module;
		this.subjectid=subjectid;
	
	}
}
