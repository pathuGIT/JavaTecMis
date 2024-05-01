package org.example.javatecmis.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CouseTable {
    private final StringProperty co_id;
    private final StringProperty co_name;
    private final StringProperty co_type;
    private final StringProperty co_cedit;
    private final StringProperty co_depID;
    private final StringProperty co_dep;
    private final StringProperty co_lecID;
    private final StringProperty co_lec_NAME;

    CouseTable(){
        co_id = new SimpleStringProperty(this,"Id");
        co_name = new SimpleStringProperty(this,"Name");
        co_type = new SimpleStringProperty(this,"Type");
        co_cedit = new SimpleStringProperty(this,"Credit");
        co_depID = new SimpleStringProperty(this,"Dep_id");
        co_dep = new SimpleStringProperty(this,"Dep");
        co_lecID = new SimpleStringProperty(this,"LecID");
        co_lec_NAME = new SimpleStringProperty(this,"Lec_NAME");
    }

    public StringProperty co_idProperty(){return co_id;}
    public String getCo_id(){return co_id.get();}
    public void setCo_id(String newId){co_id.set(newId);}

    public StringProperty co_nameProperty(){return co_name;}
    public String getCo_name(){return co_name.get();}
    public void setCo_name(String newName){co_name.set(newName);}

    public StringProperty co_typeProperty(){return co_type;}
    public String getCo_type(){return co_type.get();}
    public void setCo_type(String newType){co_type.set(newType);}

    public StringProperty co_ceditProperty(){return co_cedit;}
    public String getCo_cedit(){return co_cedit.get();}
    public void setCo_cedit(String newCredit){co_cedit.set(newCredit);}

    public StringProperty co_depIDProperty(){return co_depID;}
    public String getCo_depID(){return co_depID.get();}
    public void setCo_depID(String newDep_id){co_depID.set(newDep_id);}

    public StringProperty co_depProperty(){return co_dep;}
    public String getCo_dep(){return co_dep.get();}
    public void setCo_dep(String newDep){co_dep.set(newDep);}

    public StringProperty co_lecIDProperty(){return co_lecID;}
    public String getCo_lecID(){return co_lecID.get();}
    public void setCo_lecID(String newLecID){co_lecID.set(newLecID);}

    public StringProperty co_lec_NAMEProperty(){return co_lec_NAME;}
    public String getCo_lec_NAME(){return co_lec_NAME.get();}
    public void setCo_lec_NAME(String newLec_NAME){co_lec_NAME.set(newLec_NAME);}
}
