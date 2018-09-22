package com.example.eafor.clientserverapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
    public static int chosenColor=0;

    @BindView(R.id.o1_1)
    ImageView o11;
    @BindView(R.id.o1_2)
    ImageView o12;
    @BindView(R.id.o1_3)
    ImageView o13;
    @BindView(R.id.o1_4)
    ImageView o14;
    @BindView(R.id.o1_5)
    ImageView o15;
    @BindView(R.id.o1_6)
    ImageView o16;
    @BindView(R.id.o1_7)
    ImageView o17;
    @BindView(R.id.o1_8)
    ImageView o18;
    @BindView(R.id.o1_9)
    ImageView o19;
    @BindView(R.id.o1_10)
    ImageView o110;
    @BindView(R.id.o2_1)
    ImageView o21;
    @BindView(R.id.o2_2)
    ImageView o22;
    @BindView(R.id.o2_3)
    ImageView o23;
    @BindView(R.id.o2_4)
    ImageView o24;
    @BindView(R.id.o2_5)
    ImageView o25;
    @BindView(R.id.o2_6)
    ImageView o26;
    @BindView(R.id.o2_7)
    ImageView o27;
    @BindView(R.id.o2_8)
    ImageView o28;
    @BindView(R.id.o2_9)
    ImageView o29;
    @BindView(R.id.o2_10)
    ImageView o210;
    @BindView(R.id.o3_1)
    ImageView o31;
    @BindView(R.id.o3_2)
    ImageView o32;
    @BindView(R.id.o3_3)
    ImageView o33;
    @BindView(R.id.o3_4)
    ImageView o34;
    @BindView(R.id.o3_5)
    ImageView o35;
    @BindView(R.id.o3_6)
    ImageView o36;
    @BindView(R.id.o3_7)
    ImageView o37;
    @BindView(R.id.o3_8)
    ImageView o38;
    @BindView(R.id.o3_9)
    ImageView o39;
    @BindView(R.id.o3_10)
    ImageView o310;
    @BindView(R.id.o4_1)
    ImageView o41;
    @BindView(R.id.o4_2)
    ImageView o42;
    @BindView(R.id.o4_3)
    ImageView o43;
    @BindView(R.id.o4_4)
    ImageView o44;
    @BindView(R.id.o4_5)
    ImageView o45;
    @BindView(R.id.o4_6)
    ImageView o46;
    @BindView(R.id.o4_7)
    ImageView o47;
    @BindView(R.id.o4_8)
    ImageView o48;
    @BindView(R.id.o4_9)
    ImageView o49;
    @BindView(R.id.o4_10)
    ImageView o410;
    @BindView(R.id.o5_1)
    ImageView o51;
    @BindView(R.id.o5_2)
    ImageView o52;
    @BindView(R.id.o5_3)
    ImageView o53;
    @BindView(R.id.o5_4)
    ImageView o54;
    @BindView(R.id.o5_5)
    ImageView o55;
    @BindView(R.id.o5_6)
    ImageView o56;
    @BindView(R.id.o5_7)
    ImageView o57;
    @BindView(R.id.o5_8)
    ImageView o58;
    @BindView(R.id.o5_9)
    ImageView o59;
    @BindView(R.id.o5_10)
    ImageView o510;
    @BindView(R.id.o6_1)
    ImageView o61;
    @BindView(R.id.o6_2)
    ImageView o62;
    @BindView(R.id.o6_3)
    ImageView o63;
    @BindView(R.id.o6_4)
    ImageView o64;
    @BindView(R.id.o6_5)
    ImageView o65;
    @BindView(R.id.o6_6)
    ImageView o66;
    @BindView(R.id.o6_7)
    ImageView o67;
    @BindView(R.id.o6_8)
    ImageView o68;
    @BindView(R.id.o6_9)
    ImageView o69;
    @BindView(R.id.o6_10)
    ImageView o610;
    @BindView(R.id.o7_1)
    ImageView o71;
    @BindView(R.id.o7_2)
    ImageView o72;
    @BindView(R.id.o7_3)
    ImageView o73;
    @BindView(R.id.o7_4)
    ImageView o74;
    @BindView(R.id.o7_5)
    ImageView o75;
    @BindView(R.id.o7_6)
    ImageView o76;
    @BindView(R.id.o7_7)
    ImageView o77;
    @BindView(R.id.o7_8)
    ImageView o78;
    @BindView(R.id.o7_9)
    ImageView o79;
    @BindView(R.id.o7_10)
    ImageView o710;
    @BindView(R.id.o8_1)
    ImageView o81;
    @BindView(R.id.o8_2)
    ImageView o82;
    @BindView(R.id.o8_3)
    ImageView o83;
    @BindView(R.id.o8_4)
    ImageView o84;
    @BindView(R.id.o8_5)
    ImageView o85;
    @BindView(R.id.o8_6)
    ImageView o86;
    @BindView(R.id.o8_7)
    ImageView o87;
    @BindView(R.id.o8_8)
    ImageView o88;
    @BindView(R.id.o8_9)
    ImageView o89;
    @BindView(R.id.o8_10)
    ImageView o810;
    @BindView(R.id.o9_1)
    ImageView o91;
    @BindView(R.id.o9_2)
    ImageView o92;
    @BindView(R.id.o9_3)
    ImageView o93;
    @BindView(R.id.o9_4)
    ImageView o94;
    @BindView(R.id.o9_5)
    ImageView o95;
    @BindView(R.id.o9_6)
    ImageView o96;
    @BindView(R.id.o9_7)
    ImageView o97;
    @BindView(R.id.o9_8)
    ImageView o98;
    @BindView(R.id.o9_9)
    ImageView o99;
    @BindView(R.id.o9_10)
    ImageView o910;
    @BindView(R.id.o10_1)
    ImageView o101;
    @BindView(R.id.o10_2)
    ImageView o102;
    @BindView(R.id.o10_3)
    ImageView o103;
    @BindView(R.id.o10_4)
    ImageView o104;
    @BindView(R.id.o10_5)
    ImageView o105;
    @BindView(R.id.o10_6)
    ImageView o106;
    @BindView(R.id.o10_7)
    ImageView o107;
    @BindView(R.id.o10_8)
    ImageView o108;
    @BindView(R.id.o10_9)
    ImageView o109;
    @BindView(R.id.o10_10)
    ImageView o1010;
    @BindView(R.id.colorBlue)
    ImageView colorBlue;
    @BindView(R.id.colorYellow)
    ImageView colorYellow;
    @BindView(R.id.colorRed)
    ImageView colorRed;
    @BindView(R.id.colorGreen)
    ImageView colorGreen;
    @BindView(R.id.colorBrown)
    ImageView colorBrown;
    @BindView(R.id.colorCyan)
    ImageView colorCyan;
    @BindView(R.id.colorGray)
    ImageView colorGray;
    @BindView(R.id.colorOrange)
    ImageView colorOrange;
    @BindView(R.id.colorDarkPink)
    ImageView colorDarkPink;
    @BindView(R.id.colorVinous)
    ImageView colorVinous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.o1_1, R.id.o1_2, R.id.o1_3, R.id.o1_4, R.id.o1_5, R.id.o1_6, R.id.o1_7, R.id.o1_8, R.id.o1_9, R.id.o1_10, R.id.o2_1, R.id.o2_2, R.id.o2_3, R.id.o2_4,
            R.id.o2_5, R.id.o2_6, R.id.o2_7, R.id.o2_8, R.id.o2_9, R.id.o2_10, R.id.o3_1, R.id.o3_2, R.id.o3_3, R.id.o3_4, R.id.o3_5, R.id.o3_6, R.id.o3_7, R.id.o3_8,
            R.id.o3_9, R.id.o3_10, R.id.o4_1, R.id.o4_2, R.id.o4_3, R.id.o4_4, R.id.o4_5, R.id.o4_6, R.id.o4_7, R.id.o4_8, R.id.o4_9, R.id.o4_10, R.id.o5_1, R.id.o5_2,
            R.id.o5_3, R.id.o5_4, R.id.o5_5, R.id.o5_6, R.id.o5_7, R.id.o5_8, R.id.o5_9, R.id.o5_10, R.id.o6_1, R.id.o6_2, R.id.o6_3, R.id.o6_4, R.id.o6_5, R.id.o6_6,
            R.id.o6_7, R.id.o6_8, R.id.o6_9, R.id.o6_10, R.id.o7_1, R.id.o7_2, R.id.o7_3, R.id.o7_4, R.id.o7_5, R.id.o7_6, R.id.o7_7, R.id.o7_8, R.id.o7_9, R.id.o7_10,
            R.id.o8_1, R.id.o8_2, R.id.o8_3, R.id.o8_4, R.id.o8_5, R.id.o8_6, R.id.o8_7, R.id.o8_8, R.id.o8_9, R.id.o8_10, R.id.o9_1, R.id.o9_2, R.id.o9_3, R.id.o9_4,
            R.id.o9_5, R.id.o9_6, R.id.o9_7, R.id.o9_8, R.id.o9_9, R.id.o9_10, R.id.o10_1, R.id.o10_2, R.id.o10_3, R.id.o10_4, R.id.o10_5, R.id.o10_6, R.id.o10_7,
            R.id.o10_8, R.id.o10_9, R.id.o10_10})
    public void onViewClicked(View view) {
        colorIt(view);
    }

    public void colorIt(View view) {
        if(chosenColor!=0){
            view.setBackgroundColor(chosenColor);
        }else{
            Toast.makeText(this,"Сначала выберите цвет!", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick({R.id.colorBlue, R.id.colorYellow, R.id.colorRed, R.id.colorGreen, R.id.colorBrown, R.id.colorCyan, R.id.colorGray, R.id.colorOrange, R.id.colorDarkPink, R.id.colorVinous})
    public void palette(View view) {
        switch (view.getId()) {
            case R.id.colorBlue: chosenColor=getResources().getColor(R.color.colorBlue);
                break;
            case R.id.colorYellow: chosenColor=getResources().getColor(R.color.colorYellow);
                break;
            case R.id.colorRed: chosenColor=getResources().getColor(R.color.colorRed);
                break;
            case R.id.colorGreen: chosenColor=getResources().getColor(R.color.colorGreen);
                break;
            case R.id.colorBrown: chosenColor=getResources().getColor(R.color.colorBrown);
                break;
            case R.id.colorCyan: chosenColor=getResources().getColor(R.color.colorCyan);
                break;
            case R.id.colorGray: chosenColor=getResources().getColor(R.color.colorGray);
                break;
            case R.id.colorOrange: chosenColor=getResources().getColor(R.color.colorOrange);
                break;
            case R.id.colorDarkPink: chosenColor=getResources().getColor(R.color.colorDarkPink);
                break;
            case R.id.colorVinous: chosenColor=getResources().getColor(R.color.colorVinous);
                break;
        }
    }
}
