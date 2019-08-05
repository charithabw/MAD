package com.example.mad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        button = findViewById(R.id.btnNewGame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLevelOne();
            }
        });
    }
    public void openLevelOne(){

        Intent intent = new Intent(MainActivity.this, Activity.class);
        startActivity(intent);
    }
}
