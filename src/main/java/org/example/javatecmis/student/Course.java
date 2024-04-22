package org.example.javatecmis.student;

import javafx.scene.control.ChoiceBox;

public class Course{
    private String CourseId = null;
    private String CourseName = null;
    private String CourseType = null;
    private int CourseCredit = 0;
    private String CourseLecture = null;
    public Course(){
       // super();
    }
    public Course(String courseId, String courseName, String courseType, int courseCredit, String courseLecture) {
        CourseId = courseId;
        CourseName = courseName;
        CourseType = courseType;
        CourseCredit = courseCredit;
        CourseLecture = courseLecture;
    }

    public String getCourseId() { return CourseId; }

    public String getCourseName() { return CourseName; }

    public String getCourseType() {
        return CourseType;
    }

    public int getCourseCredit() {
        return CourseCredit;
    }

    public String getCourseLecture() {
        return CourseLecture;
    }


    public String[] filter = {"Default","Theory","Practical","Both"};


}
