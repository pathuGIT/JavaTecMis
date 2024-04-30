package org.example.javatecmis.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TechnicalOfficer {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty user_name;
    private final StringProperty pass;
    private final StringProperty contact;
    private final StringProperty email;
    private final StringProperty gender;

    public TechnicalOfficer(){
        id = new SimpleStringProperty(this,"Id");
        name = new SimpleStringProperty(this,"Name");
        user_name = new SimpleStringProperty(this,"User_name");
        pass = new SimpleStringProperty(this,"Pass");
        contact = new SimpleStringProperty(this,"Contact");
        email = new SimpleStringProperty(this,"Email");
        gender = new SimpleStringProperty(this,"Gender");
    }

    public StringProperty idProperty(){return id;}
    public String getId(){return id.get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty nameProperty(){return name;}
    public String getName(){return name.get();}
    public void setName(String newName){name.set(newName);}

    public StringProperty user_nameProperty(){return user_name;}
    public String getUser_name(){return user_name.get();}
    public void setUser_name(String newUser_name){user_name.set(newUser_name);}

    public StringProperty passProperty(){return pass;}
    public String getPass(){return pass.get();}
    public void setPass(String newPass){pass.set(newPass);}

    public StringProperty contactProperty(){return contact;}
    public String getContact(){return contact.get();}
    public void setContact(String newContact){contact.set(newContact);}

    public StringProperty emailProperty(){return email;}
    public String getEmail(){return email.get();}
    public void setEmail(String newEmail){email.set(newEmail);}

    public StringProperty genderProperty(){return gender;}
    public String getGender(){return gender.get();}
    public void setGender(String newGender){gender.set(newGender);}
}
