package com.example.mad;


import android.content.ClipData;
import android.content.Intent;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;



public class Level_04 extends AppCompatActivity implements SensorEventListener {
    DBHelper myDB ;
    private SensorManager sensorManager;
    private boolean color = false;
   // private View view;
    private long lastUpdate;


    // MediaPlayer player;

    private int gameValue =1;
    Button btnOk;
    FrameLayout r2;
    ImageView iv;
    TextView score;
    FrameLayout.LayoutParams params2;

    ImageView upperImageViews;
    ImageView lowerImageView[] = new ImageView[5];
    private static int iScore = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_04);
        myDB = new DBHelper(this);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        // gameValue = Integer.parseInt(getIntent().getStringExtra("gameValue"));
        r2 = (FrameLayout) findViewById(R.id.parentLayout);
        iv = new ImageView(this);
        score = (TextView) findViewById(R.id.txtScore);
        score.setText(String.valueOf(iScore));

        upperImageViews = (ImageView) findViewById(R.id.imgBox);

        lowerImageView[0] = (ImageView) findViewById(R.id.imgNum_04);
        lowerImageView[1] = (ImageView) findViewById(R.id.imgNum_09);
        lowerImageView[2] = (ImageView) findViewById(R.id.imgNum_21);
        lowerImageView[3] = (ImageView) findViewById(R.id.imgNum_42);
        lowerImageView[4] = (ImageView) findViewById(R.id.imgNum_70);

        int upperImages[][] = {
                {R.drawable.box}
        };

        int lowerImages[][] = {
                {R.drawable.n4, R.drawable.n9, R.drawable.n21, R.drawable.n42, R.drawable.n70}
        };

//        int Shapes12[] = new int[4];
//        Shapes12[0] = R.drawable.n3;
//        Shapes12[1] = R.drawable.n4;
//        Shapes12[2] = R.drawable.n5;
//        Shapes12[3] = R.drawable.n6;

        for (int img = 0; img < upperImages[gameValue - 1].length; img++) {
            //upperImageViews[img].setImageResource(upperImages[gameValue - 1][img]);
            lowerImageView[img].setImageResource(lowerImages[gameValue - 1][img]);
        }
        for (int i = 0; i < lowerImages[gameValue - 1].length; i++) {
            lowerImageView[i].setTag(lowerImages[gameValue - 1][i]);


            lowerImageView[i].setOnTouchListener(new MyTouchListener());

        }
        FrameLayout fl1 = (FrameLayout) findViewById(R.id.parentLayout);


        if (fl1 != null) {
            fl1.setOnDragListener(new MyDragListener());
            //upperImageViews.setOnDragListener(new MyDragListener());

        }

        FrameLayout flBox = (FrameLayout) findViewById(R.id.boxLayout);
        if (flBox != null) {
            flBox.setOnDragListener(new MyDragListener2());

        }

        //upperImageViews.setOnDragListener(new MyDragListener2());

