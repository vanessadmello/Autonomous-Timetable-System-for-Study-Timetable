package model;

import java.io.Serializable;

public class Student implements Serializable {
  
    private static final long serialVersionUID = 1L;
    private int sid;
    private String firstName;
    private String lastName;
    private String contact;
    private String collegename;
    public int getSID() {
        return sid;
    }
    public void setSID(int SID) {
        this.sid = SID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCollegeName() {
        return collegename;
    }
    public void setCollegeName(String collegename) {
        this.collegename = collegename;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
}
