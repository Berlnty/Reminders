package com.example.asus.reminder;

import java.io.Serializable;

/**
 * Created by asus on 01-May-18.
 */
 class Reminder implements Serializable {

    String text;
    boolean imp;

    public  Reminder(String a,boolean b){
        text=a;
        imp=b;

    }
    public  String getText(){return text;}
    public boolean  getimp(){return  imp;}
    public void set_text(String t){text=t;}
    public void setimp(boolean t){imp=t;}


}