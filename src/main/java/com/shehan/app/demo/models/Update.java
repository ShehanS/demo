package com.shehan.app.demo.models;

import java.util.Date;

public class Update {
    private String version;
    private String date;
    private boolean approved;


    protected Update(){

    }

    public Update(String version, String date, boolean approved){
        this.version = version;
        this.date = date;
        this.approved = approved;
    }


    public String getVersion(){
        return version;
    }

    public String getDate(){
        return date;
    }

    public boolean isApproved(){
        return approved;
    }



}
