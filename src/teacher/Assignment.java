package teacher;

import java.io.InputStream;

public class Assignment {
	private int assignmentID=2;
	private int teacherID;
	private int subjectID;
	private byte[] doc;
	private String dueDate;
	private int standard;
	
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public int getAssignmentID() {
		return assignmentID++;
	}
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public byte[] getDoc() {
		return doc;
	}
	public void setDoc(byte[] b) {
		this.doc= b;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
