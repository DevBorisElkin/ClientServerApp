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
    int[][]array=new int[10][10];
    public final int COLOR_BLUE =getResources().getColor(R.color.colorBlue);
    public final int COLOR_YELLOW  =getResources().getColor(R.color.colorYellow);
    public final int COLOR_RED  =getResources().getColor(R.color.colorRed);
    public final int COLOR_GREEN  =getResources().getColor(R.color.colorGreen);
    public final int COLOR_BROWN  =getResources().getColor(R.color.colorBrown);
    public final int COLOR_CYAN  =getResources().getColor(R.color.colorCyan);
    public final int COLOR_GRAY  =getResources().getColor(R.color.colorGray);
    public final int COLOR_ORANGE  =getResources().getColor(R.color.colorOrange);
    public final int COLOR_DARKPINK  =getResources().getColor(R.color.colorDarkPink);
    public final int COLOR_VINOUS  =getResources().getColor(R.color.colorVinous);

    private int mSquareColor;
    private int mSquareSize=50;


    public DrawView(Context context) {
        super(context);
        //init(null);
    }
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //init(attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init(attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        //init(attrs);
    }


//    private void init(@Nullable AttributeSet set){
//        mRectSquare=new Rect(40, 33, 130, 120);
//        mPaintSquare=new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaintSquare.setColor(Color.GREEN);
//    }
//
//    public void swapColor(int color){
//        mPaintSquare.setColor(color);
//        postInvalidate();
//    }




    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.backgroundColor));
        //fill();
        int width=canvas.getWidth();
        int height=canvas.getHeight();
        int squareSize=width/10;
//        mRectSquare.left = 50;
//        mRectSquare.top = 50;
//        mRectSquare.right = mRectSquare.left + mSquareSize;
//        mRectSquare.bottom = mRectSquare.top + mSquareSize;
//
//        canvas.drawRect(mRectSquare, mPaintSquare);

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(checkArrayItemColor(i,j)){
                    performPaint(canvas, i,j,squareSize);
                }
//                if(checkArrayItemBlue(i,j)){
//                    performPaint(canvas, i, j, squareSize);
//                }
//                if(checkArrayItemRed(i,j)){
//                    performPaint(canvas, i, j, squareSize);
//                }

            }
        }
    }
    public void performPaint(Canvas canvas, int i, int j, int squareSize){
        int X_TOP=j*squareSize;
        int Y_TOP=i*squareSize;
        int X_BOT=j*squareSize+squareSize;
        int Y_BOT=i*squareSize+squareSize;
        canvas.drawRect(new Rect(X_TOP, Y_TOP, X_BOT, Y_BOT),mPaintSquare);
    }
    public boolean checkArrayItemBlue(int first, int second){
        mPaintSquare.setColor(COLOR_BLUE);
        if (array[first][second]==COLOR_BLUE){
            return true;
        }
        return false;
    }
    public boolean checkArrayItemRed(int first, int second){
        mPaintSquare.setColor(COLOR_RED);
        if (array[first][second]==COLOR_RED){
            return true;
        }
        return false;
    }

    public boolean checkArrayItemColor(int first, int second){
        if (array[first][second]==COLOR_BLUE){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }else if(array[first][second]==COLOR_YELLOW){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }else if(array[first][second]==COLOR_RED){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }
        else if(array[first][second]==COLOR_GREEN){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }
        else if(array[first][second]==COLOR_BROWN){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }
        else if(array[first][second]==COLOR_CYAN){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }
        else if(array[first][second]==COLOR_GRAY){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }
        else if(array[first][second]==COLOR_ORANGE){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }else if(array[first][second]==COLOR_DARKPINK){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }
        else if(array[first][second]==COLOR_VINOUS){
            mPaintSquare.setColor(array[first][second]);
            return true;
        }else{
            return false;
        }

    }
    public void fill(int i, int j, int color){
        array[i][j]=color;
        postInvalidate();
    }
}