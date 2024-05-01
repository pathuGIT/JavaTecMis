package org.example.javatecmis.lecturer;

public class leMedical {
    private String std_id;
    private String crs_id;
    private String date;
    private String status;

    public leMedical(String std_id, String crs_id, String date, String status) {
        this.std_id = std_id;
        this.crs_id = crs_id;
        this.date = date;
        this.status = status;
    }

    public String getStd_id() {
        return std_id;
    }

    public String getCrs_id() {
        return crs_id;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
