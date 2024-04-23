package org.example.javatecmis.admin;

import javafx.beans.property.*;

public class LectureTable {
    private final StringProperty lec_id1;
    private final StringProperty lec_name1;
    private final StringProperty lec_email1;
    private final StringProperty lec_pass1;
    private final StringProperty lec_cont1;
    private final StringProperty lec_dep1;

    public LectureTable(){
        lec_id1 = new SimpleStringProperty(this,"Id");
        lec_name1 = new SimpleStringProperty(this,"Name");
        lec_email1 = new SimpleStringProperty(this,"Email");
        lec_pass1 = new SimpleStringProperty(this,"Password");
        lec_cont1 = new SimpleStringProperty(this,"Contact");
        lec_dep1 = new SimpleStringProperty(this,"Department");

    }

    public StringProperty lec_id1Property(){return lec_id1;}
    public String getLec_id1(){return lec_id1.get();}
    public void setLec_id1(String newId){lec_id1.set(newId);}

    public StringProperty lec_name1Property(){return lec_name1;}
    public String getLec_name1(){return lec_name1.get();}
    public void setLec_name1(String newName){lec_name1.set(newName);}

    public StringProperty lec_email1Property(){return lec_email1;}
    public String getLec_email1(){return lec_email1.get();}
    public void setLec_email1(String newEmail){lec_email1.set(newEmail);}

    public StringProperty lec_pass1Property(){return lec_pass1;}
    public String getLec_pass1(){return lec_pass1.get();}
    public void setLec_pass1(String newPassword){lec_pass1.set(newPassword);}

    public StringProperty lec_cont1Property(){return lec_cont1;}
    public String getLec_cont1(){return lec_cont1.get();}
    public void setLec_cont1(String newContact){lec_cont1.set(newContact);}

    public StringProperty lec_dep1Property(){return lec_dep1;}
    public String getLec_dep1(){return lec_dep1.get();}
    public void setLec_dep1(String newDepartment){lec_dep1.set(newDepartment);}

}
