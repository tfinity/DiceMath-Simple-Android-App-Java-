package com.tfinity.dicemath_a020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class exam extends AppCompatActivity {
    Button choice1,choice2,choice3,next;
    TextView operator,result;
    ImageView img1,img2;
    int i1,i2,op;
    int r;
    int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        choice1=findViewById(R.id.choice1);
        choice2=findViewById(R.id.choice2);
        choice3=findViewById(R.id.choice3);
        next=findViewById(R.id.exam_next);
        operator=findViewById(R.id.exam_operator);
        result=findViewById(R.id.correct);
        img1=findViewById(R.id.exam_img1);
        img2=findViewById(R.id.exam_img2);
        Random ran=new Random();
        i1 = ran.nextInt(6)+1;
        i2 = ran.nextInt(6)+1;
        op = ran.nextInt(4);
        setData(i1,i2,op);
    }
    protected void setData(int im1,int im2,int op){
        operator.setText(Integer.toString(op));
        int id1=getResources().getIdentifier("com.tfinity.dicemath_a020:drawable/_"+im1,null,null);
        img1.setImageResource(id1);
        int id2=getResources().getIdentifier("com.tfinity.dicemath_a020:drawable/_"+im2,null,null);
        img2.setImageResource(id2);
        if(op==0){
            operator.setText("+");
            r=im1+im2;
            choice1.setText(Integer.toString(r+5));
            choice2.setText(Integer.toString(r));
            choice3.setText(Integer.toString(r-5));
        }
        else if(op==1){
            operator.setText("-");
            r=im1-im2;
            choice1.setText(Integer.toString(r+5));
            choice2.setText(Integer.toString(r));
            choice3.setText(Integer.toString(r-5));
        }
        else if(op==2){
            operator.setText("x");
            r=im1*im2;
            choice1.setText(Integer.toString(r+5));
            choice2.setText(Integer.toString(r));
            choice3.setText(Integer.toString(r-5));
        }
        else if(op==3){
            operator.setText("÷");
            r=im1/im2;
            choice1.setText(Integer.toString(r+5));
            choice2.setText(Integer.toString(r));
            choice3.setText(Integer.toString(r-5));
        }

    }

    public void onClick(View view) {
        Button b=(Button)view;
        if(Integer.parseInt(b.getText().toString())==r){
            result.setText("Correct");
        }
        else{
            result.setText("Not Correct");
        }
    }

    public void next(View view) {
        result.setText(" ");
        if(count==10){
            next.setText("Finish");
        }
        if(count>10){
            finish();
        }
        Random ran=new Random();
        i1 = ran.nextInt(6)+1;
        i2 = ran.nextInt(6)+1;
        op = ran.nextInt(4);
        setData(i1,i2,op);
        count++;
    }
}