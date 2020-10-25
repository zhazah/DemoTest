package com.xzh;

public class declareSub5Entity {

    private String type;

    private String subject;

    private String twoSubject;

    private String totleYS;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTwoSubject() {
        return twoSubject;
    }

    public void setTwoSubject(String twoSubject) {
        this.twoSubject = twoSubject;
    }

    public String getTotleYS() {
        return totleYS;
    }

    public void setTotleYS(String totleYS) {
        this.totleYS = totleYS;
    }

    public declareSub5Entity() {
    }
    public declareSub5Entity(String type, String subject, String twoSubject, String totleYS) {
        this.type = type;
        this.subject = subject;
        this.twoSubject = twoSubject;
        this.totleYS = totleYS;
    }
}
