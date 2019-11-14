package com.company;

public class Enroll {

    private int facultyId;
    private int studentId;
    private String dateEnrolled;

    public Enroll() {
    }

    public Enroll(int facultyId, int studentId, String dateEnrolled) {
        this.facultyId = facultyId;
        this.studentId = studentId;
        this.dateEnrolled = dateEnrolled;
    }

    public Enroll(int cid, int pid, int size) {
    }

    public int getFacultyId() { return facultyId; }

    public void setFacultyId(int facultyId) { this.facultyId =facultyId; }

    public int getStudentId() { return studentId; }

    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getDateEnrolled() { return dateEnrolled; }

    public void setDateEnrolled(String dateEnrolled) { this.dateEnrolled = dateEnrolled; }
}
