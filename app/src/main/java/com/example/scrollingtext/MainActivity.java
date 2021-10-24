package com.example.scrollingtext;

import android.content.Context;
import android.content.SharedPreferences;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPref = this.getSharedPreferences("My_pref",Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button edit = findViewById(R.id.editTextButton);
        EditText text = findViewById(R.id.article);
        if(sharedPref.getString("text",null) != null){
            text.setText(sharedPref.getString("text",null));
        }
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
                    sharedPref.edit().putString("text",text.getText().toString()).commit();
                }
            }
        });
    }
}