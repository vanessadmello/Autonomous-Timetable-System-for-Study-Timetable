/*package scheduler;

//through this class slots are generated to match minimum hours criteria for each subject
//also this class holds slots in order
public class TimeTableSchedule {

	public static Slot[] slot;

	TimeTableSchedule() {

		int k = 0;
		int subjectno = 0;
		int hourcount = 1;
		int days = inputdata.daysperweek;
		int hours = inputdata.hoursperday;
		int nostgrp = inputdata.nostudentgroup;

		// creating as many slots as the no of blocks in overall timetable
		slot = new Slot[hours * days * nostgrp];

		// looping for every student group
		for (int i = 0; i < nostgrp; i++) {

			subjectno = 0;
			// for every slot in a week for a student group
			for (int j = 0; j < hours * days; j++) {

				StudentGroup sg = inputdata.studentgroup[i];

				// if all subjects have been assigned required hours we give
				// free periods
				if (subjectno >= sg.nosubject) {
					slot[k++] = null;
				}

				// if not we create new slots
				else {

					slot[k++] = new Slot(sg, sg.teacherid[subjectno], sg.subject[subjectno]);

					// suppose java has to be taught for 5 hours then we make 5
					// slots for java, we keep track through hourcount
					if (hourcount < sg.hours[subjectno]) {
						hourcount++;
					} else {
						hourcount = 1;
						subjectno++;
					}

				}

			} // end inner for

		} // end outer for

	}// end constructor

	public static Slot[] returnSlots() {
		return slot;
	}
}*/


package scheduler;

//through this class slots are generated to match minimum hours criteria for each module
//also this class holds slots in order
public class TimeTableSchedule {

	public static Slot[] slot;

	TimeTableSchedule() {

		int k = 0;
		int moduleno = 0;
		int hourcount = 1;
		int days = inputdata.daysperweek;
		int hours = inputdata.hoursperday;
		int nottable = inputdata.notimetable;

		// creating as many slots as the no of blocks in overall timetables
		slot = new Slot[hours * days * nottable];

		// looping for every timetable
		for (int i = 0; i < nottable; i++) {

			moduleno = 0;
			// for every slot in a week for a timetable
			for (int j = 0; j < hours * days; j++) {

				Timetable tt = inputdata.timetable[i];

				// if all modules have been assigned required hours we give
				// free periods
				if (moduleno >= tt.nomodule) {
					slot[k++] = null;
				}

				// if not we create new slots
				else {

					slot[k++] = new Slot(tt, tt.subjectid[moduleno], tt.module[moduleno]);

					// suppose java has to be taught for 5 hours then we make 5
					// slots for java, we keep track through hourcount
					if (hourcount < tt.hours[moduleno]) {   // assigning subject according to subject priority.
						hourcount++;                        // in a week
					} else {
						hourcount = 1;
						moduleno++;
					}

				}

			} // end inner for

		} // end outer for

	}// end constructor

	public static Slot[] returnSlots() {
		return slot;
	}
}