package com.tfinity.dicemath_a020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openGit(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/tfinity"));
        startActivity(intent);
    }

    public void learn(View view) {
        Intent intent=new Intent(MainActivity.this,learn.class);
        startActivity(intent);
    }

    public void exam(View view) {
        Intent intent=new Intent(MainActivity.this,exam.class);
        startActivity(intent);
    }
}