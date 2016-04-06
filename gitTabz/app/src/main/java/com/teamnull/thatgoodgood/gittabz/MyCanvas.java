package com.teamnull.thatgoodgood.gittabz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * Created by Jonathon on 3/31/2016.
 */
public class MyCanvas extends View {

    private static Paint paint1;
    private static Paint paint2;
    private float X, Y;
    private Path path;
    private Path path2;
    private Context context;
    DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    int width = metrics.widthPixels;
    int height = metrics.heightPixels;



    public MyCanvas(Context context) {
        super(context);

        this.context =context;

        paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setStrokeWidth(5);
        //paint1.setAntiAlias(true);
        //paint1.setStrokeCap(Paint.Cap.SQUARE);
        //paint1.setStrokeJoin(Paint.Join.BEVEL);
        paint1.setStyle(Paint.Style.STROKE);
        //paint1.setShadowLayer(7, 0, 0, Color.RED);

        paint2 = new Paint();
        paint2.setColor(Color.argb(0xff, 0x99, 0x00, 0x00));
        paint2.setStrokeWidth(5);
        paint2.setAntiAlias(true);
        //paint2.setStrokeCap(Paint.Cap.ROUND);
        //paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setStyle(Paint.Style.STROKE);
        //paint2.setShadowLayer(7, 0, 0, Color.RED);


        path= new Path();
        path2= new Path();

    }

    @Override
    public void onSizeChanged (int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        X = 0;
        Y = height /8;


        path.moveTo(X, Y);

        Y= height/8 * 2;
        path2.moveTo(X,Y);

    }



    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.save();
        Y=height /8;
        X=width;


            //paint1.setStrokeWidth(5);
           // paint1.setColor(Color.BLUE);
            //paint1.setShadowLayer(12, 0, 0, Color.RED);


            paint2.setStrokeWidth(5);
            paint2.setColor(Color.BLUE);
            //paint2.setShadowLayer(12, 0, 0, Color.RED);




        path.lineTo(X, Y);

        canvas.drawPath(path, paint1);

        Y=height/8* 2;
        path2.lineTo(X, Y);
        canvas.drawPath(path2, paint2);

        //canvas.restore();

        //invalidate();
    }
}

