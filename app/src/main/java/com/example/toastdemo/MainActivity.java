package com.example.toastdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner ;
    private TextView textView;
    private Button button ;
    private ToastUtils toastUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        Button button1 = new Button(this);
        button1.setText("22222222");

        View view = getLayoutInflater().inflate(R.layout.toast_layout,null,false);
        ImageView imageView = view.findViewById(R.id.imageview);
        TextView textView = view.findViewById(R.id.textview1);
        ToastUtils toastUtils = new ToastUtils.Builder(this,5000)
                .setView(view)
                .addView(button1,2)
                .setToastText(Color.RED,10,textView,"自定义Toast")
                .build();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastUtils.show();
            }
        });




    }


}