package com.example.eafor.clientserverapp.fragments;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eafor.clientserverapp.DrawView;
import com.example.eafor.clientserverapp.MainActivity;
import com.example.eafor.clientserverapp.R;
import com.example.eafor.clientserverapp.server_connection.Initializable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOnline extends android.support.v4.app.Fragment implements Initializable {
    public static int chosenColor;
    public static final int FIELD_SIZE = MainActivity.FIELD_SIZE;
    public float touchX;
    public float touchY;
    int[][] arrayBox = new int[FIELD_SIZE][FIELD_SIZE];

    Unbinder unbinder;
    List<ImageView> listOfImages;


    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    final String IP_ADDRESS = "192.168.0.101";
    final int PORT = 8189;
    @BindView(R.id.colorBlue) ImageView colorBlue;
    @BindView(R.id.colorYellow) ImageView colorYellow;
    @BindView(R.id.colorRed) ImageView colorRed;
    @BindView(R.id.colorGreen) ImageView colorGreen;
    @BindView(R.id.colorBrown) ImageView colorBrown;
    @BindView(R.id.colorCyan) ImageView colorCyan;
    @BindView(R.id.colorGray) ImageView colorGray;
    @BindView(R.id.colorOrange) ImageView colorOrange;
    @BindView(R.id.colorWhite) ImageView colorDarkPink;
    @BindView(R.id.colorVinous) ImageView colorVinous;
    @BindView(R.id.color_box) LinearLayout colorBox;
    @BindView(R.id.canvas) DrawView canvas;
    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.text_connecting) TextView textView_connecting;
    @BindView(R.id.button_connecting) Button button_connecting;
    @BindView(R.id.loginField) EditText loginField;
    @BindView(R.id.passwordField) EditText passwordField;
    private boolean isAuthorized;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ButterKnife.bind(getActivity());
        setAuthorized(false);
    }

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        if (!isAuthorized) {
            handledRedraw(1);
        } else {
            handledRedraw(2);
        }
    }

    //Отправка кода на сервер и получение форматируется так: /send i(по вертикали) j(по горизонтали) Color
    public void connect() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            setAuthorized(false);
            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/authok")) {
                            setAuthorized(true);
                            break;
                        } else {
//                            for (TextArea o : textAreas) {
//                                o.appendText(str + "\n");
//                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/")) {
                            if (str.equals("/serverclosed")) break;
                            if(str.startsWith("/array_data")){
                                String[] tokens = str.split(" ");
                                canvas.fill(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
                            }
                            if (str.startsWith("/send ")) {
                                String[] tokens = str.split(" ");
                                canvas.fill(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                            }
                        } else {
//                            chatArea.appendText(str + "\n");
                            //do nothing here
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setAuthorized(false);
                }
            });
            thread.setDaemon(true);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            if(out!=null)out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth() {
        if (socket == null || socket.isClosed()) {
            connect();
        }
        try {
            if(out!=null){
                out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
                loginField.setText("");
                passwordField.setText("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void selectClient(MouseEvent mouseEvent) {
//        if(mouseEvent.getClickCount() == 2) {
//            MiniStage ms = new MiniStage(clientsList.getSelectionModel().getSelectedItem(), out, textAreas);
//            ms.show();
//        }
//    }


    public FragmentOnline() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online, container, false);
        unbinder = ButterKnife.bind(this, view);
        initUI();
        return view;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initUI() {
        canvas.setOnTouchListener(touchPad());
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
        chosenColor = getResources().getColor(R.color.colorBlue);
        button_connecting.setOnClickListener(V->tryToAuth());

        textView.setText("You aren't connected");
        colorBox.setVisibility(View.INVISIBLE);
        canvas.setVisibility(View.INVISIBLE);
        textView_connecting.setVisibility(View.VISIBLE);
        button_connecting.setVisibility(View.VISIBLE);
        loginField.setVisibility(View.INVISIBLE);
        passwordField.setVisibility(View.INVISIBLE);
    }

    @SuppressLint("ClickableViewAccessibility")
    @NonNull
    private View.OnTouchListener touchPad() {
        return (v, event) -> {
            touchX = event.getX();
            touchY = event.getY();
            textView.setText("X: " + touchX + "| Y: " + touchY);

            int widthHeigth = canvas.getWidth();
            int cellSize = widthHeigth / FIELD_SIZE;
            for (int i = 0; i < arrayBox.length; i++) {
                for (int j = 0; j < arrayBox.length; j++) {
                    if (touchX > j * cellSize && touchX < (j + 1) * cellSize) {
                        if (touchY > i * cellSize && touchY < (i + 1) * cellSize) {
                            canvas.fill(i, j, chosenColor);
                            String msg = "/send " + i + " " + j + " " + chosenColor;
                            sendMsg(msg);
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

    public void removeAllSrc() {
        for (ImageView v : listOfImages) {
            v.setImageDrawable(null);
        }
    }

    public void handledRedraw(int code){
        new Handler(Looper.getMainLooper()).post(() -> {
            if(code==1){
                textView.setText("Unable to connect");
                colorBox.setVisibility(View.INVISIBLE);
                canvas.setVisibility(View.INVISIBLE);
                textView_connecting.setVisibility(View.VISIBLE);
                button_connecting.setVisibility(View.VISIBLE);
                loginField.setVisibility(View.INVISIBLE);
                passwordField.setVisibility(View.INVISIBLE);
            } else if(code==2){
                colorBox.setVisibility(View.VISIBLE);
                canvas.setVisibility(View.VISIBLE);
                textView_connecting.setVisibility(View.INVISIBLE);
                button_connecting.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        sendMsg("/end");
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        null.unbind();
//    }
}