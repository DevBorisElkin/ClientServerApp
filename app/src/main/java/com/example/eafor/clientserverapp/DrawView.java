package com.example.eafor.clientserverapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {

    private Rect mRectSquare;
    private Paint mPaintSquare;

    private int mSquareColor;
    private int mSquareSize=50;


    public DrawView(Context context) {
        super(context);

        init(null);
    }
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet set){
        mRectSquare=new Rect(40, 33, 130, 120);
        mPaintSquare=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setColor(Color.GREEN);
    }

    public void swapColor(int color){
        mPaintSquare.setColor(color);
        postInvalidate();
    }



    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.backgroundColor));
        mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;

        canvas.drawRect(mRectSquare, mPaintSquare);
    }


}