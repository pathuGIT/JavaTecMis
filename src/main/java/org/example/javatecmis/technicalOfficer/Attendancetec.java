package org.example.javatecmis.technicalOfficer;

public class Attendancetec {
    private String TGnum= null;
    private String Course = null;
    private String Count = null;
    private String Attid = null;

    public Attendancetec(String tgnum,String course,String count, String attid) {
        TGnum = tgnum;
        Course = course;
        Count = count;
        Attid = attid;
    }
    public String getTGnum() {
        return TGnum;
    }
    public String getCourse() {
        return Course;
    }
    public String getCount() {
        return Count;
    }
    public String getAttid() {return Attid;}
}
