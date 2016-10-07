package com.mlabs.bbm.firstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class OnTouchActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.ontouch_activity);

                final ImageView imageTouch = (ImageView) findViewById(R.id.imageTouch);


                imageTouch.setOnTouchListener(new View.OnTouchListener(){
                        float initx,inity,finx,finy;

                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {

                                int x = motionEvent.getAction();

                                switch(x){
                                        case MotionEvent.ACTION_DOWN:
                                                initx = motionEvent.getX();
                                                inity = motionEvent.getY();
                                                Toast.makeText(getApplicationContext(), "Value of X = " + initx + "Y = "+ inity, Toast.LENGTH_SHORT).show();
                                                return true;
                                        case MotionEvent.ACTION_UP:
                                                finx = motionEvent.getX();
                                                finy = motionEvent.getY();
                                                if(initx>finx){
                                                        Toast.makeText(getApplicationContext(), "SWIPED FROM RIGHT TO LEFT", Toast.LENGTH_SHORT).show();
                                                }else if(initx<finx){
                                                        Toast.makeText(getApplicationContext(), "SWIPED FROM LEFT TO RIGHT", Toast.LENGTH_SHORT).show();
                                                }else {
                                                        Toast.makeText(getApplicationContext(), "Origin", Toast.LENGTH_SHORT).show();
                                                }
                                                if(inity<finy){
                                                        Toast.makeText(getApplicationContext(), "SWIPED FROM TOP TO BOTTOM", Toast.LENGTH_SHORT).show();
                                                }else if(inity>finy) {
                                                        Toast.makeText(getApplicationContext(), "SWIPED FROM BOTTOM TO TOP", Toast.LENGTH_SHORT).show();
                                                }else{
                                                        Toast.makeText(getApplicationContext(), "Origin", Toast.LENGTH_SHORT).show();
                                                }
                                                return true;
                                }
                                return true;
                        }

                });
        }

        @Override
        protected  void onPause(){
                super.onPause();
                finish();
        }

}
