/*package scheduler;

import java.io.*;
import java.util.*;

//Chromosome represents array of genes as complete timetable (looks like gene[0]gene[1]gene[2]...)
public class Chromosome implements Comparable<Chromosome>,Serializable{
	
	static double crossoverrate=inputdata.crossoverrate;
	static double mutationrate=inputdata.mutationrate;
	static int hours=inputdata.hoursperday,days=inputdata.daysperweek;
	static int nostgrp=inputdata.nostudentgroup;
	double fitness;
	int point;
	
	public Gene[] gene;
	
	Chromosome(){
		
		gene=new Gene[nostgrp];
		
		for(int i=0;i<nostgrp;i++){
			
			gene[i]=new Gene(i);
			
			//System.out.println("");
		}
		fitness=getFitness();		
		
	}
	
	public Chromosome deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Chromosome) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public double getFitness(){
		point=0;
		for(int i=0;i<hours*days;i++){
			
			List<Integer> teacherlist=new ArrayList<Integer>();
			
			for(int j=0;j<nostgrp;j++){
			
				Slot slot;
				//System.out.println("i="+i+" j="+j);
				if(TimeTable.slot[gene[j].slotno[i]]!=null)
					slot=TimeTable.slot[gene[j].slotno[i]];
				else slot=null;

				if(slot!=null){
				
					if(teacherlist.contains(slot.teacherid)){
						point++;
					}
					else teacherlist.add(slot.teacherid);
				}
			}	
			
			
		}
		//System.out.println(point);
		fitness=1-(point/((nostgrp)*hours*days));
		point=0;
		return fitness;
	}
	
	
	
	//printing final timetable
	public void printTimeTable(){
		
		//for each student group separate time table
		for(int i=0;i<nostgrp;i++){
			
			//status used to get name of student grp because in case first class is free it will throw error
			boolean status=false;
			int l=0;
			while(!status){
				
				//printing name of batch
				if(TimeTable.slot[gene[i].slotno[l]]!=null){
					System.out.println("Batch "+TimeTable.slot[gene[i].slotno[l]].studentgroup.name+" Timetable-");
					
					status=true;
				}
				l++;
			
			}
			
			//looping for each day
			for(int j=0;j<days;j++){
				
				//looping for each hour of the day
				for(int k=0;k<hours;k++){
				
					//checking if this slot is free otherwise printing it
					if(TimeTable.slot[gene[i].slotno[k+j*hours]]!=null)
						
						System.out.print(TimeTable.slot[gene[i].slotno[k+j*hours]].subject+" ");
				
					else System.out.print("*FREE* ");
				
				}
				
				System.out.println("");
			}
			
			System.out.println("\n\n\n");
		
		}

	}
	
	
	
	public void printChromosome(){
		
		for(int i=0;i<nostgrp;i++){
			for(int j=0;j<hours*days;j++){
				System.out.print(gene[i].slotno[j]+" ");
			}
			System.out.println("");
		}
		
	}



	public int compareTo(Chromosome c) {
		
		if(fitness==c.fitness) return 0;
		else if(fitness>c.fitness) return -1;
		else return 1;
	
	}
	
	
	
}*/


package scheduler;

import java.io.*;
import java.util.*;

//Chromosome represents array of genes as complete timetable (looks like gene[0]gene[1]gene[2]...)
public class Chromosome implements Comparable<Chromosome>,Serializable{   // Comparable<chromosome> holds information regarding each chromosome.
	                                           // Serializable : To serialize an object i.e to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object.
	static double crossoverrate=inputdata.crossoverrate;
	static double mutationrate=inputdata.mutationrate;
	static int hours=inputdata.hoursperday,days=inputdata.daysperweek;
	static int nottable=inputdata.notimetable;
	double fitness;
	int point;
	
	public Gene[] gene;
	
