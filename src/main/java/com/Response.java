package com;



public class Response {
    private String recepient[];

    private int number;

    public String[] getRecepient() {
        return recepient;
    }

    public void setRecepient(String[] recepient) {
        this.recepient = recepient;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Response(String[] recepient) {
        this.recepient = recepient;
    }
}
