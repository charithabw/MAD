package com.example.mad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button nextbutton, aboutbutton, helpbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextbutton = (Button)findViewById(R.id.button);
        aboutbutton = (Button)findViewById(R.id.btnAbout);
        helpbutton = (Button)findViewById(R.id.btnHelp);


       nextbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent =new Intent(getApplicationContext(),Level_01.class);
               startActivity(intent);
               finish();
               Toast.makeText(MainActivity.this, "Start the GAME", Toast.LENGTH_SHORT).show();

           }
       });
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),About.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();

            }
        });
        helpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),Help.class);
                startActivity(intent);

                finish();
                Toast.makeText(MainActivity.this, "help", Toast.LENGTH_SHORT).show();
            }
        });





}}
