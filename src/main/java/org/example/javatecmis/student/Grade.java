package org.example.javatecmis.student;

import org.example.javatecmis.connect.studentConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Grade {
    private String TgNumber;
    private String name = null;
    private String grade = null;

    public Grade(String tgNumber) {
        TgNumber = tgNumber;
    }
    public Grade(String name,String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getSGPA(){
        String sgpa = "err";

        try{
            String sgpaQuery = "Select * from student_sgpa where Std_id = '"+TgNumber+"'";
            studentConnect conn = new studentConnect();
            PreparedStatement ptr = conn.connect().prepareStatement(sgpaQuery);
            ResultSet result = ptr.executeQuery();

            while(result.next()){
                sgpa = result.getString(2);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        double v = Double.parseDouble(sgpa);
        String formattedSgpa = String.format("%.3f", v);
        return formattedSgpa;
    }

    public String getCGPA(){
        String cgpa = "err";

        try{
            String sgpaQuery = "Select * from student_cgpa where Std_id = '"+TgNumber+"'";
            studentConnect conn = new studentConnect();
            PreparedStatement ptr = conn.connect().prepareStatement(sgpaQuery);
            ResultSet result = ptr.executeQuery();

            while(result.next()){
                cgpa = result.getString(2);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        double v = Double.parseDouble(cgpa);
        String formattedSgpa = String.format("%.3f", v);
        return formattedSgpa;
    }
}
