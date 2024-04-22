package org.example.javatecmis.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.*;

public class StudentTable {
        private final StringProperty std_id1;
        private final StringProperty std_name1;
        private final StringProperty std_email1;
        private final StringProperty std_nic1;
        private final StringProperty std_dep1;
        private final StringProperty std_contact1;
        private final StringProperty std_pass1;

        public StudentTable() {
                std_id1 = new SimpleStringProperty(this,"Id") ;
                std_name1 = new SimpleStringProperty(this,"Name") ;
                std_email1 = new SimpleStringProperty(this,"email") ;
                std_nic1 = new SimpleStringProperty(this,"nic");
                std_dep1 = new SimpleStringProperty(this,"dep");
                std_contact1 = new SimpleStringProperty(this,"Contact");
                std_pass1 = new SimpleStringProperty(this,"password");

        }
        public StringProperty std_id1Property(){return std_id1;}
        public String getStd_id1() {
                return std_id1.get();
        }
        public void setStd_id1(String newId){std_id1.set(newId);}


        public StringProperty std_name1Property(){return std_name1;}
        public String getStd_name1() {
                return std_name1.get();
        }
        public void setStd_name1(String newName){std_name1.set(newName);}


        public StringProperty std_email1Property(){return std_email1;}
        public String getStd_email1() {
                return std_email1.get();
        }
        public void setStd_email1(String newemail){std_email1.set(newemail);}


        public StringProperty std_nic1Property(){return std_nic1;}
        public String getStd_nic1() {return std_nic1.get();}
        public void setStd_nic1(String newnic){std_nic1.set(newnic);}


        public StringProperty std_dep1Property(){return std_dep1;}
        public String getStd_dep1() {return std_dep1.get();}
        public void setStd_dep1(String newdep){std_dep1.set(newdep);}


        public StringProperty std_contact1Property(){return std_contact1;}
        public String getStd_contact1() {return std_contact1.get();}
        public void setStd_contact1(String newContact){std_contact1.set(newContact);}

        public StringProperty std_pass1Property(){return std_pass1;}
        public String getStd_pass1(){return std_pass1.get();}
        public void setStd_pass1(String newPass){std_pass1.set(newPass);}
}
