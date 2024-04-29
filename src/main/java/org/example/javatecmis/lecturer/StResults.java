package org.example.javatecmis.lecturer;

public class StResults {
    private String Sid;
    private String Cid;
    private String TotMark;
    private String Grade;
    private String Sgpa;
    private String Cgpa;

    public StResults(String sid, String cid, String totMark, String grade, String sgpa, String cgpa) {
        Sid = sid;
        Cid = cid;
        TotMark = totMark;
        Grade = grade;
        Sgpa = sgpa;
        Cgpa = cgpa;
    }

    public String getSid() {
        return Sid;
    }

    public String getCid() {
        return Cid;
    }

    public String getTotMark() {
        return TotMark;
    }

    public String getGrade() {
        return Grade;
    }

    public String getSgpa() {
        return Sgpa;
    }

    public String getCgpa() {
        return Cgpa;
    }
}

//SQL
//SELECT m.Std_id,m.Crs_id, m.Total_Mark, m.Grade, sg.SGPA, cg.CGPA FROM Mark m JOIN course c On m.Crs_id = c.Crs_id LEFT JOIN student_sgpa sg ON m.Std_id = sg.Std_id LEFT JOIN student_cgpa cg ON m.Std_id = cg.Std_id WHERE c.Lec_id = "LE001";