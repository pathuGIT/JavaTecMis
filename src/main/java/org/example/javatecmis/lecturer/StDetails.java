package org.example.javatecmis.lecturer;


public class StDetails {


    private String Stid = null;
    private String Sname = null;
    private String Semail = null;
    private String Scontact = null;
    private String Snic = null;

    public StDetails(String stid, String sname, String semail, String scontact, String snic) {
        Stid = stid;
        Sname = sname;
        Semail = semail;
        Scontact = scontact;
        Snic = snic;
    }

    public String getStid() {
        return Stid;
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
