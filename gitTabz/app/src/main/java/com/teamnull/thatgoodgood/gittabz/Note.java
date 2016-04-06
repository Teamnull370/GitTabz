package com.teamnull.thatgoodgood.gittabz;


import java.lang.Integer;
/**
 * Created by Zeyad Ayoub on 4/5/2016.
 */
public class Note{


    private Integer _strng =new Integer(0);
    private Integer _fret = new Integer(0);

    private Sound _snd = new Sound();

    public Note(){
        _strng=-1;
        _fret=-1;

    }

    public Note(Integer str, Integer frt){
        _strng=str;
        _fret=frt;
        _snd.setTone(_strng,_fret);
    }

    public void setStrng(Integer str ){ _strng= str; }
    public void setFret(Integer frt){ _fret = frt;}

    public Integer getStrng(){return _strng;}
    public Integer getFret(){ return _fret;}




};