package com.example.eafor.clientserverapp;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_YELLOW = 2;
    public static final int COLOR_RED = 3;
    public static final int COLOR_GREEN = 4;
    public static final int COLOR_BROWN = 5;
    public static final int COLOR_CYAN = 6;
    public static final int COLOR_GRAY = 7;
    public static final int COLOR_ORANGE = 8;
    public static final int COLOR_DARKPINK = 9;
    public static final int COLOR_VINOUS = 10;
    public static int chosenColor = Color.RED;
    public float touch_x_coordinate;
    public float touch_y_coordinate;
    ColorBox box;
    int[][] arrayBox=new int[10][10];


    @BindView(R.id.colorBlue) ImageView colorBlue;
    @BindView(R.id.colorYellow) ImageView colorYellow;
    @BindView(R.id.colorRed) ImageView colorRed;
    @BindView(R.id.colorGreen) ImageView colorGreen;
    @BindView(R.id.colorBrown) ImageView colorBrown;
    @BindView(R.id.colorCyan) ImageView colorCyan;
    @BindView(R.id.colorGray) ImageView colorGray;
    @BindView(R.id.colorOrange) ImageView colorOrange;
    @BindView(R.id.colorDarkPink) ImageView colorDarkPink;
    @BindView(R.id.colorVinous) ImageView colorVinous;
    @BindView(R.id.canvas) DrawView drawView;
    @BindView(R.id.textView)TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initUI() {
        ButterKnife.bind(this);
//        touch_x_coordinate=frameLayout.getWidth()/2;
//        touch_y_coordinate=frameLayout.getHeight()/2;
          drawView.setOnTouchListener((v, event) -> {
            touch_x_coordinate=event.getX();
            touch_y_coordinate=event.getY();
            textView.setText("X: "+touch_x_coordinate+"| Y: "+touch_y_coordinate);
            drawView.swapColor(chosenColor);
            return false;
        });
    }

    public void fillField(int[][] array){
        int width=array.length;
        int heith=array.length;
    }






    @OnClick({R.id.colorBlue, R.id.colorYellow, R.id.colorRed, R.id.colorGreen, R.id.colorBrown, R.id.colorCyan, R.id.colorGray, R.id.colorOrange, R.id.colorDarkPink, R.id.colorVinous})
    public void palette(View view) {
        switch (view.getId()) {
            case R.id.colorBlue:
                chosenColor = getResources().getColor(R.color.colorBlue);
                break;
            case R.id.colorYellow:
                chosenColor = getResources().getColor(R.color.colorYellow);
                break;
            case R.id.colorRed:
                chosenColor = getResources().getColor(R.color.colorRed);
                break;
            case R.id.colorGreen:
                chosenColor = getResources().getColor(R.color.colorGreen);
                break;
            case R.id.colorBrown:
                chosenColor = getResources().getColor(R.color.colorBrown);
                break;
            case R.id.colorCyan:
                chosenColor = getResources().getColor(R.color.colorCyan);
                break;
            case R.id.colorGray:
                chosenColor = getResources().getColor(R.color.colorGray);
                break;
            case R.id.colorOrange:
                chosenColor = getResources().getColor(R.color.colorOrange);
                break;
            case R.id.colorDarkPink:
                chosenColor = getResources().getColor(R.color.colorDarkPink);
                break;
            case R.id.colorVinous:
                chosenColor = getResources().getColor(R.color.colorVinous);
                break;
        }
    }
    public void performRedraw(){

    }

}
//        box =new ColorBox(getBaseContext(), chosenColor, touch_x_coordinate, touch_y_coordinate,  touch_x_coordinate+50,  touch_y_coordinate,  touch_x_coordinate,  touch_y_coordinate+50,  touch_x_coordinate+50,  touch_x_coordinate+50);
//        frameLayout.addView(box);
//        ColorBox2 colorBox2=new ColorBox2(this);
//        colorBox2.onDraw(new Canvas());


//        frameLayout.setOnTouchListener((v, event) -> {
//            touch_x_coordinate=(int)event.getX();
//            touch_y_coordinate=(int)event.getY();
//            box =new ColorBox(this, chosenColor, touch_x_coordinate, touch_y_coordinate,  touch_x_coordinate+50,  touch_y_coordinate,  touch_x_coordinate,  touch_y_coordinate+50,  touch_x_coordinate+50,  touch_x_coordinate+50);
//            Canvas canvas=new Canvas();
//            box.draw(canvas);
//            return true;
//        });
