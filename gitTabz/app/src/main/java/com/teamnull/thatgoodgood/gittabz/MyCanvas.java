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
    private Path path3;
    private Path path4;
    private Path path5;
    private Path path6;
    private Path path7;
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
        paint2.setColor(Color.RED);
        paint2.setStrokeWidth(5);
        paint2.setStyle(Paint.Style.STROKE);

        path= new Path();
        path2= new Path();
        path3= new Path();
        path4= new Path();
        path5= new Path();
        path6= new Path();

        path7 = new Path();
    }

    @Override
    public void onSizeChanged (int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        X = 0;
        Y = height /8;

        path.moveTo(X, Y);

        Y= height/8 * 2;
        path2.moveTo(X,Y);

        Y= height/8 * 3;
        path3.moveTo(X,Y);

        Y= height/8 * 4;
        path4.moveTo(X,Y);

        Y= height/8 * 5;
        path5.moveTo(X,Y);

        Y= height/8 * 6;
        path6.moveTo(X,Y);

        X = width /2;
        Y= 10;
        path7.moveTo(X,Y);
    }



    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.save();
        Y=height /8;
        X=width;
        path.lineTo(X, Y);
        canvas.drawPath(path, paint1);

        Y=height/8* 2;
        path2.lineTo(X, Y);
        canvas.drawPath(path2, paint1);

        Y=height/8* 3;
        path3.lineTo(X, Y);
        canvas.drawPath(path3, paint1);

        Y=height/8* 4;
        path4.lineTo(X, Y);
        canvas.drawPath(path4, paint1);

        Y=height/8* 5;
        path5.lineTo(X, Y);
        canvas.drawPath(path5, paint1);

        Y=height/8* 6;
        path6.lineTo(X, Y);
        canvas.drawPath(path6, paint1);

        X= width /2;
        Y = height;
        canvas.drawPath(path7, paint1);
        //canvas.restore();

        //invalidate();
    }
}

