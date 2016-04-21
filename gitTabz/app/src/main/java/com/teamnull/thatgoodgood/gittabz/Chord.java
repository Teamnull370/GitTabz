package com.teamnull.thatgoodgood.gittabz;
import org.jfugue.pattern.NotesProducer;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import java.util.ArrayList;



/*
 * Created by Zeyad Ayoub on 4/8/2016.
 */

public class Chord implements Debug {


    public ArrayList<Note> strings=new ArrayList<>();

    Pattern chord = new Pattern("E");

/*
    Player pl = new Player();
    public void setPl(Player pl) {
        pl.play(chord);
        this.pl = pl;
    }

       public Player getPl() {
        return pl;
    }
*/

    public Chord(){

        for(int i=0; i<6; i++){
            strings.add(i,new Note());
        }
        NotesProducer producer;
        chord = new Pattern("");
    }

    public Chord(Integer frt1,Integer frt2,Integer frt3, Integer frt4,Integer frt5,Integer frt6,Integer bt){
        strings.add(0,new Note(0,0,0));
        strings.add(1, new Note(1,frt1,bt));
        strings.add(2, new Note(2,frt2,bt));
        strings.add(3, new Note(3,frt3,bt));
        strings.add(4, new Note(4,frt4,bt));
        strings.add(5, new Note(5,frt5,bt));
        strings.add(6, new Note(6,frt6,bt));


    }
    public Chord(ArrayList<Integer> frt,Integer bt){
        strings.add(new Note(0,frt.get(0),bt));
        for(int i=6; i>0; i--){
            strings.add(new Note(i,frt.get(i),bt));
        }
    }
    public void setNote(Integer num, Integer frt) {
        // needs num for the string and frt for the fret of that string.

        strings.set(num, new Note(num, frt));
    }
    public void makeNotes(){
        for(int i =0; i<6;i++){
            strings.get(i).makeSound();
        }
    }
    public void makePattern(){

        String temp="";
        String tempy;
        for (int i=1;i<7;i++) {
            
            
            //tempy=strings.get(i).getPat()
            
//            if(_SoundDebug){
//                System.out.println(tempy);
//            }
//            if(tempy !="") {
//               if(tempy.length()!=1){
//
//               if(temp!=""){
//                    if (i != 6 ) {
//                        temp = temp.concat("+");
//                      }
//               }
//
//                    temp = temp.concat(tempy);
//
//                }
//            }
        }
        
        chord.add(temp);
        chord.setInstrument(25);
    }
    public Pattern getChord(){
        return chord;
    }

    public void strum(){
        Player player;
        player = new Player();
        player.play(chord);
        
    }

}