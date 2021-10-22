package com.example.scrollingtext;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button edit = findViewById(R.id.editTextButton);
        EditText text = findViewById(R.id.article);
        text.setFocusable(false);
        edit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.article);
                if(text.getFocusable() == View.NOT_FOCUSABLE){
                    edit.setText("Save");
                    text.setFocusableInTouchMode(true);
                }else {
                    edit.setText("Edit");
                    text.setFocusable(false);
                }
            }
        });
    }
}