package com.teamnull.thatgoodgood.gittabz;

import android.graphics.Canvas;
import android.os.Parcelable;

import com.teamnull.thatgoodgood.gittabz.MainActivity;

/**
 * Created by Danny on 4/21/2016.
 */
public class ArrayNode{
    public Integer stringNumber;
    public Integer fretNumber;

    public ArrayNode(Integer strin, Integer fret)
    {
        stringNumber = strin;
        fretNumber = fret;
    }

    public void setString(Integer stringNumber)
    {
        this.stringNumber = stringNumber;
    }
    public Integer getString()
    {
        return stringNumber;
    }

    public void setFret(Integer fretNumber)
    {
        this.fretNumber = fretNumber;
    }

    public Integer getFret()
    {
        return fretNumber;
    }
}
