package com.example.mad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LevelUI extends AppCompatActivity {
Button btnLeve1,btnLeve2,btnLeve3,btnLeve4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_ui);

        btnLeve1 = (Button) findViewById(R.id.btnLevel1);
        btnLeve2 = (Button) findViewById(R.id.btnLevel2);
        btnLeve3 = (Button) findViewById(R.id.btnLevel3);
        btnLeve4 = (Button) findViewById(R.id.btnLevel4);

        btnLeve1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Level_01.class);
                startActivity(intent);
                Toast.makeText(LevelUI.this, "Starting Level 1...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnLeve2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Level_02.class);
                startActivity(intent);
                Toast.makeText(LevelUI.this, "Starting Level 2...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnLeve3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Level_03.class);
                startActivity(intent);
                Toast.makeText(LevelUI.this, "Starting Level 3...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnLeve4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Level_04.class);
                startActivity(intent);
                Toast.makeText(LevelUI.this, "Starting Level 4...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
