package com.example.mad;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AlertDialog;
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

public class Level_01_3 extends AppCompatActivity implements SensorEventListener {

    DBHelper myDB;
    private SensorManager sensorManager;
    private boolean color = false;
    // private View view;
    private long lastUpdate;


    // MediaPlayer player;

    private int gameValue = 1;
    Button btnOk, nextBtn, prvBtn;
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
        setContentView(R.layout.activity_level_01_3);
        myDB = new DBHelper(this);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        // gameValue = Integer.parseInt(getIntent().getStringExtra("gameValue"));
        r2 = (FrameLayout) findViewById(R.id.parentLayout);
        iv = new ImageView(this);
        score = (TextView) findViewById(R.id.txtScore);
        score.setText(String.valueOf(iScore));
        btnOk = (Button) findViewById(R.id.btnOk);
        nextBtn=(Button)findViewById(R.id.btnNext);
        prvBtn=(Button)findViewById(R.id.btnBack);

        upperImageViews = (ImageView) findViewById(R.id.imgBox);

        lowerImageView[0] = (ImageView) findViewById(R.id.imgNum_6);
        lowerImageView[1] = (ImageView) findViewById(R.id.imgNum_12);
        lowerImageView[2] = (ImageView) findViewById(R.id.imgNum_18);
        lowerImageView[3] = (ImageView) findViewById(R.id.imgNum_8);
        lowerImageView[4] = (ImageView) findViewById(R.id.imgNum_15);

        int upperImages[][] = {
                {R.drawable.box}
        };

        int lowerImages[][] = {
                {R.drawable.n6, R.drawable.n12, R.drawable.n18, R.drawable.n8, R.drawable.n15}
        };


        for (int img = 0; img < upperImages[gameValue - 1].length; img++) {
            //upperImageViews[img].setImageResource(upperImages[gameValue - 1][img]);
            lowerImageView[img].setImageResource(lowerImages[gameValue - 1][img]);
        }
        for (int i = 0; i < lowerImages[gameValue - 1].length; i++) {
            lowerImageView[i].setTag(lowerImages[gameValue - 1][i]);


            lowerImageView[i].setOnTouchListener(new Level_01_3.MyTouchListener());

        }
        FrameLayout fl1 = (FrameLayout) findViewById(R.id.parentLayout);


        if (fl1 != null) {
            fl1.setOnDragListener(new Level_01_3.MyDragListener());
            //upperImageViews.setOnDragListener(new MyDragListener());

        }

        FrameLayout flBox = (FrameLayout) findViewById(R.id.boxLayout);
        if (flBox != null) {
            flBox.setOnDragListener(new Level_01_3.MyDragListener2());

        }

        upperImageViews.setOnDragListener(new Level_01_3.MyDragListener2());

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level_01_3.this);
                builder.setMessage("Do you want to Submit !!!").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //finish();
                        addData();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Your Score " +iScore);
                alertDialog.show();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),Level_02.class);
                startActivity(intent);
                finish();

            }
        });
        prvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),Level_01_2.class);
                startActivity(intent);
                finish();

            }
        });

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
                    iv.setOnTouchListener(new Level_01_3.MyNextTouchListener());
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
                    iv.setOnTouchListener(new Level_01_3.MyNextTouchListener());
                    // iv.setBackgroundColor(Color.YELLOW);
                    params2 = new  FrameLayout.LayoutParams(  mapView.getWidth(), mapView.getHeight());
                    params2.leftMargin = evX-(mapView.getWidth()/2);
                    params2.topMargin = evY-(mapView.getHeight()/2);
                    r2.addView(iv, params2);

                    if (view.getId() == R.id.imgNum_6) {
                        Toast.makeText(Level_01_3.this, "6", Toast.LENGTH_SHORT).show();
                        upperImageViews.setImageResource(R.drawable.box);
                        iScore = iScore + 2;
                        // Toast.makeText(Level_04.this, "Success" ,Toast.LENGTH_SHORT).show();
                        // addData();

                    } else if (view.getId() == R.id.imgNum_12) {
                        Toast.makeText(Level_01_3.this, "12", Toast.LENGTH_SHORT).show();
                        upperImageViews.setImageResource(R.drawable.box);
                        iScore = iScore + 2;
                    } else if (view.getId() == R.id.imgNum_18) {
                        Toast.makeText(Level_01_3.this, "18", Toast.LENGTH_SHORT).show();
                        upperImageViews.setImageResource(R.drawable.box);
                        iScore = iScore + 2;

                    } else if (view.getId() == R.id.imgNum_8) {
                        Toast.makeText(Level_01_3.this, "8", Toast.LENGTH_SHORT).show();
                        upperImageViews.setImageResource(R.drawable.redbox);
                        iScore = iScore - 2;
                    } else if (view.getId() == R.id.imgNum_15) {
                        Toast.makeText(Level_01_3.this, "15", Toast.LENGTH_SHORT).show();
                        upperImageViews.setImageResource(R.drawable.redbox);
                        iScore = iScore - 2;
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
        //myDB.addInfo("charithamm", "bandara", "1", "14");
        Toast.makeText(Level_01_3.this, "Success" ,Toast.LENGTH_SHORT).show();
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

