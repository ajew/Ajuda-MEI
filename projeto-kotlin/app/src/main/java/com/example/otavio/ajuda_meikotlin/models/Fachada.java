package com.example.otavio.ajuda_meikotlin.models;

public class Fachada {
    private static Fachada fachada;
    private Fachada(){

    }
    public Fachada getInstance(){
        if(fachada==null){
            fachada=new Fachada();
        }
        return this.fachada;
    }


}
