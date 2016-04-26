package com.teamnull.thatgoodgood.gittabz;


import android.util.Log;

import java.util.ArrayList;

/*
 * Created by Zeyad Ayoub on 4/5/2016.
 */

public class Sound implements Debug{
    //all the methods needed to make the sound
    private String _tone = "", _finalTone="";
    private Integer _string, _fret , _ibeat;
    private String _pat;
    private Character _beat='i'; //default for just in case.


    public Sound(Integer rst){
        if(rst == 1){
            _tone="Rw";
        }else if(rst == 2){
            _tone="Rh";
        }else if(rst == 3){
            _tone="Rq";
        }else if(rst == 4){
            _tone="Ri";
        }else if(rst == 5){
            _tone="Rs";
        }else if(rst == 6){
            _tone="Rt";
        }else if(rst == 7){
            _tone="Rx";
        }else if(rst == 8){
            _tone="Ro";
        }
    }
    public Sound (){
        _tone="";
    }
    public Sound(Integer str, Integer frt,Integer bt){
        _string = str;
        _fret = frt;
        _ibeat=bt;

        //addBeat(bt);
        //setTone(_string,_fret);
    }
    public void setTone(String rawTab){
        _tone= rawTab;
    }
    public void setTone(){

        if(_string<=-1||_fret <=-1){
            _tone="";
            return;
        }
        if(!_tone.contentEquals("")){
            return;
        }

        int rso = 7-_string;
        int stringStart;

        //String[] temp={"E","F","F#","G","G#","A","A#","B","C","C#","D","D#"};
        String[] temp={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
        ArrayList<String> noteKey= new ArrayList<>();
        for(int i=0; i < temp.length ;i++  ){
            noteKey.add(i,temp[i]);
        }

        switch(rso){  // is the stringStart offset code
            case 1:{
                stringStart=4;
                break;
            }
            case 2:{
                stringStart=9;
                break;
            }
            case 3:{
                stringStart=14;
                break;
            }
            case 4:{
                stringStart=19;
                break;
            }case 5:{
                stringStart=23;
                break;
            }case 6:{
                stringStart=28;
                break;
            }
            default:{
                stringStart=-1;
                _tone="";
                //break;
                return;
            }
        }
        if(_SoundDebug){
            //System.out.println("string Start: "+ stringStart);
        }
        int shifted=  _fret+ stringStart;

        int noteName = (shifted%12);
        Integer octave = ((int)(shifted/12)) +2;
        String sig = noteKey.get(noteName);
        if(_SoundDebug){
            //System.out.println("Sig: " + sig);
            //System.out.println("Octave: " + octave);
        }
        sig=sig.concat(octave.toString());
        _tone =_tone.concat(sig);

        if(_SoundDebug){

            //System.out.println("tone1: " + _tone);
        }


    }
    public String getTone(){
        return _tone;
    }
    public String makePat(){
        if(_SoundDebug){
            Log.d(_finalTone,"Final Tone\n");
            //System.out.println("FinalTone: " + _finalTone+"\n");
        }

        return _pat=new String(_finalTone);
    }
    public String getPat(){
        return _pat;
    }
    public void makeBeat(){
        if(_SoundDebug){
            Log.d(_tone," tone2\n");
            //System.out.println("tone2: " + _tone);
        }

        _finalTone=_finalTone.concat(_tone).concat(_beat.toString());
        if(_SoundDebug){
            Log.d(_finalTone,"\n");
            //System.out.println(_finalTone);
        }
    }
    public Character getBeat(){
        return _beat;
    }
    public Integer getBeat(int i){

        if (_beat == 'w') {
            return 1; //whole
        } else if (_beat == 'h') {
            return 2; //half
        } else if (_beat == 'q') {
            return 3; //quarter
        } else if (_beat == 'i') {
            return 4; //eighth
        } else if (_beat == 's') {
            return 5; //sixteenth
        } else if (_beat == 't') {
            return 6;
        } else if (_beat == 'x') {
            return 7;
        } else if (_beat == 'o') {
            return 8;
        } else return -1;
    }
    public void addBeat() {

        if (_ibeat == 1) {
            _beat = 'w'; //whole
        } else if (_ibeat == 2) {
            _beat = 'h'; //half
        } else if (_ibeat == 3) {
            _beat = 'q'; //quarter
        } else if (_ibeat == 4) {
            _beat = 'i'; //eighth
        } else if (_ibeat == 5) {
            _beat = 's'; //sixteenth
        } else if (_ibeat == 6) {
            _beat = 't';
        } else if (_ibeat == 7) {
            _beat = 'x';
        } else if (_ibeat == 8) {
            _beat = 'o';
        }
        if(_SoundDebug){
            Log.d(_beat.toString(),"beat\n");
            //System.out.println("beat: "+ _beat);
        }
        //makeBeat();

    } public void addBeat(Character bt) {

        _beat=bt;

        makeBeat();

    }
}