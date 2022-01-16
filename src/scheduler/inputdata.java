/*package scheduler;

import java.io.File;
import java.util.*;

public class inputdata {

	public static StudentGroup[] studentgroup;
	public static Teacher[] teacher;
	public static double crossoverrate = 1.0, mutationrate = 0.1;
	public static int nostudentgroup, noteacher;
	public static int hoursperday, daysperweek;

	public inputdata() {
		studentgroup = new StudentGroup[100];
		teacher =   new Teacher[100];
	}

	boolean classformat(String l) {
		StringTokenizer st = new StringTokenizer(l, " ");
		if (st.countTokens() == 3)
			return (true);
		else
			return (false);
	}

	public void takeinput()// takes input from file input.txt
	{
		//this method of taking input through file is only for development purpose so hours and days are hard coded
		hoursperday = 7;
		daysperweek = 5;
		try {
			File file = new File("C:\\Users\\dmell\\eclipse-workspace1\\Time-table-scheduler-master (1)\\Time-table-scheduler-master\\input.txt");
			// File file = new File(System.getProperty("user.dir") +
			// "/input.txt");
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				// input student groups
				if (line.equalsIgnoreCase("studentgroups")) {
					int i = 0, j;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("teachers")) {
						studentgroup[i] = new StudentGroup();
						StringTokenizer st = new StringTokenizer(line, " ");
						studentgroup[i].id = i;
						studentgroup[i].name = st.nextToken();
						studentgroup[i].nosubject = 0;
						j = 0;
						while (st.hasMoreTokens()) {
							studentgroup[i].subject[j] = st.nextToken();
							studentgroup[i].hours[j++] = Integer.parseInt(st.nextToken());
							studentgroup[i].nosubject++;
						}
						i++;
					}
					nostudentgroup = i;
				}

				//input teachers
				if (line.equalsIgnoreCase("teachers")) {
					int i = 0;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
						teacher[i] = new Teacher();
						StringTokenizer st = new StringTokenizer(line, " ");
						teacher[i].id = i;
						teacher[i].name = st.nextToken();
						teacher[i].subject = st.nextToken();

						i++;
					}
					noteacher = i;
				}

			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assignTeacher();

	}

	// assigning a teacher for each subject for every studentgroup
	public void assignTeacher() {

		// looping through every studentgroup
		for (int i = 0; i < nostudentgroup; i++) {

			// looping through every subject of a student group
			for (int j = 0; j < studentgroup[i].nosubject; j++) {

				int teacherid = -1;
				int assignedmin = -1;

				String subject = studentgroup[i].subject[j];

				// looping through every teacher to find which teacher teaches the current subject
				for (int k = 0; k < noteacher; k++) {

					// if such teacher found,checking if he should be assigned the subject or some other teacher based on prior assignments
					if (teacher[k].subject.equalsIgnoreCase(subject)) {

						// if first teacher found for this subject
						if (assignedmin == -1) {
							assignedmin = teacher[k].assigned;
							teacherid = k;
						}

						// if teacher found has less no of pre assignments than the teacher assigned for this subject
						else if (assignedmin > teacher[k].assigned) {
							assignedmin = teacher[k].assigned;
							teacherid = k;
						}
					}
				}

				// 'assigned' variable for selected teacher incremented
				teacher[teacherid].assigned++;

				studentgroup[i].teacherid[j]= teacherid;
			}
		}
	}
}*/

package scheduler;

import java.io.File;
import java.util.*;

public class inputdata {

	public static Timetable[] timetable;
	public static Subject[] subject;
	public static double crossoverrate = 1.0, mutationrate = 0.1;
	public static int notimetable, nosubject;
	public static int hoursperday, daysperweek;

	public inputdata() {
		timetable = new Timetable[100];
		subject =   new Subject[100];
	}

	boolean classformat(String l) {
		StringTokenizer st = new StringTokenizer(l, " ");
		if (st.countTokens() == 3)
			return (true);
		else
			return (false);
	}

	public void takeinput()// takes input from file input.txt
	{
		//this method of taking input through file is only for development purpose so hours and days are hard coded
		hoursperday = 7;
		daysperweek = 5;
		try {
			File file = new File("C:\\Users\\dmell\\eclipse-workspace1\\Time-table-scheduler-master (1)\\Time-table-scheduler-master\\input.txt");
			// File file = new File(System.getProperty("user.dir") +
			// "/input.txt");
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				// input timetables
				if (line.equalsIgnoreCase("studentgroups")) {
					int i = 0, j;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("teachers")) {
						timetable[i] = new Timetable();
						StringTokenizer st = new StringTokenizer(line, " ");
						timetable[i].id = i;
						timetable[i].name = st.nextToken();
						timetable[i].nomodule = 0;
						j = 0;
						while (st.hasMoreTokens()) {
							timetable[i].module[j] = st.nextToken();
							timetable[i].hours[j++] = Integer.parseInt(st.nextToken());
							timetable[i].nomodule++;
						}
						i++;
					}
					notimetable = i;
				}

				//input subjects
				if (line.equalsIgnoreCase("teachers")) {
					int i = 0;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
						subject[i] = new Subject();
						StringTokenizer st = new StringTokenizer(line, " ");
						subject[i].id = i;
						subject[i].name = st.nextToken();
						subject[i].module = st.nextToken();

						i++;
					}
					nosubject = i;
				}

			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assignSubject();

	}

	// assigning a subject for each module for every timetable
	public void assignSubject() {

		// looping through every timetable
		for (int i = 0; i < notimetable; i++) {

			// looping through every module of a timetable
			for (int j = 0; j < timetable[i].nomodule; j++) {

				int subjectid = -1;
				int assignedmin = -1;

				String module = timetable[i].module[j];

				// looping through every subject to find which subject belongs to the current module
				for (int k = 0; k < nosubject; k++) {

					// if such subject found,checking if it should be assigned the module or some other subject based on prior assignments
					if (subject[k].module.equalsIgnoreCase(module)) {

						// if first subject found for this module
						if (assignedmin == -1) {
							assignedmin = subject[k].assigned;
							subjectid = k;
						}

						// if subject found has less no of pre assignments than the subject assigned for this module
						else if (assignedmin > subject[k].assigned) {
							assignedmin = subject[k].assigned;
							subjectid = k;
						}
					}
				}

				// 'assigned' variable for selected subject incremented
				subject[subjectid].assigned++;

				timetable[i].subjectid[j]= subjectid;
			}
		}
	}
}