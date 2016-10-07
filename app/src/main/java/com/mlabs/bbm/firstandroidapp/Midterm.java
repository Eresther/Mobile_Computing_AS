package com.mlabs.bbm.firstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Midterm extends AppCompatActivity {
    float x1 =0, x2=0, y1=0, y2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midterm);

        final EditText init = (EditText) findViewById(R.id.editText);
        final EditText fin = (EditText) findViewById(R.id.editText2);
        final EditText diff = (EditText) findViewById(R.id.editText3);
        final EditText mot = (EditText) findViewById(R.id.editText4);
        final EditText quad = (EditText) findViewById(R.id.editText5);

        final ImageView image = (ImageView) findViewById(R.id.imageView3);
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int event = motionEvent.getAction();
                switch (event){
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        y1 = motionEvent.getY();
                        init.setText(""+String.format("X: %2f, Y: %2f",x1,y1));
                        return true;
                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();
                        y2 = motionEvent.getY();
                        fin.setText(""+String.format("X: %2f, Y: %2f",x2,y2));
                        motionDisplay(x1,x2,y1,y2);
                        quadrantDisplay(x1,x2,y1,y2);
                }
                return false;
            }

            public void motionDisplay(float x1, float x2, float y1, float y2){
                String msg="";
                float X=0, Y=0;
                if (x1<x2) {
                    msg += String.format("Left to Right");
                    X = x2 - x1;
                } else if (x1>x2){
                    msg += String.format("Right to Left");
                    X = x1 - x2;
                }

                if (y1<y2){
                    msg += String.format("   Up to Down");
                    Y = y2 - y1;
                } else  if (y1>y2){
                    msg += String.format("   Down to Up");
                    Y = y1 - y2;
                }
                mot.setText(""+msg);

                diff.setText(""+String.format("X: %2f, Y: %.2f",X,Y));
            }

            public void quadrantDisplay(float x1, float x2, float y1, float y2){
                if (x1<x2 && y1<y2){
                    quad.setText("Quadrant 4");
                } else if (x1>x2 && y1<y2){
                    quad.setText("Quadrant 3");
                } else if (x1>x2 && y1>y2){
                    quad.setText("Quadrant 2");
                } else if(x1<x2 && y1>y2){
                    quad.setText("Quadrant 1");
                } else{
                    quad.setText("");
                }

            }
        });
    }
}
