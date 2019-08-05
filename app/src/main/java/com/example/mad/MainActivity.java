package com.example.mad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button nextbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextbutton = (Button)findViewById(R.id.button);


       nextbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent =new Intent(getApplicationContext(),Level_01.class);
               startActivity(intent);
               finish();

           }
       });
    }




}
