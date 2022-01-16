/*package scheduler;

public class Timetable {
	public int id;
	public String name;
	public String[] subject;
	public int nosubject;
	public int teacherid[];
	public int[] hours;
	
	public Timetable() {
		subject=new String[10];
		hours=new int[10];
		teacherid=new int[10];
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSubject() {
		return subject;
	}
	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	public int getNosubject() {
		return nosubject;
	}
	public void setNosubject(String snosubject) {
		int nosubject=Integer.parseInt(snosubject);
		this.nosubject = nosubject;
	}
	public int[] getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int[] teacherid) {
		this.teacherid = teacherid;
	}
	public int[] getHours() {
		return hours;
	}
	public void setHours(int[] hours) {
		this.hours = hours;
	}
	
}*/

package scheduler;

public class Timetable {
	public int id;
	public String name;
	public String[] module;
	public int nomodule;
	public int subjectid[];
	public int[] hours;
	
	public Timetable() {
		module=new String[10];
		hours=new int[10];
		subjectid=new int[10];
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getModule() {
		return module;
	}
	public void setModule(String[] module) {
		this.module = module;
	}
	public int getNomodule() {
		return nomodule;
	}
	public void setNomodule(String snomodule) {
		int nomodule=Integer.parseInt(snomodule);
		this.nomodule = nomodule;
	}
	public int[] getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int[] subjectid) {
		this.subjectid = subjectid;
	}
	public int[] getHours() {
		return hours;
	}
	public void setHours(int[] hours) {
		this.hours = hours;
	}
	
}


