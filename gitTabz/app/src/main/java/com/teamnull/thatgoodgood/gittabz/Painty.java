package com.teamnull.thatgoodgood.gittabz;//package com.teamnull.thatgoodgood.gittabz;

import android.graphics.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.*;

/**
 * Created by Danny on 3/31/2016.
 */
public class Painty{
    Paint painty = new Paint();



    public Paint rectangle(android.graphics.Paint paint){
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        return paint;
    }
}
