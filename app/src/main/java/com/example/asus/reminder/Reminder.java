package com.example.asus.reminder;

import java.io.Serializable;

/**
 * Created by asus on 01-May-18.
 */
 class Reminder implements Serializable {
    private int mId;
    private  String text;
    private  int imp;

    public  Reminder(String a,int b, int id){
        text=a;
        imp=b;
        mId=id;
    }
    public  String getText(){return text;}
    public int  getimp(){return  imp;}
    public void set_text(String t){text=t;}
    public void setimp(int  t){imp=t;}
    public int getId() {return mId;}
    public void setId(int id) {mId = id;}


}