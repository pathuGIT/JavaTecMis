package org.example.javatecmis.lecturer;

public class StEligibility {
    private String Stdid = null;
    private String Crsid = null;
    private String Totalattendance = null;
    private String Camarks = null;
    private String Eligibility = null;

    public StEligibility(String stdid, String crsid, String totalattendance, String camarks, String eligibility) {
        Stdid = stdid;
        Crsid = crsid;
        Totalattendance = totalattendance;
        Camarks = camarks;
        Eligibility = eligibility;
    }

    public String getStdid() {
        return Stdid;
    }

    public String getCrsid() {
        return Crsid;
    }

    public String getTotalattendance() {
        return Totalattendance;
    }

    public String getCamarks() {
        return Camarks;
    }

    public String getEligibility() {
        return Eligibility;
    }
}
