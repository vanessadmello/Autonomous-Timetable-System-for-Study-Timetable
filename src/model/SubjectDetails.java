package model;

public class SubjectDetails {
	private String subject;
	private int sid,hours, module;
	
	//Model page for module
	//module string
	//sid, sub_id, m_id, hours
	
	
	
	public int getModule() {
		return module;
	}
	public String getSubject() {
		return subject;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getSID() {
        return sid;
    }
    public void setSID(int SID) {
        this.sid = SID;
    }
}
