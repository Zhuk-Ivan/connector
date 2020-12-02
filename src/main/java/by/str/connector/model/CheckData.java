package by.str.connector.model;

import java.io.Serializable;

public class CheckData implements Serializable {



    private Integer studentId;
    private String phone;
    private Boolean success;

    public CheckData() {
    }

    public CheckData(Integer studentId, String phone, Boolean success) {
        this.studentId = studentId;
        this.phone = phone;
        this.success = success;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
