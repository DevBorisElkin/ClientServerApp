package com.example.eafor.clientserverapp.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eafor.clientserverapp.draw_view.DrawView;
import com.example.eafor.clientserverapp.MainActivity;
import com.example.eafor.clientserverapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOffline extends android.support.v4.app.Fragment {

    public static int chosenColor;
    public static final int FIELD_SIZE = MainActivity.FIELD_SIZE;
    public float touchX;
    public float touchY;
    int[][] arrayBox = new int[FIELD_SIZE][FIELD_SIZE];


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
    @BindView(R.id.colorWhite)
    ImageView colorDarkPink;
    @BindView(R.id.colorVinous)
    ImageView colorVinous;
    @BindView(R.id.canvas)
    DrawView drawView;
    @BindView(R.id.textView)
    TextView textView;
    Unbinder unbinder;

    List<ImageView>listOfImages;


    public FragmentOffline() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ButterKnife.bind(getActivity());
        View view = inflater.inflate(R.layout.fragment_offline, container, false);
        unbinder = ButterKnife.bind(this, view);
        initUI();
        return view;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initUI() {
        drawView.setOnTouchListener(touchPad());
        listOfImages = new ArrayList<>();
        listOfImages.add(colorBlue);
        listOfImages.add(colorYellow);
        listOfImages.add(colorRed);
        listOfImages.add(colorGreen);
        listOfImages.add(colorBrown);
        listOfImages.add(colorCyan);
        listOfImages.add(colorGray);
        listOfImages.add(colorOrange);
        listOfImages.add(colorDarkPink);
        listOfImages.add(colorVinous);
        colorBlue.setImageDrawable(getResources().getDrawable(R.drawable.okay));
        chosenColor=getResources().getColor(R.color.colorBlue);
    }

    @SuppressLint("ClickableViewAccessibility")
    @NonNull
    private View.OnTouchListener touchPad() {
        return (v, event) -> {
            touchX = event.getX();
            touchY = event.getY();
            textView.setText("X: " + touchX + "| Y: " + touchY);

            int widthHeigth = drawView.getWidth();
            int cellSize = widthHeigth / FIELD_SIZE;
            for (int i = 0; i < arrayBox.length; i++) {
                for (int j = 0; j < arrayBox.length; j++) {
                    if (touchX > j * cellSize && touchX < (j + 1) * cellSize) {
                        if (touchY > i * cellSize && touchY < (i + 1) * cellSize) {
                            drawView.fill(i, j, chosenColor);
                        }
                    }
                }
            }

            return false;
        };
    }

    @OnClick({R.id.colorBlue, R.id.colorYellow, R.id.colorRed, R.id.colorGreen, R.id.colorBrown, R.id.colorCyan, R.id.colorGray, R.id.colorOrange, R.id.colorWhite, R.id.colorVinous})
    public void palette(View view) {
        removeAllSrc();
        switch (view.getId()) {
            case R.id.colorBlue:
                chosenColor = getResources().getColor(R.color.colorBlue);
                colorBlue.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorYellow:
                chosenColor = getResources().getColor(R.color.colorYellow);
                colorYellow.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorRed:
                chosenColor = getResources().getColor(R.color.colorRed);
                colorRed.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorGreen:
                chosenColor = getResources().getColor(R.color.colorGreen);
                colorGreen.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorBrown:
                chosenColor = getResources().getColor(R.color.colorBrown);
                colorBrown.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorCyan:
                chosenColor = getResources().getColor(R.color.colorCyan);
                colorCyan.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorGray:
                chosenColor = getResources().getColor(R.color.colorGray);
                colorGray.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorOrange:
                chosenColor = getResources().getColor(R.color.colorOrange);
                colorOrange.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorWhite:
                chosenColor = getResources().getColor(R.color.colorWhite);
                colorDarkPink.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
            case R.id.colorVinous:
                chosenColor = getResources().getColor(R.color.colorVinous);
                colorVinous.setImageDrawable(getResources().getDrawable(R.drawable.okay));
                break;
        }
    }
    public void removeAllSrc(){
        for(ImageView v:listOfImages){
            v.setImageDrawable(null);
        }
    }


}
