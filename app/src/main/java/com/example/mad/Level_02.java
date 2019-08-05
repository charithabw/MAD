package com.example.mad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level_02 extends AppCompatActivity {
Button nextBtn,prvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_02);

        nextBtn=(Button)findViewById(R.id.btnNext);
        prvBtn=(Button)findViewById(R.id.btnBack);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),Level_03.class);
                startActivity(intent);
                finish();

            }
        });
        prvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),Level_01.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