	Chromosome(){
		
		gene=new Gene[nottable];
		
		for(int i=0;i<nottable;i++){     // initializing gene(timetable) for each timetable schedule
			
			gene[i]=new Gene(i);
			
			//System.out.println("");
		}
		fitness=getFitness();		
		
	}
	
	public Chromosome deepClone() {  // if perform deep clone (copy) on an object that contains reference (object), both the original and copied object refers to different objects and, if you do any changes to the data of copied object they are not reflected in the original object.
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); //output stream in which the data is written into a byte array. The buffer automatically grows as data is written to it.
			ObjectOutputStream oos = new ObjectOutputStream(baos);  // An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream. 
			oos.writeObject(this);  // The method writeObject is used to write an object to the stream

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());  // A ByteArrayInputStream contains an internal buffer that contains bytes that may be read from the stream. An internal counter keeps track of the next byte to be supplied by the read method. Data can retrieved using toByteArray method
			ObjectInputStream ois = new ObjectInputStream(bais); //deserializes primitive data and objects previously written using an ObjectOutputStream. ensures that the types of all objects in the graph created from the stream match the classes present in the Java Virtual Machine. Classes are loaded as required using the standard mechanisms.
			return (Chromosome) ois.readObject();  // reads an object from the serialized class.
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public double getFitness(){
		point=0;
		for(int i=0;i<hours*days;i++){
			
			List<Integer> subjectlist=new ArrayList<Integer>();
			
			for(int j=0;j<nottable;j++){  //getting each slot for each timetable throughout the week
			
				Slot slot;
				//System.out.println("i="+i+" j="+j);
				if(TimeTableSchedule.slot[gene[j].slotno[i]]!=null)
					slot=TimeTableSchedule.slot[gene[j].slotno[i]];
				else slot=null;

				if(slot!=null){
				
					if(subjectlist.contains(slot.subjectid)){  // assigning subject id to each slot
						point++;
					}
					else subjectlist.add(slot.subjectid);
				}
			}	
			
			
		}
		//System.out.println(point);  // calculating fitness
		fitness=1-(point/((nottable)*hours*days));  // fitness = 1 - ( subjects's assigned / total no of hours throughout the week for all (timetable-1))
		point=0;                       // here point is no of slots assigned with subjects
		return fitness;
	}
	
	
	
	//printing final timetable
	public void printTimeTableSchedule(){
		
		//for each timetable separate schedule
		for(int i=0;i<nottable;i++){
			
			//status used to get name of timetable because in case first class is free it will throw error
			boolean status=false;
			int l=0;
			while(!status){
				
				//printing name of batch
				if(TimeTableSchedule.slot[gene[i].slotno[l]]!=null){
					System.out.println("Batch "+TimeTableSchedule.slot[gene[i].slotno[l]].timetable.name+" Timetable-");
					
					status=true;
				}
				l++;
			
			}
			
			//looping for each day
			for(int j=0;j<days;j++){
				
				//looping for each hour of the day
				for(int k=0;k<hours;k++){
				
					//checking if this slot is free otherwise printing it
					if(TimeTableSchedule.slot[gene[i].slotno[k+j*hours]]!=null)
						
						System.out.print(TimeTableSchedule.slot[gene[i].slotno[k+j*hours]].module+" "); // printing module for that slotno
				
					else System.out.print("*FREE* ");
				
				}
				
				System.out.println("");
			}
			
			System.out.println("\n\n\n");
		
		}

	}
	
	
	
	public void printChromosome(){   // printing chromosome for timetable for each  schedule
		
		for(int i=0;i<nottable;i++){
			for(int j=0;j<hours*days;j++){
				System.out.print(gene[i].slotno[j]+" ");
			}
			System.out.println("");
		}
		
	}



	public int compareTo(Chromosome c) {   // comparing fitness of chromosome with the calculated fitness
		
		if(fitness==c.fitness) return 0;
		else if(fitness>c.fitness) return -1;
		else return 1;
	
	}
	
	
	
}