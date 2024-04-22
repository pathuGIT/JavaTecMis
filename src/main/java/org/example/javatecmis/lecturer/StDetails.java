package org.example.javatecmis.lecturer;


public class StDetails {


    private String Sid = null;
    private String Sname = null;
    private String Semail = null;
    private String Scontact = null;
    private String Snic = null;

    public StDetails(String sid, String sname, String semail, String scontact, String snic) {
        Sid = sid;
        Sname = sname;
        Semail = semail;
        Scontact = scontact;
        Snic = snic;
    }

    public String getSid() {
        return Sid;
    }

    public String getSname() {
        return Sname;
    }

    public String getSemail() {
        return Semail;
    }

    public String getScontact() {
        return Scontact;
    }

    public String getSnic() {
        return Snic;
    }
}
