package com.example.mad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Level_01 extends AppCompatActivity {

    Button nextBtn,prvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_01);
        nextBtn=(Button)findViewById(R.id.btnNext);
    }
}
