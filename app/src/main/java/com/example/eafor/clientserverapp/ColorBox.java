package com.example.eafor.clientserverapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;

public class ColorBox extends View {

    Paint paint = new Paint();
    int color1;
    Point topLeftP;
    Point topRightP;
    Point bottomLeftP;
    Point bottomRightP;

    public ColorBox(Context context, int color,int topLeftX, int topLeftY, int topRightX, int topRightY, int bottomLeftX, int bottomLeftY, int bottomRightX, int bottomRightY) {
        super(context);
        color1 = color;
        setPoints(topLeftX, topLeftY,  topRightX, topRightY,  bottomLeftX, bottomLeftY,  bottomRightX, bottomRightY);
    }
    public void changeDrawingColor(int color) {
        color1 = color;
    }
    public void setPoints(int topLeftX, int topLeftY, int topRightX, int topRightY, int bottomLeftX, int bottomLeftY, int bottomRightX, int bottomRightY){
        topLeftP=null;
        topRightP=null;
        bottomLeftP=null;
        bottomRightP=null;
        topLeftP = new Point(topLeftX, topLeftY);
        topRightP = new Point(topRightX, topRightY);
        bottomLeftP = new Point(bottomLeftX, bottomLeftY);
        bottomRightP = new Point(bottomRightX, bottomRightY);
    }

    @Override
    public void onDraw(Canvas canvas) {

        //This draw a thin line around the border, with line width 1
//        paint.setColor(Color.BLACK);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(1f);
//        canvas.drawRect(5, 5, 65, 65, paint);


        paint.setColor(color1);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);

        if (color1 != 0)
        {
            //Draw Top Left Color
            Path path1 = new Path();
            path1.setFillType(Path.FillType.EVEN_ODD);
            path1.moveTo(topLeftP.x, topLeftP.y);
            path1.lineTo(topRightP.x, topRightP.y);
            path1.lineTo(bottomRightP.x, bottomRightP.y);
            path1.lineTo(bottomLeftP.x, bottomLeftP.y);
            path1.close();
            canvas.drawPath(path1, paint);

            //Draw Bottom Right Color
        } else {

            //canvas.drawRect(topLeft.x, topLeft.y, bottomRight.x, bottomRight.y, paint);
        }
    }
}