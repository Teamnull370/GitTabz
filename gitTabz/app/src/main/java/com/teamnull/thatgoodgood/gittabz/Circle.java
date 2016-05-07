package com.teamnull.thatgoodgood.gittabz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

/**
 * Created by Danny on 5/3/2016.
 */
class Circle{
    public float ln;
    public float ex;
    public int fr;
    public int tim;
    private Path cir;
    private static final Float space_factor = new Float(2);//space between notes larger means less space
    private static final Float speedMod = new Float(2);//

    public Circle( float x, int line, int fret, Integer timmy){
        ex = x;
        ln = line;
        fr = fret;
        tim = timmy;
    }
    public void draw(Canvas canvas, Paint p, Paint w, Paint num, int current_time, int offset){
        canvas.drawCircle(ex-(current_time/speedMod-tim)/space_factor + offset, ln, 25, p);
//        //White circle
        canvas.drawCircle(ex - (current_time / speedMod - tim) / space_factor + offset, ln, 24, w);
//        //Number
        canvas.drawText(String.valueOf(fr), ex - (current_time/speedMod - tim) / space_factor + offset, ln + 10, num);

        if(ex-(current_time/speedMod-tim)/space_factor + offset < canvas.getWidth()/8 -5 &&
                ex-(current_time/speedMod-tim)/space_factor + offset > 100) {
            Float asdf =(Float)(ex-(current_time/speedMod-tim)/space_factor);
            Log.d(asdf.toString(), "HIT");
        }
    }
    public void setX(float ex) {
        this.ex = ex;
    }

    public float getX() {
        return ex;
    }

    public Float getPosition(int current_time) {
        return (Float)ex - (current_time/3-tim)/space_factor;
    }

    public void setLn(int ln) {
        this.ln = ln;
    }

    public float getLn() {
        return ln;
    }

    public void setFret(int fr) {
        this.fr = fr;
    }

    public float getFret() {
        return fr;
    }

    public void setTime(Integer tim) {
        this.tim = tim;
    }

    public Integer getTime() {
        return tim;
    }
}


