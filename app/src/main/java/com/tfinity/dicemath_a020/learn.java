package com.tfinity.dicemath_a020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class learn extends AppCompatActivity {

    int i=1,j=1;
    String op;
    ImageView img1,img2;
    TextView operator,result;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        operator=findViewById(R.id.operator);
        result=findViewById(R.id.result);
        next=findViewById(R.id.next);
        Random ran=new Random();
        int n = ran.nextInt(4);
        if(n==0){
            op="+";
        }
        else if(n==1){
            op="-";
        }
        else if(n==2){
            op="x";
        }else if(n==3){
            op="÷";
        }
        setData(1,1,op);
    }

    protected void setData(int im1,int im2,String op){
        operator.setText(op);
        int id1=getResources().getIdentifier("com.tfinity.dicemath_a020:drawable/_"+im1,null,null);
        img1.setImageResource(id1);
        int id2=getResources().getIdentifier("com.tfinity.dicemath_a020:drawable/_"+im2,null,null);
        img2.setImageResource(id2);
        if(op=="+"){
            result.setText(Integer.toString(im1+im2));
        }
        else if(op=="-"){
            result.setText(Integer.toString(im1-im2));
        }
        else if(op=="x"){
            result.setText(Integer.toString(im1*im2));
        }
        else if(op=="÷"){
            result.setText(Integer.toString(im1/im2));
        }
    }

    public void next(View view) {
        Random ran=new Random();
        int n = ran.nextInt(4);
        if(n==0){
            op="+";
        }
        else if(n==1){
            op="-";
        }
        else if(n==2){
            op="x";
        }else if(n==3){
            op="÷";
        }
        //j++;
        if(j==6){
            if(i==6){
            next.setText("Finish");
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            }else{
                i++;
            }
        }
        else{
            i++;
            if(i>6){
                i=1;
                j++;
            }
        }
        setData(j,i,op);
    }
}