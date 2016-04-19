/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamnull.thatgoodgood.gittabz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
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

    
    public tReader(){
        
    }
     
    public void read(String tabz){

        try {
            File file = new File(tabz);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fileReader.close();
            if(_parseDebug){
                //System.out.println("Contents of file:");
                System.out.println(stringBuffer.toString());
            }
            _raws=stringBuffer.toString();
        } catch (Exception e) {

        }
    }

    public String retRaw(){
        return _raws;
    }
    public void parseMLength(){
        if(_raws.charAt(_iter)!= '<'){
            if(_parseDebug){
                System.out.println("file error");
            }
            return;
        }
        _iter++;
        _measureLength=Character.getNumericValue(_raws.charAt(_iter));
        if(_measureLength==-1){
            if(_parseDebug){
                System.out.println("measure error");
            }
            return;
        }
        if(_parseDebug){
            System.out.println(_measureLength);
        }
    }
    public void parse(){
        while(_raws.charAt(_iter)!='\n'){
            _iter++;
        }
        _iter++;
        if(_parseDebug){
            System.out.println(_raws.charAt(_iter));
        }
        while(_iter!=_raws.length()){
            parseString();
            _iter++;
            
        }
        if(_dataDebug){
            System.out.println(_data.toString());
            System.out.println(_data.size());
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
                    System.out.println(_dataMember1);
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
            System.out.println("Character at " + _iter +": "+ _raws.charAt(_iter));

    }



}