//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openNewWindow();
//            }
//        });
//
//    }
//
//    private void openNewWindow() {
//        MyNewWindow myNewWindow = new MyNewWindow();
//        myNewWindow.show(getSupportFragmentManager(), "test");
//    }
//        btnOk.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Toast.makeText(Level_04.this, "Success", Toast.LENGTH_SHORT).show();
//
//                }
//            });
    }


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                //  Point offset = new Point((int) motionEvent.getX(), (int) motionEvent.getY());

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
            else {
                // view.setVisibility(View.VISIBLE);
                return false;
            }
        }
    }


    private final class MyNextTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                //  Point offset = new Point((int) motionEvent.getX(), (int) motionEvent.getY());

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
            else {
                // view.setVisibility(View.VISIBLE);
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {


        @Override
        public boolean onDrag(View v, DragEvent event) {
            // rl.removeView(iv);

            final int evX = (int) event.getX();
            final int evY = (int) event.getY();


            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    View view = (View) event.getLocalState();
                    ImageView mapView = (ImageView)view;
                    int letrval = (int)view.getTag();
                    Log.e("Log",letrval+"");
                    iv = new ImageView(getApplicationContext());
                    iv.setImageResource(letrval);
                    iv.setTag(letrval);
                    iv.setOnTouchListener(new MyNextTouchListener());
                    //iv.setBackgroundColor(Color.YELLOW);
                    params2 = new  FrameLayout.LayoutParams(  mapView.getWidth(), mapView.getHeight());
                    params2.leftMargin = evX-(mapView.getWidth()/2);
                    params2.topMargin = evY-(mapView.getHeight()/2);
                    r2.addView(iv, params2);
                   // Toast.makeText(Level_04.this, "70", Toast.LENGTH_SHORT).show();

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    break;

                default:
                    break;
            }


            return true;
        }
    }
    class MyDragListener2 implements View.OnDragListener {


        @Override
        public boolean onDrag(View v, DragEvent event) {
            // rl.removeView(iv);

            final int evX = (int) event.getX();
            final int evY = (int) event.getY();


            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    View view = (View) event.getLocalState();
                    ImageView mapView = (ImageView)view;
                    int letrval = (int)view.getTag();
                    Log.e("Log",letrval+"");
                    iv = new ImageView(getApplicationContext());
                    iv.setImageResource(letrval);
                    iv.setTag(letrval);
                    iv.setOnTouchListener(new MyNextTouchListener());
                   // iv.setBackgroundColor(Color.YELLOW);
                    params2 = new  FrameLayout.LayoutParams(  mapView.getWidth(), mapView.getHeight());
                    params2.leftMargin = evX-(mapView.getWidth()/2);
                    params2.topMargin = evY-(mapView.getHeight()/2);
                    r2.addView(iv, params2);

                    if (view.getId() == R.id.imgNum_04) {
                        //Toast.makeText(Level_04.this, "04", Toast.LENGTH_SHORT).show();
                       // upperImageViews.setImageResource(R.drawable.redbox);
                        iScore = iScore - 2;
                       // Toast.makeText(Level_04.this, "Success" ,Toast.LENGTH_SHORT).show();
                        addData();

                    } else if (view.getId() == R.id.imgNum_09) {
                        Toast.makeText(Level_04.this, "09", Toast.LENGTH_SHORT).show();
                       // upperImageViews.setImageResource(R.drawable.redbox);
                        iScore = iScore - 2;
                    } else if (view.getId() == R.id.imgNum_21) {
                        Toast.makeText(Level_04.this, "21", Toast.LENGTH_SHORT).show();
                        //upperImageViews.setImageResource(R.drawable.redbox);
                        iScore = iScore - 2;

                    } else if (view.getId() == R.id.imgNum_42) {
                        Toast.makeText(Level_04.this, "42", Toast.LENGTH_SHORT).show();
                        //upperImageViews.setImageResource(R.drawable.box);
                        iScore = iScore + 2;
                    } else if (view.getId() == R.id.imgNum_70) {
                        Toast.makeText(Level_04.this, "70", Toast.LENGTH_SHORT).show();
                        //upperImageViews.setImageResource(R.drawable.box);
                        iScore = iScore + 2;
                    }
                        score.setText(String.valueOf(iScore));

                        break;
                case DragEvent.ACTION_DRAG_ENDED:

                    break;

                default:
                    break;
            }


            return true;
        }
    }

    public int getiScore(){
        return iScore;
    }
    public void addData(){
        myDB.addInfo("charithamm", "bandara", "1", "14");
        Toast.makeText(Level_04.this, "Success" ,Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(sensorEvent);
        }
    }
    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if (accelationSquareRoot >= 4) //
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Reset Success", Toast.LENGTH_SHORT)
                    .show();

            //playAudio("snap.mp3");
            finish();
            startActivity(getIntent());


            color = !color;
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
