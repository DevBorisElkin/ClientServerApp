package com.example.eafor.clientserverapp;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;

public class ColorBox2 extends View {
    Paint paint = new Paint();
    int color1;
    int color2;


    public ColorBox2(Context context) {
        super(context);


            color1 = Color.RED;
            color2 = Color.BLUE;

    }

    @Override
    public void onDraw(Canvas canvas) {

        Point topLeft = new Point(7, 7);
        Point topRight = new Point(7, 62);
        Point bottomLeft = new Point(62, 7);
        Point bottomRight = new Point(62, 62);

        //This draw a thin line around the border, with line width 1
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1f);
        canvas.drawRect(5, 5, 65, 65, paint);


        paint.setColor(color1);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);

        if(color2 != 0) //Two Colors
        {
            //Draw Top Left Color
            Path path1 = new Path();
            path1.setFillType(Path.FillType.EVEN_ODD);
            path1.moveTo(topLeft.x, topLeft.x);
            path1.lineTo(topRight.x, topRight.y);
            path1.lineTo(bottomLeft.x, bottomLeft.y);
            path1.lineTo(topLeft.x, topLeft.y);
            path1.close();
            canvas.drawPath(path1, paint);

            //Draw Bottom Right Color
            paint.setColor(color2);
            Path path2 = new Path();
            path2.setFillType(Path.FillType.EVEN_ODD);
            path2.moveTo(topRight.x, topRight.y);
            path2.lineTo(bottomLeft.x, bottomLeft.y);
            path2.lineTo(bottomRight.x, bottomRight.y);
            path2.lineTo(topRight.x, topRight.y);
            path2.close();
            canvas.drawPath(path2, paint);
        }
        else {

            canvas.drawRect(topLeft.x, topLeft.y, bottomRight.x, bottomRight.y, paint);
        }
    }
}