package com.xzh;

import java.util.List;

public class declareSub3Entity {

    private String year;

    private String subject;

    private String totleYS;

    private List<declareSub5Entity> declareSub5s;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTotleYS() {
        return totleYS;
    }

    public void setTotleYS(String totleYS) {
        this.totleYS = totleYS;
    }

    public List<declareSub5Entity> getDeclareSub5s() {
        return declareSub5s;
    }

    public void setDeclareSub5s(List<declareSub5Entity> declareSub5s) {
        this.declareSub5s = declareSub5s;
    }

    public declareSub3Entity() {
    }

    public declareSub3Entity(String year, String subject, String totleYS, List<declareSub5Entity> declareSub5s) {
        this.year = year;
        this.subject = subject;
        this.totleYS = totleYS;
        this.declareSub5s = declareSub5s;
    }
}
