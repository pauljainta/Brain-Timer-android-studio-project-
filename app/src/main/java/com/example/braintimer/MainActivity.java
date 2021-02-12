package com.example.braintimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textView1,textView2,textView3,textView4,timer,question,track,rightwrong;
    GridLayout gridLayout;
    Button button;
    CountDownTimer countDownTimer;
    Thread thread;

//    public void Process(int type)
//    {
//
//        if(type==1)
//        {
//
//
//        }
//
//    }

    public void GO(View view)
    {
          button.setVisibility(View.INVISIBLE);
//          gridLayout.setVisibility(View.VISIBLE);
          textView1.setVisibility(View.VISIBLE);
          textView2.setVisibility(View.VISIBLE);
          textView3.setVisibility(View.VISIBLE);
          textView4.setVisibility(View.VISIBLE);
          timer.setVisibility(View.VISIBLE);
          question.setVisibility(View.VISIBLE);
          track.setVisibility(View.VISIBLE);
          rightwrong.setVisibility(View.VISIBLE);
        Random random=new Random();

          int time_limit=10+random.nextInt(30);

          countDownTimer=new CountDownTimer(time_limit*1000,1000) {

              @Override
              public void onTick(long millisUntilFinished) {
                  int t= (int) (millisUntilFinished/1000);
                  String time=t+"s";
                  timer.setText(time);
              }

              @Override
              public void onFinish() {

                  button.setText("PLAY AGAIN");
                  button.setVisibility(View.VISIBLE);
              }
          };

          countDownTimer.start();

//          int x=random.nextInt();
//          int y=random.nextInt();
//          int result=x+y;

     


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gridLayout=findViewById(R.id.gridlayout);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        button=findViewById(R.id.button);
        timer=findViewById(R.id.timer);
        question=findViewById(R.id.question);
        rightwrong=findViewById(R.id.rightwrong);
        track=findViewById(R.id.track);

    }
}