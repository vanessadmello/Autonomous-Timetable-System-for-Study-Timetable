/*package scheduler;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class TimetableAction {

	HttpServletRequest request;
	List<String> start, end;
	List<String> studentgroup, nosubject, stgrpsubject, subjecttime;
	List<String> teacher, teachersubject;
	String hoursperday, breakstart, breakend, daysperweek;
	int cumusubcount = 0;

	public Chromosome fromFile(){
		//invokes method to take input
		new inputdata().takeinput();
		//invokes algorithm
		new SchedulerMain();
		//grabs final chromosome i.e. the output
		Chromosome finalson = SchedulerMain.finalson;
		
		return finalson;
	}

	public boolean fromForm() {
		
		inputdata id = new inputdata();

		inputdata.daysperweek = Integer.parseInt(daysperweek);
		inputdata.hoursperday = Integer.parseInt(hoursperday);
		inputdata.nostudentgroup = studentgroup.size();

		for (int i = 0; i < studentgroup.size(); i++) {

			inputdata.studentgroup[i] = new StudentGroup();
			StudentGroup temp = inputdata.studentgroup[i];

			temp.setId(i);
			temp.setName(studentgroup.get(i));
			temp.setNosubject(nosubject.get(i));

			int nosub = Integer.parseInt(nosubject.get(i));
			String[] sub = new String[nosub];
			int[] hrs = new int[nosub];
			for (int j = 0; j < nosub; j++) {
				sub[j] = stgrpsubject.get(cumusubcount);
				hrs[j] = Integer.parseInt(subjecttime.get(cumusubcount));
				cumusubcount++;
			}

			temp.setSubject(sub);
			temp.setHours(hrs);

		}

		inputdata.noteacher = teacher.size();
		for (int i = 0; i < teacher.size(); i++) {

			inputdata.teacher[i] = new Teacher();
			Teacher tmp = inputdata.teacher[i];

			tmp.setId(i);
			tmp.setName(teacher.get(i));
			tmp.setSubject(teachersubject.get(i));
		}
		
		//after getting all input, teachers are assigned to each subject
		id.assignTeacher();

		new scheduler.SchedulerMain();

		Chromosome finalson = scheduler.SchedulerMain.finalson;
		getServletRequest().setAttribute("son", finalson);
		return true;
	}

	public List<String> getStart() {
		return start;
	}

	public void setStart(List<String> start) {
		this.start = start;
	}

	public List<String> getEnd() {
		return end;
	}

	public void setEnd(List<String> end) {
		this.end = end;
	}

	public List<String> getStudentgroup() {
		return studentgroup;
	}

	public void setStudentgroup(List<String> studentgroup) {
		this.studentgroup = studentgroup;
	}

	public List<String> getNosubject() {
		return nosubject;
	}

	public void setNosubject(List<String> nosubject) {
		this.nosubject = nosubject;
	}

	public List<String> getStgrpsubject() {
		return stgrpsubject;
	}

	public void setStgrpsubject(List<String> stgrpsubject) {
		this.stgrpsubject = stgrpsubject;
	}

	public List<String> getSubjecttime() {
		return subjecttime;
	}

	public void setSubjecttime(List<String> subjecttime) {
		this.subjecttime = subjecttime;
	}

	public List<String> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<String> teacher) {
		this.teacher = teacher;
	}

	public List<String> getTeachersubject() {
		return teachersubject;
	}

	public void setTeachersubject(List<String> teachersubject) {
		this.teachersubject = teachersubject;
	}

	public String getHoursperday() {
		return hoursperday;
	}

	public void setHoursperday(String hoursperday) {
		this.hoursperday = hoursperday;
	}

	public String getBreakstart() {
		return breakstart;
	}

	public void setBreakstart(String breakstart) {
		this.breakstart = breakstart;
	}

	public String getBreakend() {
		return breakend;
	}

	public void setBreakend(String breakend) {
		this.breakend = breakend;
	}

	public String getDaysperweek() {
		return daysperweek;
	}

	public void setDaysperweek(String daysperweek) {
		this.daysperweek = daysperweek;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

}*/



