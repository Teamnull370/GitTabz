package com.teamnull.thatgoodgood.gittabz;

import org.jfugue.pattern.Pattern;

/*
 * Created by Zeyad Ayoub on 4/5/2016.
 */
public class Note{
    //builds the sound

    private Integer _strng;// =new Integer(0);
    private Integer _fret;// = new Integer(0);
    private Integer _beat;
    public Sound _snd; //my sound class
    private Pattern _pat;

    public Note(){
        _strng=-1;
        _fret=-1;
        _beat=0;

    }

    public Note(Integer str, Integer frt, Integer bt){
        _strng=str;
        _fret=frt;
        _beat=bt;
        
        _snd=new Sound(_strng, _fret,_beat );
        _snd.addBeat();
        _snd.setTone();
        this.makeSound();
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
    public Pattern getPat(){
        return _pat;
    }

};