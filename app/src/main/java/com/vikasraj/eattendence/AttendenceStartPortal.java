package com.vikasraj.eattendence;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.*;
import android.bluetooth.BluetoothAdapter;


public class AttendenceStartPortal extends AppCompatActivity {

    public CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 300000; //5 mins
    public boolean timerRunning;
    public TextView counntdowntext;
    public Button countdownbutton,rand;
    public TextView te;
    public Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_start_portal);
         counntdowntext = (TextView) findViewById(R.id.countertext);
         countdownbutton = (Button) findViewById(R.id.startportal);
         rand = (Button)findViewById(R.id.random1);

         rand.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View view){

                 te = (TextView) findViewById(R.id.random2);
//                 int output = r.nextInt();
                 te.setText("Random");
//                 AlertDialog.Builder builder = new AlertDialog.Builder(AttendenceStartPortal.this);
//                 builder.setMessage("Your Ticket ID ")
//                         .setNegativeButton("Book again ", null)
//                         .create()
//                         .show();

             }
         });


        countdownbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startStop();
                btname();
//
            }
        });

    }

    public void startStop() {
//        if (timerRunning) {
//            stopTimer();
//        } else {
            startTimer();
//        }

    }

    public void startTimer() {

        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
//        countdownbutton.setText("Pause");
        timerRunning = true;
    }

//    public void stopTimer(){
//        countDownTimer.cancel();
//        countdownbutton.setText("Start");
//        timerRunning = false;
//
//    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000/1000;

        String timeLeftText;
        timeLeftText = ""+minutes;
        timeLeftText += ":";
        if(seconds<10)timeLeftText+="0";
        timeLeftText +=seconds;
        counntdowntext.setText(timeLeftText);


    }

    public void btname(){


        Random objGenerator = new Random();
            int randomNumber = objGenerator.nextInt(100000);
            int randomNumber1 = objGenerator.nextInt(100000);


        BluetoothAdapter bluetoothAdapter = null;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothAdapter.setName("236"+randomNumber+randomNumber1);//Careful Here
    }

}


