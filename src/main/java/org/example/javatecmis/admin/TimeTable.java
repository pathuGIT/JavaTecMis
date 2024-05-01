package org.example.javatecmis.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimeTable {
    private final StringProperty tt_id;
    private final StringProperty tt_dep;
    private final StringProperty tt_url;

    public TimeTable(){
        tt_id = new SimpleStringProperty(this,"Id");
        tt_dep = new SimpleStringProperty(this,"Dep");
        tt_url = new SimpleStringProperty(this,"URL");
    }

    public StringProperty tt_idProperty(){return tt_id;}
    public String getTt_id(){return tt_id.get();}
    public void setTt_id(String newId){tt_id.set(newId);}

    public StringProperty tt_depProperty(){return tt_dep;}
    public String getTt_dep(){return tt_dep.get();}
    public void setTt_dep(String newId){tt_dep.set(newId);}

    public StringProperty tt_urlProperty(){return tt_url;}
    public String getTt_url(){return tt_url.get();}
    public void setTt_url(String newId){tt_url.set(newId);}
}
