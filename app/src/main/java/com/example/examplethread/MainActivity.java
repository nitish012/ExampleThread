package com.example.examplethread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  boolean m=false;
    private Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        Log.i("thread",String.valueOf(Thread.currentThread().getId()));

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.start)
        {

            Log.i("thread","click");
            m=true;

            new Thread(new Runnable() {
                @Override
                public void run() {

                    //start.setText("50");
                    Handler handler=new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            start.setText("50");
                        }
                    });
                    while (m)
                    {

                        Log.i("thread",String.valueOf(Thread.currentThread().getId()));
                    }
                }
            }).start();



        }
        if (v.getId()==R.id.stop){

            Log.i("stop", "onClick: ");
            m=false;
//            while(m==false){
//                break;
//            }
        }
    }
}
