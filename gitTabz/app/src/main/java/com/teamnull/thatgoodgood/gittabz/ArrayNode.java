package com.teamnull.thatgoodgood.gittabz;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;

import com.teamnull.thatgoodgood.gittabz.MainActivity;

/**
 * Created by Danny on 4/21/2016.
 */
/*
public class ArrayNode implements Parcelable{
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(stringNumber);
        out.writeInt(fretNumber);
    }

    public static final Parcelable.Creator<ArrayNode> CREATOR
            = new Parcelable.Creator<ArrayNode>(){
        public ArrayNode createFromParcel(Parcel in){
            return new ArrayNode(in);
        }
        public ArrayNode[] newArray(int size){
            return new ArrayNode[size];
        }
    };
    private ArrayNode(Parcel in){
        stringNumber = in.readInt();
        fretNumber = in.readInt();
    }
}
*/