package scheduler;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class TimetableAction {

	HttpServletRequest request;
	List<String> start, end;
	List<String> timetable, nomodule, ttmodule, moduletime;
	List<String> subject, subjectmodule;
	String hoursperday, breakstart, breakend, daysperweek;
	int cumumodcount = 0;

	public Chromosome fromFile(){
		//invokes method to take input
		new inputdata().takeinput();
		//invokes algorithm
		new SchedulerMain();
		//grabs final chromosome i.e. the output
		Chromosome finalson = SchedulerMain.finalson;
		
		return finalson;
	}

	public boolean fromForm() {
		
		inputdata id = new inputdata();

		inputdata.daysperweek = Integer.parseInt(daysperweek);
		inputdata.hoursperday = Integer.parseInt(hoursperday);
		inputdata.notimetable = timetable.size();

		for (int i = 0; i < timetable.size(); i++) {  // for each timetable getting
			                                  // & setting id, timetable name and no of modules
			inputdata.timetable[i] = new Timetable();
			Timetable temp = inputdata.timetable[i];

			temp.setId(i);
			temp.setName(timetable.get(i));
			temp.setNomodule(nomodule.get(i));

			int nomod = Integer.parseInt(nomodule.get(i));
			String[] mod = new String[nomod];
			int[] hrs = new int[nomod];
			for (int j = 0; j < nomod; j++) {  // getting and setting module and respt 
				mod[j] = ttmodule.get(cumumodcount);   // hours for each timetable
				hrs[j] = Integer.parseInt(moduletime.get(cumumodcount));
				cumumodcount++;
			}

			temp.setModule(mod);
			temp.setHours(hrs);

		}

		inputdata.nosubject = subject.size();
		for (int i = 0; i < subject.size(); i++) {  // getting and setting the id, name &
			                                      // module details of each subject
			inputdata.subject[i] = new Subject();
			Subject tmp = inputdata.subject[i];

			tmp.setId(i);
			tmp.setName(subject.get(i));
			tmp.setModule(subjectmodule.get(i));
		}
		
		//after getting all input, subjects are assigned to each module
		id.assignSubject();

		new scheduler.SchedulerMain();   // SchedulerMain algorithm

		Chromosome finalson = scheduler.SchedulerMain.finalson;  // fetching the final chromosomes after schedulermain algorithm completes 
		getServletRequest().setAttribute("son", finalson);  // sets the final chromosome in request scope to be fetched by view page
		return true;
	}

	public List<String> getStart() {
		return start;
	}

	public void setStart(List<String> start) {
		this.start = start;
	}

	public List<String> getEnd() {
		return end;
	}

	public void setEnd(List<String> end) {
		this.end = end;
	}

	public List<String> getTimetable() {
		return timetable;
	}

	public void setTimetable(List<String> timetable) {
		this.timetable = timetable;
	}

	public List<String> getNomodule() {
		return nomodule;
	}

	public void setNomodule(List<String> nomodule) {
		this.nomodule = nomodule;
	}

	public List<String> getTtmodule() {
		return ttmodule;
	}

	public void setTtmodule(List<String> ttmodule) {
		this.ttmodule = ttmodule;
	}

	public List<String> getModuletime() {
		return moduletime;
	}

	public void setModuletime(List<String> moduletime) {
		this.moduletime = moduletime;
	}

	public List<String> getSubject() {
		return subject;
	}

	public void setSubject(List<String> subject) {
		this.subject = subject;
	}

	public List<String> getSubjectmodule() {
		return subjectmodule;
	}

	public void setSubjectmodule(List<String> subjectmodule) {
		this.subjectmodule = subjectmodule;
	}

	public String getHoursperday() {
		return hoursperday;
	}

	public void setHoursperday(String hoursperday) {
		this.hoursperday = hoursperday;
	}

	public String getBreakstart() {
		return breakstart;
	}

	public void setBreakstart(String breakstart) {
		this.breakstart = breakstart;
	}

	public String getBreakend() {
		return breakend;
	}

	public void setBreakend(String breakend) {
		this.breakend = breakend;
	}

	public String getDaysperweek() {
		return daysperweek;
	}

	public void setDaysperweek(String daysperweek) {
		this.daysperweek = daysperweek;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

}
