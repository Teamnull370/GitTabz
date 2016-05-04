/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamnull.thatgoodgood.gittabz;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 *
 * @author Zeyad Ayoub
 */

public class tReader implements Debug{
    private String _raws;
    private static Integer _iter = 0;
    private Integer _measureLength;
    private Integer _stringNum;
    private ArrayList<ArrayList<String>> _data= new ArrayList<>();
    private ArrayList<String> _dataMember;
    private ArrayList<Chord> chordList=new ArrayList<>();

    public tReader(){

    }

    public void read(InputStream is){

        try { //TODO need to open file
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            if(is!= null) {
                while ((line = bufferedReader.readLine()) != null) {
                    //stringBuffer.append(line);
                    stringBuffer.append(line + "\n");
                }
            }
            if(_parseDebug){
                System.out.println("Contents of file:");
                //Log.d(stringBuffer.toString(), "\n");
                System.out.println(stringBuffer.toString());
            }
            _raws=stringBuffer.toString();

        } catch (Exception e) {
            //Log.e("_raws","error");
            System.out.println(e);
        }finally{
            try { is.close(); } catch (Exception e) { }
        }

    }

    public String retRaw(){
        return _raws;
    }
    public void parseMLength(){

        if(_raws.charAt(_iter)!= '<'){
            if(_parseDebug){
                Log.d("","file error\n");
                //System.out.println("file error");
            }
            return;
        }
        _iter++;
        _measureLength=Character.getNumericValue(_raws.charAt(_iter));
        if(_measureLength==-1){
            if(_parseDebug){
                Log.d("", "measure error\n");
                //System.out.println("measure error");
            }
            return;
        }
        if(_parseDebug){
            Log.d(_measureLength.toString(),"\n");
            System.out.println(_measureLength);
        }
    }
    public void parse(){
        while(_raws.charAt(_iter)!='\n'){
            _iter++;
        }
        _iter++;
        if(_parseDebug){
            Log.d(Character.toString(_raws.charAt(_iter)), "\n");
            //System.out.println(_raws.charAt(_iter));
        }
        while(_iter!=_raws.length()){
            parseString();
            _iter++;

        }
        if(_dataDebug){
            Log.d(_data.toString(),"\n");
            Log.d(Integer.toString(_data.size()), "\n");
            //System.out.println(_data.toString());
            //System.out.println(_data.size());
        }


    }
    private void parseString(){
        if(Character.isDigit(_raws.charAt(_iter))){

            _stringNum=Character.getNumericValue(_raws.charAt(_iter));  //this gets the string info
            _dataMember= new ArrayList<>();
            _iter++;    // this iter++ skips the letter after the string number
            //System.out.println(_raws.charAt(_iter)); 
            while(_raws.charAt(_iter)!='|'){
                _iter++;

            }
            _iter++;
            while(_raws.charAt(_iter)!='\n'){

                parseMeasure();
                _iter++;
                if(_parseDebug){
                    //_dataMember.add("**********");
                }

            }

            try{
                _data.get(_stringNum-1).addAll(_dataMember);
            }
            catch(Exception e){
                _data.add(_dataMember);
            }

            if(_parseDebug){
                for(String _dataMember1 : _dataMember) {
                    Log.d(_dataMember1, "data member");
                   // System.out.println(_dataMember1);
                }

            }


        }

    }
    private void parseMeasure(){
        String temp;
        while(_raws.charAt(_iter)!='|'){
            if(_raws.charAt(_iter)!='['){ // blank area parser
                _dataMember.add(Character.toString(_raws.charAt(_iter)));
            }
            else{
                temp="";
                if(_raws.charAt(_iter)=='['){ // note parser
                    while(_raws.charAt(_iter)!=']'){
                        temp+=_raws.charAt(_iter);
                        _iter++;
                    }
                    temp+=_raws.charAt(_iter);
                    _dataMember.add(temp);
                }
            }
            _iter++;

        }
        if(_parseDebug)
            Log.d("Character at " + _iter +": "+ _raws.charAt(_iter),"\n");
            //System.out.println("Character at " + _iter +": "+ _raws.charAt(_iter));

    }

    public void parseData(){
        Integer iter=0;
        Character bt=' ';
        Integer r=0;
        Boolean nextNote=false;

        Integer max = dataLength();

        ArrayList<Integer> chordNote= new ArrayList<>();
        //_measureLength




        while(iter<max) {
            bt=' ';

            for (int i = 0; i < 6; i++) {
                r=-1;

                if (iter.compareTo(_data.get(i).size())<0){
                    String tempData = _data.get(i).get(iter);
                    if(!_data.get(i).get(iter+1).equals("-")){
                        nextNote=true;
                    }
                //*/
                    if(tempData.equals("~")){
                        return;
                    }
                    if (!tempData.equals("-")) {
                        r = Character.getNumericValue(tempData.charAt(1));

                        if (Character.isDigit(tempData.charAt(2))) {
                            r= (r*10)+ Character.getNumericValue(tempData.charAt(2));
                            if (bt == ' ') {
                                bt = tempData.charAt(3);
                            }
                        } else {
                            if (bt == ' ') {
                                bt = tempData.charAt(2);
                            }
                        }
                    }

                //*/
                }
                chordNote.add(r);
                //Log.d("chord check",r.toString());
            }
            chordNote.add(r);
            Chord strum = new Chord(chordNote,interBeat(bt));
            strum.makeNotes();
            strum.makePattern();
            chordList.add(strum);
            //Log.d("chord", chordNote.toString());
            chordNote=new ArrayList<>();

            /*
            if(nextNote == false){
                iter += interP(bt);
            }else{
                iter++;
            }
            */
            iter++;
            nextNote=false;
        }

    }
    private Integer interP(Character _beat){
        if (_beat == 'w') {
            return 8; //whole
        } else if (_beat == 'h') {
            return 4; //half
        } else if (_beat == 'q') {
            return 2; //quarter
        } else if (_beat == 'i') {
            return 1; //eighth
        }
        else if (_beat == '-')
            return 1;
        else return 1;

    }
    private Integer interBeat(Character _beat){
        if (_beat == 'w') {
            return 1; //whole
        } else if (_beat == 'h') {
            return 2; //half
        } else if (_beat == 'q') {
            return 3; //quarter
        } else if (_beat == 'i') {
            return 4; //eighth
        }
        else if (_beat == '-')
            return -1;
        else return -1;

    }
    private Integer dataLength(){

        ArrayList<Integer> a=new ArrayList<>();

        a.add(_data.get(0).size());
        a.add(_data.get(1).size());
        a.add(_data.get(2).size());
        a.add(_data.get(3).size());
        a.add(_data.get(4).size());
        a.add(_data.get(5).size());

        return Collections.max(a);

    }
    public ArrayList<Chord> chordList(){

        return chordList;
    }
}