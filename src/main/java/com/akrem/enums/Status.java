package com.akrem.enums;

import org.aspectj.weaver.ast.Var;

import java.util.List;

public enum Status {
    OPEN("Open"), IN_PROGRESS("In Progress") , COMPLETE("Completed");
    private String value;
    private Status(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }






}
