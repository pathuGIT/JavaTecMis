package org.example.javatecmis.lecturer;


public class StDetails {


    private String sId = null;
    private String sName = null;
    private String sEmail = null;
    private String sContact = null;
    private String sNIC = null;


    public StDetails(String stid,String sname, String semail,String scontact,String snic){
        sId = stid;
        sName = sname;
        sEmail = semail;
        sContact = scontact;
        sNIC = snic;

    }

    public String getSId(){return sId;}
    public String getSName(){return sName;}
    public  String getSEmail(){return sEmail;}
    public String getSContact(){return sContact;}
    public String getSNIC(){return sNIC;}



}
