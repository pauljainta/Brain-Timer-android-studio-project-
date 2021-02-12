package com.example.braintimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textView1,textView2,textView3,textView4,timer,question,track,rightwrong;
    GridLayout gridLayout;
    Button button;
    int total_question,total_correct_ans;
    boolean isCorrect;




    public void boardInit()
    {


           isCorrect=false;
           track.setText(total_correct_ans+"/"+total_question);
           Log.i("track","OK"+total_correct_ans+"/"+total_question);
               Random random=new Random();


                   int x = random.nextInt(20);
                   int y = random.nextInt(10);
                   int result = x + y;
                   question.setText(x + "+" + y + "=");
                   Log.i("ques", "OK" + x + "+" + y + "=");
                   int res_index = random.nextInt(gridLayout.getChildCount());
                   TextView res_textView = (TextView) gridLayout.getChildAt(res_index);
                   res_textView.setText(result + "");
                   for (int i = 0; i < gridLayout.getChildCount(); i++) {
                       if (i != res_index) {
                           TextView textView = (TextView) gridLayout.getChildAt(i);
                           int fake_res = random.nextInt(30);
                           while (fake_res == result) {
                               fake_res = random.nextInt(30);
                           }
                           textView.setText(fake_res + "");


                       }
                   }

                   for (int i = 0; i < gridLayout.getChildCount(); i++) {
                       TextView textView = (TextView) gridLayout.getChildAt(i);
                       int finalI = i;
                       textView.setOnClickListener(new View.OnClickListener() {
                           public void onClick(View view) {
                               if(!button.getText().toString().equalsIgnoreCase("PLAY AGAIN")) {
                                   if (finalI == res_index) {
                                       rightwrong.setText("Right");
                                       total_correct_ans += 1;
                                       total_question += 1;

                                   } else {
                                       rightwrong.setText("Wrong");
                                       total_question += 1;
                                   }

                                   track.setText(total_correct_ans + "/" + total_question);
                                   isCorrect = true;
                               }
                           }
                       });
                   }






    }



    public void GO(View view)
    {
          button.setVisibility(View.INVISIBLE);
         gridLayout.setVisibility(View.VISIBLE);
          textView1.setVisibility(View.VISIBLE);
          textView2.setVisibility(View.VISIBLE);
          textView3.setVisibility(View.VISIBLE);
          textView4.setVisibility(View.VISIBLE);
          timer.setVisibility(View.VISIBLE);
          question.setVisibility(View.VISIBLE);
          track.setVisibility(View.VISIBLE);
          rightwrong.setVisibility(View.VISIBLE);

        total_correct_ans=total_question=0;
        isCorrect=true;

        rightwrong.setText("");
        button.setText("GO");



           Random random=new Random();

          int time_limit=10+random.nextInt(30);




          new CountDownTimer(time_limit*1000,1000) {

              @Override
              public void onTick(long millisUntilFinished) {
                  int t= (int) (millisUntilFinished/1000);
                  String time=t+"s";
                  timer.setText(time);
                 if(isCorrect)
                  {
                      boardInit();

                  }


              }

              @Override
              public void onFinish() {
                  button.setText("PLAY AGAIN");
                  button.setVisibility(View.VISIBLE);
              }
          }.start();







     


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout=findViewById(R.id.gridlayout);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        button=findViewById(R.id.button);
        timer=findViewById(R.id.timer);
        question=findViewById(R.id.question);
        rightwrong=findViewById(R.id.rightwrong);
        track=findViewById(R.id.track);

        gridLayout.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        track.setVisibility(View.INVISIBLE);
        rightwrong.setVisibility(View.INVISIBLE);



    }
}