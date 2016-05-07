package com.teamnull.thatgoodgood.gittabz;


/*
 * Created by Zeyad Ayoub on 4/5/2016.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable{
    //builds the sound

    private Integer _strng;// =new Integer(0);
    private Integer _fret;// = new Integer(0);
    private Integer _beat;
    public Sound _snd; //my sound class
    private String _pat;

    public Note(){
        _strng=-1;
        _fret=-1;
        _beat=0;

    }

    public Note(Integer str, Integer frt, Integer bt){
        _strng=str;
        if(frt==-9){
            _fret=-1;
        }else
            _fret=frt;
        _beat=bt;

        _snd=new Sound(_strng, _fret,_beat );
        _snd.addBeat();
        _snd.setTone();
       // this.makeSound();
    }
    public Note(Integer str, Integer frt){   // use with caution
        _strng=str;
        _fret=frt;
        _snd=new Sound(_strng, _fret,4);
    }

    public void setStrng(Integer str ){ _strng= str; }
    public void setFret(Integer frt){ _fret = frt;}
    public void setSound(String rawTab){ _snd.setTone(rawTab);}

    public Integer getStrng(){return _strng;}
    public Integer getFret(){ return _fret;}

    public void setBeat(Integer bt){
        _snd.addBeat();
    }
    public Integer getBeat(){return _beat; }

    public void makeSound(){

        _snd.makeBeat();
        _pat=_snd.makePat();
    }
    public String getPat(){
        return _pat;
    }



    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {


        out.writeInt(_strng);
        out.writeInt(_fret);
        out.writeInt(_beat);
        out.writeString(_pat);

    }

    public static final Parcelable.Creator<Note> CREATOR
            = new Parcelable.Creator<Note>(){
        public Note createFromParcel(Parcel in){
            return new Note(in);
        }
        public Note[] newArray(int size){
            return new Note[size];
        }
    };
    private Note(Parcel in){

        _strng = in.readInt();
        _fret =  in.readInt();
        _beat = in.readInt();
        _pat = in.readString();
    }






};