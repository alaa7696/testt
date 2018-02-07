package com.sqli;

public class Mister implements Personne {
    public String name;
    public String say;
    public String receptor;
    public String type;

    public Mister(String name) {
        this.name = name;
    }

    public String ask() {
        return say;
    }

    public String getName() {
        return name;
    }

    public void setSay(String say) {
        this.say=say;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor=receptor;
    }

    public String getSay() {
        return say;
    }

    public void setType(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
