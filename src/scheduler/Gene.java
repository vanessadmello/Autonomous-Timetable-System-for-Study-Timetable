/*package scheduler;

import java.util.Random;
import java.io.*;

//gene represents permutation of slots as timetable for a single student group(looks like {5,22,14,1,...} )
public class Gene implements Serializable{

	public int slotno[];
	int days=inputdata.daysperweek;
	int hours=inputdata.hoursperday;
	
	Random r=new Random();
	
	Gene(int i){
		
		boolean[] flag=new boolean[days*hours];
		
		/*  generating an array of slot no corresponding to index of gene eg suppose index
		 *	is 2 then slotno will vary from 2*hours*days to 3*hours*days
		
		
		slotno=new int[days*hours];
		
		for(int j=0;j<days*hours;j++){
			
			int rnd;
			while(flag[rnd=r.nextInt(days*hours)]==true){}
			flag[rnd]=true;
			slotno[j]=i*days*hours + rnd;
			
			/*	Slot[] slot=TimeTable.returnSlots();
			 *	if(slot[slotno[j]]!=null)System.out.print(slot[slotno[j]].subject+" ");
			 *	else System.out.print("break ");
			 
		
		}
		
	}
	
	public Gene deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Gene) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}*/


package scheduler;

import java.util.Random;
import java.io.*;

//gene represents permutation of slots as timetable for a single student group(looks like {5,22,14,1,...} )
public class Gene implements Serializable{  // Serializable : To serialize an object i.e to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object.

	public int slotno[];
	int days=inputdata.daysperweek;
	int hours=inputdata.hoursperday;
	
	Random r=new Random();
	
	Gene(int i){
		
		boolean[] flag=new boolean[days*hours];
		
		/*  generating an array of slot no corresponding to index of gene eg suppose index
		 *	is 2 then slotno will vary from 2*hours*days to 3*hours*days
		 */
		
		slotno=new int[days*hours];
		
		for(int j=0;j<days*hours;j++){
			
			int rnd;
			while(flag[rnd=r.nextInt(days*hours)]==true){}   // find a random slot from total slots in a week and assign to rnd.
			flag[rnd]=true;
			slotno[j]=i*days*hours + rnd;  // randomly assign all the slots to all the slotno's of the week
			
			/*	Slot[] slot=TimeTable.returnSlots();
			 *	if(slot[slotno[j]]!=null)System.out.print(slot[slotno[j]].subject+" ");
			 *	else System.out.print("break ");
			 */
		
		}
		
	}
	
	public Gene deepClone() {  // if perform deep clone (copy) on an object that contains reference (object), both the original and copied object refers to different objects and, if you do any changes to the data of copied object they are not reflected in the original object.
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  //output stream in which the data is written into a byte array. The buffer automatically grows as data is written to it.
			ObjectOutputStream oos = new ObjectOutputStream(baos);  // An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream. 
			oos.writeObject(this);  // The method writeObject is used to write an object to the stream

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());  // A ByteArrayInputStream contains an internal buffer that contains bytes that may be read from the stream. An internal counter keeps track of the next byte to be supplied by the read method. Data can retrieved using toByteArray method
			ObjectInputStream ois = new ObjectInputStream(bais);   //deserializes primitive data and objects previously written using an ObjectOutputStream. ensures that the types of all objects in the graph created from the stream match the classes present in the Java Virtual Machine. Classes are loaded as required using the standard mechanisms.
			return (Gene) ois.readObject();   // reads an object from the serialized class.
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}