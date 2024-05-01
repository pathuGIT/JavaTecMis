package org.example.javatecmis.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoticeTable {
    private final StringProperty no_id;
    private final StringProperty no_topic;
    private final StringProperty no_notice;
    private final StringProperty no_date;

    public NoticeTable(){
        no_id = new SimpleStringProperty(this,"Id");
        no_topic = new SimpleStringProperty(this,"Topic");
        no_notice = new SimpleStringProperty(this,"Notice");
        no_date = new SimpleStringProperty(this,"Date");
    }

    public StringProperty no_idProperty(){return no_id;}
    public String getNo_id(){return no_id.get();}
    public void setNo_id(String newId){no_id.set(newId);}

    public StringProperty no_topicProperty(){return no_topic;}
    public String getNo_topic(){return no_topic.get();}
    public void setNo_topic(String newTopic){no_topic.set(newTopic);}

    public StringProperty no_noticeProperty(){return no_notice;}
    public String getNo_notice(){return no_notice.get();}
    public void setNo_notice(String newNotice){no_notice.set(newNotice);}

    public StringProperty no_dateProperty(){return no_date;}
    public String getNo_date(){return no_date.get();}
    public void setNo_date(String newDate){no_date.set(newDate);}
}

