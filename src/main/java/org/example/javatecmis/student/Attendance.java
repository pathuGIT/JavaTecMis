package org.example.javatecmis.student;

public class Attendance {
    private String Course = null;
    private String Att = null;

    public Attendance(String course, String att) {
        Course = course;
        Att = att;
    }

    public String getCourse() {
        return Course;
    }

    public String getAtt() {
        return Att;
    }


}
