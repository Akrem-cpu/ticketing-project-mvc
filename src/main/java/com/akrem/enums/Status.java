package com.akrem.enums;

public enum Status {
    OPEN("open"), IN_PROGRESS("In Progress") , COMPLETE("completed");
    private String value;
    private Status(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }






}
